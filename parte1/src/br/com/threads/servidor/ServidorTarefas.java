package br.com.threads.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {

	private ExecutorService threadPool;
	private ServerSocket server;

	// volatile: Desabilita o cache do atributo, alterando a memória diretamente
	// private volatile boolean executandoComando;

	// Lib concurrent
	// Substitui volatile
	private AtomicBoolean executandoComando;

	public ServidorTarefas() throws IOException {

		System.out.println("Starting Server");
		server = new ServerSocket(1234);

		threadPool = Executors.newFixedThreadPool(4);

		executandoComando = new AtomicBoolean(true);
	}


	public void run() throws IOException {
		while (executandoComando.get()) {
			try {
				Socket socket = server.accept();
				System.out.println("Accept a new client, port: " + socket.getPort());

				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool, socket, this);

				threadPool.execute(distribuirTarefas);
			} catch (SocketException e) {
				System.out.println("Server Off: " + !executandoComando.get());
			}
		}
	}

	public void shutdown() throws IOException {
		executandoComando.set(false);
		server.close();
		threadPool.shutdown();
	}

}
