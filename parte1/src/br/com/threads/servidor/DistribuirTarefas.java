package br.com.threads.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import br.com.threads.comando.ComandoC1;
import br.com.threads.comando.ComandoC2;

public class DistribuirTarefas implements Runnable {

	private Socket socket;
	private ServidorTarefas servidor;
	private ExecutorService threadPool;

	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.servidor = servidor;
	}

	@Override
	public void run() {

		System.out.println("Distribuindo tarefas para: " + socket);


		try {
			Scanner scanner = new Scanner(socket.getInputStream());

			PrintStream responseCliente = new PrintStream(socket.getOutputStream());


			while (scanner.hasNextLine()) {
				String comando = scanner.nextLine();

				switch (comando) {
				case "c1": {
					responseCliente.println("Processando C1");

					ComandoC1 comandoC1 = new ComandoC1(responseCliente);

					threadPool.execute(comandoC1);
					break;
				}

				case "c2": {
					responseCliente.println("Processando C2");

					ComandoC2 comandoC2 = new ComandoC2(responseCliente);

					threadPool.execute(comandoC2);
					break;
				}

				case "c3": {
					System.out.println("Processando C3");
					responseCliente.println("Processado C3");
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
