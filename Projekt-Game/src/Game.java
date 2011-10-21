import java.util.*;
class Game
{
	private String title;
	private String type;
	public Game(String title, String type)
	{
		this.type=type;
		this.title=title;
	}
	public void printGame()
	{
			System.out.println("Game::"+title+" type "+type);
	}
}
