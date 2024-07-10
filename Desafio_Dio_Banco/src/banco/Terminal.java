package banco;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terminal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("CADASTRANDO NOVA CONTA\nDados do cliente:");
		System.out.println("Cliente:\nNome:");
		String clienteNome = sc.next();
		System.out.println("Data de nascimento: (dd/MM/aaaa)");
		String dataNascimento = sc.next();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataFormat = LocalDate.parse(dataNascimento, formato);
		System.out.println("Endereço:");
		String endereco = sc.next();
		Clientes novoCliente = new Clientes(clienteNome, dataFormat, endereco);
		System.out.println("Qual será o tipo da sua conta?\n[1]Corrente\n[2]Poupança");
		int tipoConta = sc.nextInt();
		sc.nextLine();
		List<Contas> contasLista = new ArrayList<>();
		Contas conta1= new Poupanca();
		Contas conta2 = new Corrente();
		contasLista.add(conta2);
		contasLista.add(conta1);
		Contas novaConta = new Contas();
		if(tipoConta == 1) {
			novaConta = new Corrente(novoCliente);
		}
		else if(tipoConta == 2) {
			novaConta = new Poupanca(novoCliente);
		}
		else {
			System.out.println("Opção inválida");
		}
		contasLista.add(novaConta);
		boolean continuar = true;
		while (continuar) {
			System.out.println("Menu:");
			System.out.println("1. Depositar");
			System.out.println("2. Sacar");
			System.out.println("3. Realizar transferência");
			if(novaConta instanceof Poupanca) {
			System.out.println("4. Guardar na poupança");
			}
			if(novaConta instanceof Poupanca) {
				System.out.println("5. Resgatar da poupança");
			}
				
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = sc.nextInt();
			sc.nextLine(); 
			switch (opcao) {
			case 1:
				System.out.println("Digite o valor a ser depositado:");
				double valor = sc.nextDouble();
				novaConta.deposito(valor);
				break;
			case 2:
				System.out.println("Digite o valor a ser sacado:");
				double valorSaque = sc.nextDouble();
				novaConta.retirada(valorSaque);
				break;
			case 3:
				System.out.println("Digite o valor para realizar a transferência:");
				double valorTransf = sc.nextDouble();
				System.out.println("Digite o número da conta do recebedor:");
				int contaNumero = sc.nextInt();
				Contas contaTransf = novaConta.procurarContaPorNumero(contasLista, contaNumero);
				novaConta.transferencia(valorTransf, contaTransf);
				novaConta.getSaldo();
				break;
		
			case 4:
				System.out.println("Digite o valor a ser guardado: ");
				double valorPoupanca = sc.nextDouble();
				System.out.println("Informe a data de retirada:\n[ATENÇÃO!] Ao informar uma data, seu depósito só poderá ser retirado a partir da data informada");
				String dataRetirada = sc.next();
				((Poupanca)novaConta).guardarPoupanca(valorPoupanca,dataRetirada);
				break;
			case 5: 
				System.out.println("Digite o valor a ser resgatado: ");
				double valorResgate = sc.nextDouble();
				((Poupanca)novaConta).retirarPoupanca(valorResgate);
			case 0:
				continuar = false;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
		sc.close();
	}
}


