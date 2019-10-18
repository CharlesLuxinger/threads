package br.com.threads.comando;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaDB implements Callable<String> {

	private PrintStream responseCliente;

	public ComandoC2ChamaDB(PrintStream responseCliente) {
		this.responseCliente = responseCliente;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Servidor Processando C2DB");

		responseCliente.println("Servidor Processando C2DB");

		Thread.sleep(15000);

		int numero = new Random().nextInt(100)+1;

		System.out.println("Comando C2DB executado.");

		return Integer.toString(numero);
	}

}
