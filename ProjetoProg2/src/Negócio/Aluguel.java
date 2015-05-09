package Negócio;


public class Aluguel {

	
	private long id;
	private Cliente cliente;
    private Carro carro;
	private boolean alugado;

	public Aluguel() {
		
		cliente.setNome = te;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.valor = valor;
	}

	public Aluguel(Estacao estacao, Cliente cliente, Calendar dataAluguel,
			Calendar dataDevolucao, double valor) {
		this.estacao = estacao;
		this.cliente = cliente;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.valor = valor;
	}

	public Aluguel(long id, Estacao estacao, Cliente cliente,
			Calendar dataAluguel, Calendar dataDevolucao) {
		this.id = id;
		this.estacao = estacao;
		this.cliente = cliente;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}

	public Aluguel(Estacao estacao, Cliente cliente, Calendar dataAluguel) {
		this.estacao = estacao;
		this.cliente = cliente;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = null;
		this.valor = 0;
	}

	public Aluguel(long id, Estacao estacao, Cliente cliente) {
		this.id = id;
		this.estacao = estacao;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Calendar dataAluguel) {
		dataAluguel = Calendar.getInstance(); // capturando a data atual no
												// momento do aluguel
		this.dataAluguel = Calendar.getInstance();
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		dataDevolucao = Calendar.getInstance(); // capturando a data atual no
												// momento da devolução
		this.dataDevolucao = dataDevolucao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
