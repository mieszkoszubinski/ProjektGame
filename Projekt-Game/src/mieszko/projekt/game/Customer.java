package mieszko.projekt.game;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sala.patryk.projekt.wypozyczalniavideo.Movie;

public class Customer {

	private Logger logger = Logger.getLogger(Customer.class);
	private final String name;
	private float cash;
	private List<Game> myGameList;

	public Customer(String name, float money) throws InvalidMoneyAmountValue {
		myGameList = new ArrayList<Game>();
		this.name = name;
		if (money < 0) {
			throw new InvalidMoneyAmountValue();
		}
		this.cash = money;
	}

	
	public String getName() {
		return name;
	}


	public void showAllMySoldGames() {
		logger.info("Lista gier klienta o nazwisku: " + name);
		for (Game game : myGameList) {
			logger.info(game.toString());
		}
	}

	public void takeGame(Game game) {
		myGameList.add(game);
	}

	public Game returnGame(String title) {
		for (Game game : myGameList) {
			if (game.getTitle().equals(title))
				return game;
		}
		return null;
	}

	public float payMoney(float priceToPay) throws NoMoneyException {
		if (cash - priceToPay >= 0) { 
			cash = cash - priceToPay;
			return priceToPay;
		}
		throw new NoMoneyException(); 
	}

}
