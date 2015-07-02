package Negocio.bean;

import java.io.Serializable;
import java.util.Calendar;


public class Cliente extends Usuario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean pendencia;
	
	public Cliente(String nome, String cpf) 
	{
		super(nome,cpf);
		
	}
	public Cliente(int id,String nome, String cpf) 
	{
		super(nome,cpf);
		this.id = id;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	
    @Override
	public String getCpf() {
		return cpf;
	}
	@Override
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	public boolean getPendencia()
	{
		return pendencia;
	}
	
	@Override
	public String toString()
	{
		String s = "Nome: "+ this.nome + "\n";
		s += "CPF: "+ this.cpf + " \n";
		return s;
	}
	
}

