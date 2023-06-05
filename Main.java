import java.util.Scanner;

public class Main
{
  private static boolean gameOn = true;
  public static void main(String[] args)
  {
    CaveSystem cavesystem = new CaveSystem()
    Player player = new Player(cavesystem,cavesystem.accessCave(1));
    //put code here
    while(gameOn){
    }
    
  }
  private void promptForMove(){
    Scanner takeInput = new Scanner(System.in);
    System.out.println("you are in room ")
  }
}
