package br.com.threads.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 1234);

		System.out.println("Connection OK");


		Thread threadComando = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Insira comandos:");
					PrintStream request = new PrintStream(socket.getOutputStream());

					Scanner input = new Scanner(System.in);

					while (input.hasNextLine()) {
						String line = input.nextLine();

						if (line.trim().equals("")) {
							break;
						}

						request.println(line);
					}

					request.close();
					input.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});


		Thread threadResposta = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Tratando Resposta Servidor");

					Scanner response = new Scanner(socket.getInputStream());

					while (response.hasNextLine()) {
						String line = response.nextLine();

						System.out.println(line);
					}

					response.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});

		threadComando.start();
		threadResposta.start();

		threadComando.join();

		System.out.println("Fechando conexão!");
		socket.close();
	}
}
