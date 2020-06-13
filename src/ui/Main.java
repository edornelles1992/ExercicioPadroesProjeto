package ui;

import java.util.Scanner;

import fachada.EcommerceFachada;
import models.FormaPagamento;
import models.Produto;

public class Main {

	private static EcommerceFachada ecommerceFachada = new EcommerceFachada();

	public static void main(String[] args) {
		double valor = executaFluxoCompras();
		executaFluxoPagamento(valor);
	}

	public static double executaFluxoCompras() {
		System.out.println("------Bem vindo ao e-shop-----");
		double valor = 0;

		while (true) {
			System.out.println("Qtd de Produtos no carrinho: "+ ecommerceFachada.getCarrinho().qtdProdutos());
			System.out.println("Escolha um produto:");
			int i = 0;
			for (Produto p : ecommerceFachada.produtosDisponiveis()) {
				System.out.println(i + " - " + p.getNome() + " R$ " + p.getPreco());
				i++;
			}
			Scanner scanner = new Scanner(System.in);
			int selecionado = scanner.nextInt();
			valor += ecommerceFachada.produtosDisponiveis().get(selecionado).getPreco();
			ecommerceFachada.getCarrinho().getProdutos().adicionar(ecommerceFachada.produtosDisponiveis().get(selecionado));
			System.out.println("Deseja adicionar mais produtos? 1 - Sim / 2 - Não");
			scanner = new Scanner(System.in);
			if (scanner.nextInt() == 2) {
				break;
			} 
		}
		
		return valor;
	}

	public static void executaFluxoPagamento(double valor) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------Compra no valor de R$" + valor + " confirmada------");
		System.out.println("----------Escolha a forma de pagamento-----------");
		System.out.println("1 - Paypal");
		System.out.println("2 - Boleto");
		System.out.println("3 - Debito");
		System.out.println("4 - Crédito");
		scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		FormaPagamento forma = ecommerceFachada.validarForma(opcao);
		ecommerceFachada.validaPagamento(valor, forma);
		ecommerceFachada.efetuaPagamento(valor, forma);
		System.out.println("-----Fim do Pagamento-----");
	}
}
