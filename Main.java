import java.util.Scanner;

public class Main
{
  private static boolean gameOn = true;
  public static void main(String[] args)
  {
    CaveSystem cavesystem = new CaveSystem()
    Player player = new Player(cavesystem,findEmptyCave(cavesystem));
    //put code here
    while(gameOn){
      promptForMove()
    }
    
  }
  private void promptForMove(){
    Scanner takeInput = new Scanner(System.in);
    System.out.println("you are in cave ")
  }
  
  public Cave findEmptyCave(CaveSystem caves){
    for(int i = 0; i <caves.caves.length; i++ ){
      if(caves.emptyCave(caves.accessCave(i))){
        return caves.accessCave(i);
      }
    }
    return null; //under regular circumstances this will never be ran 
  }
}
