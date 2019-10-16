package br.com.threads.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			int numerolinha = 1;
			Scanner scanner = new Scanner(new File(nomeArquivo));

			while (scanner.hasNext()) {
				String linha = scanner.nextLine();

				if (linha.toLowerCase().contains(nome.toLowerCase())) {
					System.out.println(nomeArquivo + " - " + numerolinha + ": " + linha);
				}
				numerolinha++;
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
