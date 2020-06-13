package models;

public class Debito implements Pagamento {

	@Override
	public boolean validar(double valor) {
		System.out.println("Realizando validação do pagamento via cartão de débito..");
		return true;
	}
	
	@Override
	public boolean pagar(double valor) {
		System.out.println("Ralizando pagamento via Cartão de débito...");
		return true;
	}
	
	@Override
	public double desconto(double valor) {
		if (valor > 40) {
			System.out.println("Desconto pela forma de pagamento: R$7,00");
			return 7;
		}
		return 0;
	}

}
