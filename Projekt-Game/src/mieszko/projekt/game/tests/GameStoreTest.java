package mieszko.projekt.game.tests;

import mieszko.projekt.game.Game;
import mieszko.projekt.game.ItemType;
import junit.framework.Assert;

public class GameStoreTest{

	private GameStore gameStore;
	
	@Before
	public void setUp() throws Exception {
		gameStore = new GameStore();
		gameStore.addNewGame(new Game("Battlefield 3",ItemType.DVD,"EA GAMES",19.99F));
		gameStore.addNewGame(new Game("Call of Duty:Modern Warfar 3",ItemType.DVD,"Activision",13));
		gameStore.addNewGame(new Game("Settlers IV",ItemType.CD,"Blue Byte",5));
		gameStore.addNewGame(new Game("Elder Scrolls;Skyrim",ItemType.DVD,"Bethesda Studio",9.99F));
		gameStore.addNewGame(new Game("Starcraft 2:Wings Of Liberty",ItemType.DVD,"Blizzard",14.99F));
		gameStore.addNewGame(new Game("FIFA 12",ItemType.DVD,"EA Sports",29.99F));
	}
	
	@Test
	public void showAllGamesInGameStore(){
		gameStore.printAllGames();
	}
	
	@Test
	public void removeGameFromGameStore(){
		Game smerfy = gameStore.findGameByTitle("FIFA 12");
		gameStore.printAllGames();
		gameStore.removeGameFromGameStore(fifa12);
		gameStore.printAllGames();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected=InvalidMoneyAmountValue.class)
	public void createCustomerWithNegativeAmountOfMoney() throws InvalidMoneyAmountValue{
		Customer customer1 = new Customer("Adam Malysz", -200);
	}
	
	@Test(expected=NoMoneyException.class)
	public void clientHasNoMoneyToPay() throws InvalidMoneyAmountValue, NoMoneyException{
		Customer customer1 = new Customer("Jacek Banan", 1);
		Game fifa12 = gameStore.findGameByTitle("fifa12");
		Assert.assertNotNull("nie znaleziono gry FIFA 12", fifa12);
		gameStore.sellGame(customer1, fifa12);
	}

		
}
