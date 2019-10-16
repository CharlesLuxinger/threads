package br.com.threads.ex2;

public class Main {

	public static void main(String[] args) {
		String nome = "Jon";

		// A JVM converte para threads nativas do SO, sendo assim não a garantia de ordem de execução.
		Thread threadAssinatura1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
		Thread threadAssinatura2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
		Thread threadAutores = new Thread(new TarefaBuscaTextual("autores.txt", nome));


		threadAssinatura1.start();
		threadAssinatura2.start();
		threadAutores.start();

	}

}
