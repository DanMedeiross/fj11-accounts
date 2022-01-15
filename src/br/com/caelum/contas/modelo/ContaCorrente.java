package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel{
	public String getTipo() {
		return super.getTipo() + " Corrente";
	}
	
	@Override
	public void saca(double saldo) {
		if (saldo < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		} else if (this.saldo < saldo) {
			throw new SaldoInsuficienteException(saldo);
		}else {
			this.saldo -= (saldo + 0.10);
		}
	}

	@Override
	public double getValorImposto() {
		return this.getSaldo() + 0.01;
	}
}
