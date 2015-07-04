package Negocio.bean;


import java.io.Serializable;



public class Estacao implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cod;
	private String NomeEstacao;
	private int Capacidade;
	private String endereco;
	private Veiculo[] carros;
	private int proxima;
	
	public Estacao(String NomeEstacao,int Capacidade,String endereco)
	{
		this.NomeEstacao = NomeEstacao;
		this.Capacidade = Capacidade;
		this.endereco = endereco;
		this.carros = new Veiculo[Capacidade];
		
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int idEstacao) {
		this.cod = idEstacao;
	}

	public String getNomeEstacao() {
		return NomeEstacao;
	}


	public void setNomeEstacao(String nomeEstacao) {
		NomeEstacao = nomeEstacao;
	}

    public Veiculo getCarro(String placa)
    {
       int Indice = ProcurarIndice(placa);
       return this.carros[Indice];
    }
	public Veiculo[] getCarros() {
		return carros;
	}


	public void setCarros(Veiculo[] carros) {
		this.carros = carros;
	}


	public int getCapacidade() {
		return Capacidade;
	}

	public void setCapacidade(int capacidade) {
		Capacidade = capacidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void cadastrar(Veiculo c)
	{
		if(this.proxima < this.Capacidade)
		{
		  this.carros[this.proxima] = c;
		 this.proxima = this.proxima + 1;
		}
		else
		{
			System.out.println("Voce não pode mais cadastrar carros nesta estação");
		}
	}
	
	private int ProcurarIndice(String Placa)
	{
		int i = 0;
		int resultado = 0;
		 while (resultado == 0 && (i < this.proxima)) 
		 {
		   if (Placa.equals(this.carros[i].getPlaca())) 
		   {
			   resultado = i;
		   }
		   else 
		   {
		     i = i + 1;
		   }
		}
		return resultado;
	}
	public Veiculo procurar(String placa) 
	{
		Veiculo resultado = null;

        int i = this.ProcurarIndice(placa);

		if (i!= this.proxima) 
		{
		   resultado = this.carros[i];
		}
		else
		{
			System.out.println("Carro não encontrado");
		}

		return resultado;

	}
	public void removerVeiculo(String placa) 
	{

		int i = ProcurarIndice(placa);
		if (i != this.proxima) 
		{
			this.carros[i] = this.carros[this.proxima - 1];
			this.carros[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
			System.out.println("Carro Removido");
			
		}
		else 
		{
			System.out.println("O carro não existe");

		}

		}
	@Override
	public String toString()
	{
		String s = "Estação: " + this.NomeEstacao + "\n";
		s += "Endereço: " + this.endereco +"\n";
		s += "Capacidade: " + this.Capacidade;
		return s;
	}

}

