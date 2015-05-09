package Negócio;

public class Carro {
	private String placa;
	private String modelo;
	private String cor;
	
	public Carro(String placa, String modelo){
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
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
}
