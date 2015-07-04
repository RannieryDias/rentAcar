package dados;

import java.util.List;

import Negocio.bean.Locacao;
import exceptions.LocacaoNaoExisteException;
import exceptions.LocacoesNaoCadastradasException;

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
