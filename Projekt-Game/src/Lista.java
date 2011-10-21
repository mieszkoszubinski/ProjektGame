import java.util.*;
class Lista
{
public Lista( String imie, String nazwisko)
{
games = new ArrayList<Game>();
o = new Klient(imie,nazwisko,games);
}
private ArrayList<Game> games;
private Klient o;
Klient getKlient()
{
return o;
}
ArrayList<Game> getGames()
{
return games;
}
}