package br.com.threads.servidor;

import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		System.out.println("Distribuindo tarefas para: " + socket);


		try {
			Scanner scanner = new Scanner(socket.getInputStream());


			while (scanner.hasNextLine()) {
				String comando = scanner.nextLine();
				System.out.println(comando);
			}

			scanner.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
