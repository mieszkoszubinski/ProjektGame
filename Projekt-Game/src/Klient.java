
import java.util.*;
class Klient {

	public String name;
	public String surname;
	public ArrayList<Game> games = new ArrayList<Game>();
	public Klient(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}
	public Klient(String name, String surname,ArrayList<Game> games)
	{
		this.name=name;
		this.surname=surname;
		this.games=games;
	}
	public void borrowGame(Game g){
		games.add(g);
	}
	public void returnGame(Game g){
		games.remove(g);
	}
	public int isGame(Game g){
		return games.indexOf(g);
	}
	public void changeGame(Game g, String newTitle, String newType){
		g.title= newTitle;
		g.type = newType;
	}
	public void printGames()
	{
		for(Game c : this.games) c.printGame();
	}

}