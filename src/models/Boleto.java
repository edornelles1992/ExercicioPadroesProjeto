package models;

public class Boleto implements Pagamento {

	@Override
	public boolean validar(double valor) {
		System.out.println("Realizando validação do pagamento via boleto..");
		return true;
	}
	
	@Override
	public boolean pagar(double valor) {
		System.out.println("Ralizando pagamento via boleto...");
		return true;
	}

	@Override
	public double desconto(double valor) {
		if (valor > 50) {
			System.out.println("Desconto pela forma de pagamento: R$4,00");
			return 4;
		}
		return 0;
	}
}
