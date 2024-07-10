package banco;

import java.util.List;

public class Contas {
	private static int SEQUENCIAL = 1;
	private int agencia;
	private int numero;
	private Clientes cliente;
	private double saldo;
	
	public Contas(Clientes cliente) {
		this.agencia = 0001;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.setSaldo(0.0);
	}
	public Contas() {
		this.agencia = 0001;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.setSaldo(0.0);
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double deposito(double valor) {
		saldo += valor;
		System.out.println("Depósito realizado com sucesso!\nSaldo disponível: " + saldo);
		return saldo;
	}
	public double retirada(double valor) {
		if(saldo >= valor) {
		saldo -= valor;
		return saldo;
	}
	else {
		System.out.println("Saldo insuficiente! Saldo: " + saldo );
		return saldo;
	}
	}

	public double transferencia(double valor,Contas conta) {
		while(this.saldo >= valor) {
		this.retirada(valor);
		conta.deposito(valor);
		System.out.println("Transferencia realizada com sucesso");
		return saldo;
	}
			System.out.println("Transferência não realizada: saldo insuficiente.");
			return saldo;
		}
	
	public Contas procurarContaPorNumero(List<Contas> lista, int numero) {
		for(Contas conta : lista) {
			if (conta.getNumero()== numero) {
                return conta;     
		}
		}
		System.out.println("Conta não encontrada");
		return null;
	} 
	 public String imprimirExtrato() {
		 System.out.println("=== Extrato da conta ===\nCliente: " + cliente.getNome());
		 return "\nAgência: " + agencia + "\nNúmero da conta: " + numero + "\nSaldo: " + saldo;
	 }
	
	@Override
	public String toString() {
		return "Dados do cliente: " + cliente + "\nAgência: " + agencia + "\nNúmero da conta: " + numero + "\nSaldo: " + saldo;
	}

	
	
}
