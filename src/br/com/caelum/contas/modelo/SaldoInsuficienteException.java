package br.com.caelum.contas.modelo;

public class SaldoInsuficienteException extends RuntimeException {
	public SaldoInsuficienteException (double saldo) {
		super("Saldo insuficiente para sacar o valor de " + saldo);
	}
}
