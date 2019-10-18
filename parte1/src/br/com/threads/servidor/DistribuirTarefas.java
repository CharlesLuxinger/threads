package br.com.threads.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import br.com.threads.comando.ComandoC1;
import br.com.threads.comando.ComandoC2ChamaDB;
import br.com.threads.comando.ComandoC2ChamaWS;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool;
	private BlockingQueue<String> filaComandos;

	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor,
			BlockingQueue<String> filaComandos) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.servidor = servidor;
		this.filaComandos = filaComandos;
	}

	@Override
	public void run() {

		System.out.println("Distribuindo tarefas para: " + socket);


		try {
			Scanner scanner = new Scanner(socket.getInputStream());

			PrintStream responseCliente = new PrintStream(socket.getOutputStream());


			while (scanner.hasNextLine()) {
				String comando = scanner.nextLine();
				System.out.println("Comando recebido: " + comando);

				switch (comando) {
				case "c1": {
					responseCliente.println("Processando C1");

					ComandoC1 comandoC1 = new ComandoC1(responseCliente);

					threadPool.execute(comandoC1);
					break;
				}

				case "c2": {
					responseCliente.println("Processando C2");

					ComandoC2ChamaWS c2WS = new ComandoC2ChamaWS(responseCliente);
					ComandoC2ChamaDB c2DB = new ComandoC2ChamaDB(responseCliente);

					Future<String> futureWS = threadPool.submit(c2WS);
					Future<String> futureDB = threadPool.submit(c2DB);


					threadPool.submit(new JuntaResultadosFutureWSDB(futureWS, futureDB, responseCliente));
					break;
				}

				case "c3": {
					filaComandos.put(comando);

					responseCliente.println("Adicionado a fila comando C3");
					break;
				}
				case "fim": {
					responseCliente.println("Shutdown Server");

					servidor.shutdown();
					break;
				}
				default:
					System.out.println("Comando inválido");
					break;
				}
			}

			responseCliente.close();
			scanner.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
