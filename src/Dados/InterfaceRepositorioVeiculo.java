package Dados;

import Exceptions.VeiculoNaoExisteException;
import Negocio.bean.Veiculo;

public interface InterfaceRepositorioVeiculo 
{
	public void cadastrar(Veiculo v);
	public Veiculo procurar(String placa) throws VeiculoNaoExisteException;
	public void removerCarro(String placa) throws VeiculoNaoExisteException;
}
