package br.com.threads.comando;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

	private PrintStream responseCliente;

	public ComandoC2(PrintStream responseCliente) {
		this.responseCliente = responseCliente;
	}

	@Override
	public void run() {
		System.out.println("Executando C2");

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Comando C2 executado.");
	}

}
