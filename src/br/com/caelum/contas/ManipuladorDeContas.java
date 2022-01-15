package br.com.caelum.contas;

import java.util.Collections;
import java.util.List;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {
	private Conta conta /*= new Conta()*/;
		
	public void criaConta (Evento evento) {
		//conta = new Conta();
		/*conta.setNumero(0001);
		conta.setAgencia("001A");
		conta.setTitular("Ares");*/
		String tipo = evento.getSelecionadoNoRadio("tipo");
		if (tipo.equals("Conta Corrente")) {
			this.conta = new ContaCorrente();
		} else if (tipo.equals("Conta Poupança")) {
			this.conta = new ContaPoupanca();
		} else {
			System.out.println("Tipo de Conta não selecionado");
		}
		conta.setNumero(evento.getInt("numero"));
		conta.setAgencia(evento.getString("agencia"));
		conta.setTitular(evento.getString("titular"));
		System.out.println("Conta criada com sucesso");
	}
	
	public void deposita (Evento evento) {
		conta.deposita(evento.getDouble("valorOperacao"));
		System.out.println("Depósito efetuado com sucesso");
	}
	
	public void saca (Evento evento) {
		//conta.saca(evento.getDouble("valorOperacao"));
		double valor = evento.getDouble("valorOperacao");
		this.conta.saca(valor);
		/*if(this.conta.getTipo().equals("Conta Corrente")) {
			this.conta.saca(valor + 0.10);
		} else {
			this.conta.saca(valor);
		}*/
		System.out.println("Saque efetuado com sucesso");
	}
	
	public void transfere (Evento evento) {
		Conta destino = (Conta)evento.getSelecionadoNoCombo("destino");
		conta.transfere(evento.getDouble("valorTransferencia"), destino);
	}
	
	public void ordenaLista (Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
	}
	
	public void salvaDados (Evento evento) {
		List<Conta> contas = evento.getLista("listaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salva(contas);
	}
}