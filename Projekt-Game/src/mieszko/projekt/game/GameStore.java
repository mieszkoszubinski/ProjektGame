package mieszko.projekt.game;

import java.util.ArrayList;

public class GameStore {
	
	private float totalCashInVideoRental = 0;
	
	private static Logger logger= Logger.getLogger(GameStore.class);
	
	private List<Game> gameList;
	
	public GameStore() {
		gameList = new ArrayList<Game>();
		logger.debug("Swtorzono nowy sklep z grami");
	}
	
	public void removeGameFromGameStore(Game game){
		gameList.remove(game);
		logger.debug("Usunieto gre ze sklepu: " + game.getTitle());
	}

	public void setNewPriceForGame (String gameTitle, float newPrice){
		Game Game = findGameByTitle(GameTitle);
		game.setPrice(newPrice);
	}
	
	public void addNewGame(Game game) {
		gameList.add(game);
		logger.debug("Dodano nowa gre do sklepu: " + game.getTitle());
	}

	public void printAllGames() {
		logger.info("Lista wszystkich gier w sklepie");
		for (Game game : gameList) {
			logger.info(game.toString());
		}
	}

	public Game findGameByTitle(String title) {
		for (Game game : GameList) {
			if(game.getTitle().equals(title))
				return game;
		}
		return null;
	}

	public void purchaseGame(Customer customer, Game CoDGame) throws NoMoneyException {
		if(CoDGame.isAvailable()){
			float moneyFromCustomer;
			moneyFromCustomer = customer.payMoney(CoDGame.getPrice());
			totalCashInGameStore = totalCashInGameStore + moneyFromCustomer;
			CoDGame.setAvailable(false); // nie ma gry w sklepie
			customer.takeGame(CoDGame);
			logger.debug("Klient " + customer.getName() + " wlasnie kupil gre " + CoDGame.getTitle());
		}
	}
}
