package models;

/**
 * Interface para os tipos de pagamento ficarem abstraidos em suas classes
 * STRATEGY
 */
public interface Pagamento {
	boolean pagar(double valor);
	boolean validar(double valor);
	double desconto(double valor);
}
