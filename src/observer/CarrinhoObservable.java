package observer;

import java.util.Observable;

import models.Operacoes;
import models.Produto;

public class CarrinhoObservable extends Observable implements Operacoes {

	public void adicionar(Produto p) {
		setChanged();
		notifyObservers(p);
	}
}
