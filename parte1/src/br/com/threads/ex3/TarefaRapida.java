package br.com.threads.ex3;

public class TarefaRapida implements Runnable {

	private Tarefas tarefas;

	public TarefaRapida(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public void run() {
		tarefas.tarefaRapida();
	}

}
