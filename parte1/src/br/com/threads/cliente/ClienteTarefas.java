package br.com.threads.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 1234);

		System.out.println("Connection OK");

		PrintStream stream = new PrintStream(socket.getOutputStream());
		stream.println("comando1");

		Scanner input = new Scanner(System.in);

		input.nextLine();

		stream.close();
		input.close();
		socket.close();
	}
}
