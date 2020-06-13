package singleton;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import models.Operacoes;
import models.Produto;
import observer.CarrinhoObservable;

/**
 * SINGLETON Para a classe Carrinho e implementa um Observer
 * que detecta e dispara um evento toda vez q um produto for adicionado
 * no carrinho.
 */
public class Carrinho implements Observer {
	private static Carrinho instance = null;
	private CarrinhoObservable carrinhoObservable = new CarrinhoObservable();
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public static synchronized Carrinho getInstancia() {
		if (instance == null) {
			instance = new Carrinho();
		}
		return instance;
	}
	
	public Carrinho() {
		carrinhoObservable.addObserver(this);
	}	


	public CarrinhoObservable getProdutos() {
		return carrinhoObservable;
	}
	
	public int qtdProdutos() {
		return produtos.size();
	}
	
	public void listar() {
		System.out.println("Produtos no carrinho: ");
		for (Produto p : produtos)
			System.out.println(" - " + p.getNome());
	}

	@Override
	public void update(Observable o, Object produto) {
		System.out.println("OBSERVER -- atualizando carrinho...");
		if (o instanceof Operacoes) {			
			this.produtos.add(((Produto)produto));
			listar();
		}
	}
}
