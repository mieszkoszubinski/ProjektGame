import java.util.*;
class Klient {

public String imie;
public String nazwisko;
public ArrayList<Game> games = new ArrayList<Game>();
public Klient(String imie, String nazwisko)
{
this.imie = imie;
this.nazwisko = nazwisko;
}
public Klient(String imie, String nazwisko,ArrayList<Game> games)
{
this.imie=imie;
this.nazwisko=nazwisko;
this.games=games;
}
public void printGames()
{
for(Game c : this.games) c.printGame();
}

}