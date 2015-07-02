package Negocio.bean;

import java.io.Serializable;
import java.util.Calendar;


public class Locacao implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int IdLocacao;
	private Calendar DataInicio;
	private Calendar DataFim;
	private Calendar DataEntrega;
	private Cliente cliente;
	private Veiculo carro;
	private Estacao EstacaoInicio;
	private Estacao EstacaoFim;
	private float valor;
	private float multa = 0;
	private boolean ativado = true;
	
	
	public Locacao(int id,Calendar dataInicio,Calendar dataFim,Estacao estacao,Cliente cliente, Veiculo carro,float valor) 
	{
		this.IdLocacao = id;
		this.DataInicio = dataInicio;
		this.DataFim = dataFim;
		this.EstacaoInicio = estacao;
		this.cliente = cliente;
		this.carro = carro;
		this.valor = valor;
	}
	public Locacao(int id,Calendar dataInicio,Calendar dataFim,Estacao estacao,Cliente cliente, Veiculo carro,float valor,Calendar DatadeEntrega) 
	{
		this.IdLocacao = id;
		this.DataInicio = dataInicio;
		this.DataFim = dataFim;
		this.EstacaoInicio = estacao;
		this.cliente = cliente;
		this.carro = carro;
		this.valor = valor;
		this.DataEntrega = DatadeEntrega;
	}

	public int getIdLocacao() {
		return IdLocacao;
	}

	public void setIdLocacao(int idLocacao) {
		IdLocacao = idLocacao;
	}

	public Calendar getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		DataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return DataFim;
	}

	public void setDataFim(Calendar dataEntrega) {
		DataFim = dataEntrega;
	}

	public Calendar getDataEntrega() {
		return DataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		DataEntrega = dataEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getCarro() {
		return carro;
	}

	public Estacao getEstacaoInicio() {
		return EstacaoInicio;
	}

	public void setEstacaoInicio(Estacao estacaoInicio) {
		EstacaoInicio = estacaoInicio;
	}

	public void setCarro(Veiculo carro) {
		this.carro = carro;
	}
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getMulta() {
		return multa;
	}

	public void setMulta(float multa) {
		this.multa = multa;
	}

	public boolean getAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}
	
	public boolean equals(Locacao l)
	{
		boolean resultado;
		if(l instanceof Locacao && l!= null && this.IdLocacao != 0)
		{
			resultado = (this.IdLocacao == l.getIdLocacao() && this.cliente.getCpf().equals(l.getCliente().getCpf()) && this.carro.getPlaca().equals(l.getCarro().getPlaca()) 
					&& this.DataInicio.equals(l.getDataInicio()));
		}
		else
		{
			resultado = false;
		}	
		return resultado;
	}

	@Override
	public String toString()
	{
	   String s = "Carro: " + this.carro+"\n";
	   s += "Cliente: " + this.cliente + "\n";
	   s += "Data do aluguél: "+ this.DataInicio + "\n";
	   s += "Data de devolução: " +this.DataFim + "\n";
	   return s;
	}
   
}
