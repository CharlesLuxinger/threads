package br.com.threads.ex4;

public class Lista {
	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionaElementos(String elemento) {
		elementos[indice] = elemento;
		indice++;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (indice == elementos.length) {
			System.out.println("Lista Cheia!");
			notify();
		}
	}

	public int tamanho() {
		return elementos.length;
	}

	public String pegaElemento(int posicao) {
		return elementos[posicao];
	}

	public boolean estaCheia() {
		return indice == elementos.length;
	}
}
