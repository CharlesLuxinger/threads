package br.com.threads.ex3;

public class Tarefas {

	private boolean tarefaExecutada = true;

	public void tarefaRapida() {
		String threadNome = Thread.currentThread().getName();

		System.out.println(threadNome + " Tentando executar");

		synchronized (this) {

			System.out.println(threadNome + " Ação 1");

			while (tarefaExecutada) {
				esperaTarefa(threadNome);
			}

			System.out.println(threadNome + " Ação 2");

			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(threadNome + " Ação 3");
			System.out.println(threadNome + " Ação 4");
			System.out.println(threadNome + " Ação 5");
			tarefaExecutada = true;
		}


	}


	public void tarefaLenta() {
		String threadNome = Thread.currentThread().getName();

		System.out.println(threadNome + " Tentando executar");

		synchronized (this) {
			System.out.println(threadNome + " Ação 1");

			while (tarefaExecutada) {
				esperaTarefa(threadNome);
			}

			System.out.println(threadNome + " Ação 2");

			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(threadNome + " Ação 3");
			System.out.println(threadNome + " Ação 4");
			System.out.println(threadNome + " Ação 5");

			tarefaExecutada = true;
		}
	}

	public void liberaExecucao() {

		String threadNome = Thread.currentThread().getName();

		System.out.println(threadNome + " Tentando liberar");

		synchronized (this) {
			System.out.println(threadNome + " Liberando...");

			if (!tarefaExecutada) {
				System.out.println(threadNome + " Tarefa já estava liberada.");
				return;
			}

			try {
				Thread.sleep(1000L);
				tarefaExecutada = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(threadNome + " Liberado");
			notifyAll();
		}
	}

	private void esperaTarefa(String threadNome) {
		System.out.println(threadNome + " Ação já realizada");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
