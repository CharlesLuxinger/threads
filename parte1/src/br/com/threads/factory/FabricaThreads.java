package br.com.threads.factory;

import java.util.concurrent.ThreadFactory;

import br.com.threads.handler.HandlerException;

public class FabricaThreads implements ThreadFactory {

	private static int numero;

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable, "Thread Tarefa" + numero);
		thread.setUncaughtExceptionHandler(new HandlerException());

		numero++;
		return thread;
	}

}
