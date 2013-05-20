package br.android.mobpdv.model;

import java.util.List;

public class Cardapio {

	private List<Produto> listaProduto;
	private TipoCardapio tipoCardapio;
	
	
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	public TipoCardapio getTipoCardapio() {
		return tipoCardapio;
	}
	
	public void setTipoCardapio(TipoCardapio tipoCardapio) {
		this.tipoCardapio = tipoCardapio;
	}
	
}
