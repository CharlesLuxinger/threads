package br.com.threads.ex5;

public class Main {

	public static void main(String[] args) {
		GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
		PoolDeConexao pool = new PoolDeConexao();

		new Thread(new TarefaAcessaBanco(pool, tx)).start();
		new Thread(new TarefaAcessaBancoProcedimento(pool, tx)).start();
	}

}
