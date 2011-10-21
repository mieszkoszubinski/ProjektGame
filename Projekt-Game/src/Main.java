
import java.util.*;
public class Main
	{
		public static void main( String [] argv )
		{	
			Lista lst = new Lista("mhm","aha");
			lst.getGames().add(new Game("FIFA 12","sportowa"));
			lst.getGames().add(new Game("Wiedzmin","RPG"));
			lst.getGames().add(new Game("Battlefield 3","FPS"));
			lst.getGames().add(new Game("Call of Duty 3","FPS"));
			lst.getKlient().printGames();
		}
}
