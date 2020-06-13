package models;

public class Credito implements Pagamento {

	@Override
	public boolean validar(double valor) {
		System.out.println("Realizando validação do pagamento via cartão de crédito..");
		return true;
	}
	
	@Override
	public boolean pagar(double valor) {
		System.out.println("Ralizando pagamento via Cartão de crédito...");
		return true;
	}

	@Override
	public double desconto(double valor) {
		if (valor > 70) {
			System.out.println("Desconto pela forma de pagamento: R$11,00");
			return 11;
		}
		return 0;
	}
}
