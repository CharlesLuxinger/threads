package br.com.threads.ex3;

public class LiberaTarefa implements Runnable {

	private Tarefas tarefas;

	public LiberaTarefa(Tarefas tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tarefas.liberaExecucao();
		}
	}

}
