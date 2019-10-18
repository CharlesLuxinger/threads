package br.com.threads.consumer;

import java.util.concurrent.BlockingQueue;

public class TarefaConsumer implements Runnable {

	private BlockingQueue<String> filaComandos;

	public TarefaConsumer(BlockingQueue<String> filaComandos) {
		this.filaComandos = filaComandos;
	}

	@Override
	public void run() {
		try {

			String comando = null;

			while ((comando = filaComandos.take()) != null) {
				System.out.println("Consumindo comando:  " + comando + ", " +
						"Current Thread: " + Thread.currentThread().getName());

				Thread.sleep(5000);
			}

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
