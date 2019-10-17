package br.com.threads.cliente;

import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 1234);

		System.out.println("Connection OK");

		Scanner input = new Scanner(System.in);

		input.nextLine();

		socket.close();
	}
}
