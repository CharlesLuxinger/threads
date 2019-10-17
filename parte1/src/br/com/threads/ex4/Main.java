package br.com.threads.ex4;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// List<String> lista = new ArrayList<String>(); - Nao e sync
		// List<String> lista = Collections.synchronizedList(new ArrayList<String>()); - sync
		// List<String> lista = new Vector<String>(); // sync
		Lista lista = new Lista();

		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}

		new Thread(new TarefaImprimir(lista)).start();
	}

}
