package br.com.threads.ex4;

public class TarefaImprimir implements Runnable {

	private Lista lista;

	public TarefaImprimir(Lista lista) {
		this.lista = lista;
	}

	@Override
	public void run() {

		synchronized (lista) {
			try {
				lista.wait();
				for (int i = 0; i < lista.tamanho(); i++) {
					System.out.println(lista.pegaElemento(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
