package br.com.threads.ex5;

public class TarefaAcessaBanco implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
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
