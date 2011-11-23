package mieszko.projekt.game.tests;

import mieszko.projekt.game.Game;
import mieszko.projekt.game.ItemType;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class GameStoreTest{

	
public class GameStoreTest {	
	
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
	@After
	public void tearDown () throws Exception {	
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

	@Test
	public void showAllMoviesInVieoRentalTest(){
		videoRental.printAllMovies();
	}

	@Test
	public void removeGameFromGameStoreTest(){
		Movie smerfy = videoRental.findMovieByTitle("FIFA 12");
		gameStore.printAllGames();
		gameStore.removeGameFromGameStore(fifa12);
		gameStore.printAllGames();
	}

	@Test
	public void purchaseGameTest(){
		Customer customer = null;
		try {
			customer = new Customer("Jan Nowak", 150);
		} catch (InvalidMoneyAmountValue e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Game battlefield3Game = gameStore.findGameByTitle("Battlefield 3");

		try {
			videoRental.rentMovie(customer, houseMovie);
			System.out.println("Sprawdzanie czy wypozyczony film ma FLAGE AVAILABLE=FALSE");
			boolean available = houseMovie.isAvailable();
			Assert.assertFalse("BLAD! film mimo wypozyczenia ma flage dostepnosci = true", available);
			System.out.println("Udalo sie wypozyczyc film " + houseMovie.getTitle());
		} catch (NoMoneyException e) {
			e.printStackTrace();
			Assert.fail("Wystapil wyjatek w czasie proby wypozyczenia filmu: " + e.getMessage());
		}
	}

	@Test
	public void settingPriceTest(){
		float newPrice = 120;
		videoRental.setNewPriceForMovie("Battlefield 3", newPrice);
		Game game = gameStore.findGameByTitle("Battlefield 3");
		Assert.assertEquals("BLAD, Nie udalo sie ustawic nowej ceny dla gry ", movie.getPrice() ,newPrice);

	}


	@Test
	public void findByCompanyTest(){
		System.out.println("Wyszukiwanie gry po firmie ktora ja tworzy");
		List<Game> resultList = videoRental.findMovieByDirector("3DO");
		Assert.assertNotNull("Blad, lista zwrocona z metody wyszukujacej po firmie zwrocila NULL",resultList);
		Assert.assertTrue("Blad, lista zwrocona z metody wyszukujacej po firmie jest pusta",resultList.size()>0);
		if(resultList.size()>0){
			for (int i = 0; i < resultList.size(); i++) {
				System.out.println("Znaleziono " + resultList.get(i).toString());
			}
		}
	}

	@Test
	public void findByDataCarrierTypeTest(){
		System.out.println("Wyszukiwanie po typie nosnika...");
		List<Game> resultList = gameStore.findGameByType("DVD");
		Assert.assertNotNull("Blad, lista zwrocona z metody wyszukujacej po rodzaju nosnika zwrocila NULL",resultList);
		Assert.assertTrue("Blad, lista zwrocona z metody wyszukujacej po rodzaju nosnika jest pusta",resultList.size()>0);
		if(resultList.size()>0){
			for (int i = 0; i < resultList.size(); i++) {
				System.out.println("Znaleziono " + resultList.get(i).toString());
			}
		}
	}

	@Test
	public void findByTitleTest(){
		Game fifa12 = gameStore.findGameByTitle("FIFA 12");		
		Assert.assertNotNull("Blad, nie znaleziono gry FIFA 12 szukajac po tytule",fifa12);		
		if(fifa12!=null)
			System.out.println("Znaleziono gre FIFA 12 wyszujujac po tytule");
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
