package Dados;

import Exceptions.AdministradorNaoExisteException;
import Exceptions.RepositorioException;
import Negocio.bean.Administrador;

public interface InterfaceRepositorioAdministrador 
{
	public void cadastrarAdministrador(Administrador adm) throws RepositorioException;
	public Administrador procurarAdministrador(String cpf) throws AdministradorNaoExisteException;
	public void alterarAdministrador(Administrador adm)throws RepositorioException, AdministradorNaoExisteException;
	public boolean existe(String cpf) throws AdministradorNaoExisteException;
	public void excluirAdministrador(String cpf) throws RepositorioException,AdministradorNaoExisteException;
}
