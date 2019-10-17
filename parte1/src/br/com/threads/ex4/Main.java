package br.com.threads.ex4;

import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		//List<String> lista = new ArrayList<String>(); - Nao e sync
		//List<String> lista = Collections.synchronizedList(new ArrayList<String>()); - sync
		List<String> lista = new Vector<String>(); // sync

		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}

		Thread.sleep(2000);

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

}
