package br.com.threads.comando;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String> {

	private PrintStream responseCliente;

	public ComandoC2ChamaWS(PrintStream responseCliente) {
		this.responseCliente = responseCliente;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Servidor Processando C2WS");

		responseCliente.println("Servidor Processando C2WS");

		Thread.sleep(15000);

		int numero = new Random().nextInt(100)+1;

		System.out.println("Comando C2WS executado.");

		return Integer.toString(numero);
	}

}
