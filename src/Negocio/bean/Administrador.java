package Negocio.bean;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String login;
	private String senha;

	public Administrador(String nome, String cpf, long id, String login,String senha) 
	{
		super(nome, cpf);
		this.id = id;
		this.login = login;
		this.senha = senha;		
	}

	public Administrador(String nome, String cpf,String senha)
	{
		super(nome, cpf);
	}

	public Administrador(String nome, String cpf, String login,String senha)
	{
		super(nome, cpf);
		this.login = login;
		this.senha = senha;
	}

	public Administrador(long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}

	public Administrador() {
		super();
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getCpf() {
		return this.cpf;
	}

	@Override
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	

}
