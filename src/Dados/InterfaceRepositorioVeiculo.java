package dados;

import Negocio.bean.Veiculo;
import exceptions.VeiculoNaoExisteException;

public interface InterfaceRepositorioVeiculo 
{
	public void cadastrar(Veiculo v);
	public Veiculo procurar(String placa) throws VeiculoNaoExisteException;
	public void removerCarro(String placa) throws VeiculoNaoExisteException;
}
