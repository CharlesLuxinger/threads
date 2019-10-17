package br.com.threads.cliente;

import java.net.Socket;

public class ClienteTarefas {
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 1234);

		System.out.println("Connection OK");

		socket.close();
	}
}
