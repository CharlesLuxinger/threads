package br.com.threads.ex3;

public class TarefaLenta implements Runnable {

	private Tarefas tarefas;

	public TarefaLenta(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public void run() {
		tarefas.liberaExecucao();
	}

}
