package br.com.threads.ex5;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {
			System.out.println("Get Pool Key");
			pool.getConnection();

			synchronized (tx) {
				System.out.println("Start Transaction Manager");
				tx.begin();
			}
		}
	}

}
