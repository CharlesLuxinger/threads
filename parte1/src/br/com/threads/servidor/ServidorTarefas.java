package br.com.threads.servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefas {

	public static void main(String[] args) throws Exception {


		System.out.println("Starting Server");
		ServerSocket server = new ServerSocket(1234);

		while (true) {
			Socket socket = server.accept();
			System.out.println("Accept a new client, port: " + socket.getPort());
		}

	}

}
