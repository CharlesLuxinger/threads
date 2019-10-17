package br.com.threads.ex3;

public class Tarefas {


	public void tarefaRapida() {
		String threadNome = Thread.currentThread().getName();

		System.out.println(threadNome + " Tentando executar");

		synchronized (this) {

			System.out.println(threadNome + " Ação 1");
			System.out.println(threadNome + " Ação 2");

			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(threadNome + " Ação 3");
			System.out.println(threadNome + " Ação 4");
			System.out.println(threadNome + " Ação 5");
		}

	}

	public void tarefaLenta() {
		String threadNome = Thread.currentThread().getName();

		System.out.println(threadNome + " Tentando executar");

		synchronized (this) {
			System.out.println(threadNome + " Ação 1");
			System.out.println(threadNome + " Ação 2");

			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(threadNome + " Ação 3");
			System.out.println(threadNome + " Ação 4");
			System.out.println(threadNome + " Ação 5");
		}
	}
}
