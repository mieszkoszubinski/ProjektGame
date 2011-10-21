import java.util.*;
class Lista
{
	public Lista( String name, String surname)
	{
		games = new ArrayList<Game>();
		o = new Klient(name, surname,games);
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