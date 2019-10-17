package br.com.threads.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {


		System.out.println("Starting Server");
		ServerSocket server = new ServerSocket(1234);

		// ExecutorService threadPool = Executors.newFixedThreadPool(2); - Qtd Fixa

		// Qtd dinâmica, elimina as threads inutilizadas
		ExecutorService threadPool = Executors.newCachedThreadPool();

		while (true) {
			Socket socket = server.accept();
			System.out.println("Accept a new client, port: " + socket.getPort());

			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);

			threadPool.execute(distribuirTarefas);
		}

	}

}
