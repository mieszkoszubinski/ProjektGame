import java.util.*;
class Game
{
private String tytul;
private String typ;
public Game(String tytul, String typ)
{
this.typ=typ;
this.tytul=tytul;
}
public void printGame()
{
System.out.println("Game::"+tytul+" typ "+typ);
}
}
