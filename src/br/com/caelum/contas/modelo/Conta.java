package br.com.caelum.contas.modelo;
public abstract class Conta implements Comparable <Conta>{
	protected double saldo;
	private String titular;
	private int numero;
	private String agencia;

	/*public void setSaldo(double saldo) {
		this.saldo = saldo;
	}*/

	public double getSaldo() {
		return this.saldo;
	}
	
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public void deposita(double saldo) {
		if (saldo < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		} else {
			this.saldo += saldo;
		}
	}
	
	public void saca(double saldo){
		if (saldo < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		} else {
			this.saldo -= saldo;	
		}
	}
	
	public String getTipo() {
		return "Conta";
	}
	
	public void transfere(double saldo, Conta conta) {
		this.saca(saldo);
		conta.deposita(saldo);
	}
	
	@Override
	public String toString() {
		return "[Titular= " + titular.toUpperCase() + ", Número= " + numero + ", Agência= " + agencia + "]";
	}
	
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Conta outraConta = (Conta) obj;
		return this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia);
	}
	
	public int compareTo (Conta outraConta) {
		return this.titular.compareTo(outraConta.titular);
	}
}