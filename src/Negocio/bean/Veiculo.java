package Negocio.bean;

import java.io.Serializable;


public class Veiculo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String placa;
	private String modelo;
	private String cor;
	private float motor;
	private int Estacaoatual;
	private Float valorLocacao;
	private boolean alugado = false;
	
	public Veiculo(String placa, String modelo,String cor,Float valorLocacao,int EstacaoAtual)
	{
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.valorLocacao = valorLocacao;
		this.setEstacaoatual(EstacaoAtual);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setAlugado(boolean b)
	{
		this.alugado = b;
	}
	public boolean getAlugado()
	{
		return this.alugado;
	}
	
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Float getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(Float valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public int getEstacaoatual() {
		return Estacaoatual;
	}

	public void setEstacaoatual(int estacaoatual) {
		Estacaoatual = estacaoatual;
	}

	@Override
	public String toString()
	{
		String C = "Placa: "+ this.placa + "/n";
		C += "Modelo: "+ this.modelo; 
		C += "Cor: " +this.cor;
		return C;
	}
}
