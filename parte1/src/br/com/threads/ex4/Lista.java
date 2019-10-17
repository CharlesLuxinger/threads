package br.com.threads.ex4;

public class Lista {
	private String[] elementos = new String[1000];
	private int indice = 0;

	public synchronized void adicionaElementos(String elemento) {
		elementos[indice] = elemento;
		indice++;
	}

	public int tamanho() {
		return elementos.length;
	}

	public String pegaElemento(int posicao) {
		return elementos[posicao];
	}
}
