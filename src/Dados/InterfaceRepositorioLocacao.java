package Dados;

import java.util.List;

import Exceptions.LocacaoNaoExisteException;
import Exceptions.LocacoesNaoCadastradasException;
import Negocio.bean.Locacao;

public interface InterfaceRepositorioLocacao 
{
	public void Cadastrar(Locacao l);
	public Locacao procurarLocacao(Integer idLocacao) throws LocacaoNaoExisteException ;
	public void remover(int id) throws LocacaoNaoExisteException;
	boolean existe(String cpf, String placa);
	public List<Locacao> exibirALuguelComMulta() throws LocacoesNaoCadastradasException;
	public List<Locacao> exibirALuguelFinalizado()throws LocacoesNaoCadastradasException;
	public List<Locacao> exibirALugueisAtivos() throws LocacoesNaoCadastradasException;
	

}
