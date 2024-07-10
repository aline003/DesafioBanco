package banco;
import java.time.LocalDate;
import java.util.Date;


class Clientes {
	private static int SEQUENCIAL = 0;
	private int codigo;
	private String nome;
	private LocalDate dataNascimento;
	private String endereco;
	
	public Clientes(String nome, LocalDate dataNascimento, String endereco) {
		this.codigo = SEQUENCIAL++;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

	@Override
	public String toString() {
		return "Código: " + codigo +"\nNome: " + nome + "\nData de nascimento: " + dataNascimento + "\nEndereço: " + endereco;
	}
	
	

}
