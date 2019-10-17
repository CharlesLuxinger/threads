package br.com.threads.handler;

import java.lang.Thread.UncaughtExceptionHandler;

public class HandlerException implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Erro na Thread " + t.getName() + ", " + e.getMessage());

	}

}
