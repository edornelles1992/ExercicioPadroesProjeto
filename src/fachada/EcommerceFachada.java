package fachada;

import java.util.ArrayList;

import factory.PagamentoFactory;
import models.FormaPagamento;
import models.Pagamento;
import models.Produto;
import singleton.Carrinho;

/**
 * FACHADA para encapsular a interface disponivel para a UI utilizar.
 */
public class EcommerceFachada {

	private Carrinho carrinho;
	private ArrayList<Produto> produtos = new ArrayList<>();

	public EcommerceFachada() {
		carregarProdutos();
		carrinho = Carrinho.getInstancia();
	}

	public ArrayList<Produto> produtosDisponiveis() {
		return produtos;
	}

	public void validaPagamento(double valor, FormaPagamento forma) {
		Pagamento pagamento = PagamentoFactory.createInstance(forma);
		System.out.println("realizando a validação do pagamento...");
		pagamento.validar(valor);
		System.out.println("Tudo ok com a forma de pagamento!");
	}

	public void efetuaPagamento(double valor, FormaPagamento forma) {
		Pagamento pagamento = PagamentoFactory.createInstance(forma);
		System.out.println("realizando o pagamento...");
		valor -= pagamento.desconto(valor); // desconto tipo de pagamento
		valor -= calculaDescontoSistema(valor); // desconto do sistema
		pagamento.pagar(valor);
		System.out.println("Valor Pago: R$" + valor);
		System.out.println("pagamento realizado com sucesso!");
	}

	private double calculaDescontoSistema(double valor) {
		if (valor >= 50) { // desconto de 5 reais!
			System.out.println("Desconto da loja de R$" + 5 + ",00 aplicado no carrinho!");
			return 5;
		}
		return 0;
	}

	public FormaPagamento validarForma(int opcao) {
		switch (opcao) {
		case 1:
			return FormaPagamento.PAYPAL;
		case 2:
			return FormaPagamento.BOLETO;
		case 3:
			return FormaPagamento.DEBITO;
		case 4:
			return FormaPagamento.CREDITO;
		}
		return null;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	private void carregarProdutos() {
		produtos.add(new Produto("Cabo XX", 20));
		produtos.add(new Produto("Mouse LYY", 40));
		produtos.add(new Produto("Teclado GRG", 50));
		produtos.add(new Produto("Gabinete TTE", 100));
	}

}
