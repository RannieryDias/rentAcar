package Negocio;

import Dados.RepositorioAdministrador;
import Exceptions.AdministradorJaExistenteException;
import Exceptions.AdministradorNaoExisteException;
import Exceptions.RepositorioException;
import Negocio.bean.Administrador;

public class ControladorAdministrador 
{
	private RepositorioAdministrador repositorio;
	private static long idAdministrador = 1;

	public ControladorAdministrador() throws ClassNotFoundException,RepositorioException 
	{
		this.repositorio = new RepositorioAdministrador();
	}

	public void cadastrarAdministrador(Administrador adm) throws RepositorioException,AdministradorJaExistenteException,AdministradorNaoExisteException 
	{
		boolean indice = this.existe(adm.getCpf());

		if (indice == false && adm != null) {
			adm.setId(ControladorAdministrador.idAdministrador);
			repositorio.cadastrarAdministrador(adm);
			ControladorAdministrador.idAdministrador++;
		} else
			throw new AdministradorJaExistenteException(adm.getCpf());
	}

	public Administrador procurar(String cpf)throws AdministradorNaoExisteException {
		return this.repositorio.procurarAdministrador(cpf);
	}

	public void alterar(Administrador adm) throws RepositorioException,AdministradorNaoExisteException {
		boolean resposta = this.existe(adm.getCpf());

		if (resposta == false && adm != null)
			this.repositorio.alterarAdministrador(adm);
	}

	public boolean existe(String cpf) throws AdministradorNaoExisteException {
		return this.repositorio.existe(cpf);
	}

	public void excluir(String cpf) throws RepositorioException,AdministradorNaoExisteException
	{
		this.repositorio.excluirAdministrador(cpf);
	}

}
