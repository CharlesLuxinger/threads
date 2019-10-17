package br.com.threads;

import br.com.threads.servidor.ServidorTarefas;

public class Main {

	public static void main(String[] args) throws Exception {

		ServidorTarefas servidor = new ServidorTarefas();

		servidor.run();
		servidor.shutdown();
	}

}
