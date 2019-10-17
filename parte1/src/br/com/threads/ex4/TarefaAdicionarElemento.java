package br.com.threads.ex4;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

	private List<String> lista;
	private int index;

	public TarefaAdicionarElemento(List<String> lista, int index) {
		this.index = index;
		this.lista = lista;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.add("Thread " + index + ": " + i);
		}
	}

}
