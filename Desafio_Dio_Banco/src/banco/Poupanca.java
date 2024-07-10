package banco;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Poupanca extends Contas {
	private double poupanca;
	private LocalDate dataRetirada;

	public Poupanca() {
		super();
		this.poupanca = 0.0;
	}

	public Poupanca(Clientes cliente) {
		super(cliente);
		this.poupanca = 0.0;
	}

	public double getPoupanca() {
		return poupanca;
	}
	

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public void guardarPoupanca(double valor,String data ) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataInput = LocalDate.parse(data, formato);
		dataRetirada = dataInput;
		valor += poupanca;
		
	}
	public double retirarPoupanca(double valor) {
		LocalDate now = LocalDate.now();
		if(now.isAfter(dataRetirada)){
		poupanca -= valor;
		System.out.println("Valor resgatado com sucesso!");
		return poupanca;
		}
		else
			System.out.println("A data para resgate foi definida como "+dataRetirada+".");
		return poupanca;
	}
	

}

