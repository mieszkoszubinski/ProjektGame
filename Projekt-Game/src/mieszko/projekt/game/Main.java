package mieszko.projekt.game;

import org.apache.log4j.Logger;

import sala.patryk.projekt.wypozyczalniavideo.Movie;
import sala.patryk.projekt.wypozyczalniavideo.VideoRental;


public class Main {

	private static Logger logger= Logger.getLogger(Main.class);
	
	public static void main(String[] args) {

		GameStore gameStore = new GameStore();
		
		gameStore.addNewGame(new Game("Battlefield 3",ItemType.DVD,"EA GAMES",19.99F));
		gameStore.addNewGame(new Game("Call of Duty:Modern Warfar 3",ItemType.DVD,"Activision",13));
		gameStore.addNewGame(new Game("Settlers IV",ItemType.CD,"Blue Byte",5));
		gameStore.addNewGame(new Game("Elder Scrolls;Skyrim",ItemType.DVD,"Bethesda Studio",9.99F));
		gameStore.addNewGame(new Game("Starcraft 2:Wings Of Liberty",ItemType.DVD,"Blizzard",14.99F));
		gameStore.addNewGame(new Game("FIFA 12",ItemType.DVD,"EA Sports",29.99F));

		gameStore.printAllGames();
		
		try {
			Customer customer1 = new Customer("Adam Malysz", -200);
		
		}catch (InvalidMoneyAmountValue exception) {
			logger.error(exception.getMessage());
		}
		
		Customer customer2 = null;
		try {
			customer2 = new Customer("Jacek Banan", 20);
		} catch (InvalidMoneyAmountValue e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customer2.showAllMyPurchasedGames();
		
		Game battledield3Game = gameStore.findGameByTitle("Battlefield 3");
		Movie fifa12Game = gameStore.findGameByTitle("FIFA 12");
		Movie settlersivGame = gameStore.findGameByTitle("Settlers IV");
		try{	
			gameStore.sellGame(customer2 , battlefield3Game);
			gameStore.sellGame(customer2 , fifa12Movie);
			gameStore.sellGame(customer2 , settlersivMovie);
		} catch (NoMoneyException e) {
			logger.error(e.getMessage());
		}
		
		customer2.showAllMyPurchasedGames();
		
		GameStore.printAllGame();
		
	}

}
