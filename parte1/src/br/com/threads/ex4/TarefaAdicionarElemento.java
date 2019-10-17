package br.com.threads.ex4;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int index;

	public TarefaAdicionarElemento(Lista lista, int index) {
		this.index = index;
		this.lista = lista;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.adicionaElementos("Thread " + index + ": " + i);
		}
	}

}
