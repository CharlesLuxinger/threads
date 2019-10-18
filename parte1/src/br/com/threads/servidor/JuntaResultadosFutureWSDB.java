package br.com.threads.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWSDB implements Callable<Void> {


	private PrintStream responseCliente;
	private Future<String> futureWS;
	private Future<String> futureDB;

	public JuntaResultadosFutureWSDB(Future<String> futureWS, Future<String> futureDB, PrintStream responseCliente) {
		this.futureWS = futureWS;
		this.futureDB = futureDB;
		this.responseCliente = responseCliente;
	}

	@Override
	public Void call() {
		System.out.println("Aguardando resultados futuros de WS e DB");

		try {
			String responseWS = futureWS.get(10, TimeUnit.SECONDS);
			String responseDB = futureDB.get(10, TimeUnit.SECONDS);

			responseCliente.println("ResponseWS: " + responseWS+ ", " + "ResponseDB: " + responseDB);
			System.out.println("Execução comando C2 finalizada sucesso");
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Cancelando execução comando C2");
			responseCliente.println("Timeout na execução comando C2");
			futureWS.cancel(true);
			futureDB.cancel(true);
		}


		return null;
	}

}
