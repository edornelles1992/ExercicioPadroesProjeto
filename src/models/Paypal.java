package models;

public class Paypal implements Pagamento {

	@Override
	public boolean validar(double valor) {
		System.out.println("Realizando validação do pagamento via paypal..");
		return true;
	}
	
	@Override
	public boolean pagar(double valor) {
		System.out.println("Ralizando pagamento via paypal...");
		return true;
	}

	@Override
	public double desconto(double valor) {
		if (valor > 60) {
			System.out.println("Desconto pela forma de pagamento: R$5,00");
			return 5;
		}
		return 0;
	}

}
