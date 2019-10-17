package br.com.threads.ex3;

public class Main {
	public static void main(String[] args) {

		Tarefas tarefas = new Tarefas();

		Thread threadLenta1 = new Thread(new TarefaLenta(tarefas), "Tarefa Lenta 1");

		Thread threadRapida2 = new Thread(new TarefaRapida(tarefas), "Tarefa Rapida 2");

		Thread threadLiberaTarefa = new Thread(new LiberaTarefa(tarefas), "Libera Tarefa");
		threadLiberaTarefa.setDaemon(true);

		//Thread threadLenta3 = new Thread(new TarefaLenta(tarefas), "Tarefa Lenta 3");

		//Thread threadRapida4 = new Thread(new TarefaRapida(tarefas), "Tarefa Rapida 4");

		threadLenta1.start();
		threadRapida2.start();
		threadLiberaTarefa.start();
		//threadLenta3.start();
		//threadRapida4.start();
	}
}
