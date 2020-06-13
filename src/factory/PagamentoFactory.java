package factory;

import models.Boleto;
import models.Credito;
import models.Debito;
import models.FormaPagamento;
import models.Pagamento;
import models.Paypal;

/**
 * FACTORY para instanciar o tipo de pagamento
 */
public class PagamentoFactory {

	public static Pagamento createInstance(FormaPagamento forma) {
		switch (forma) {
		case PAYPAL:
			return new Paypal();
		case BOLETO:
			return new Boleto();
		case DEBITO:
			return new Debito();
		case CREDITO:
			return new Credito();
		}
		return null;
	}
}
