import java.util.Scanner;

public class Main
{
  private static boolean gameOn = true;
  private static CaveSystem cavesystem = new CaveSystem();
  private static Player player = new Player(cavesystem,findEmptyCave(cavesystem));
  private static Scanner takeInput = new Scanner(System.in);
  public static void main(String[] args)
  {
    // let's play a game...
    while(gameOn){
      String resultOfPrompt = promptForMove();
      doMove(resultOfPrompt);
      
    }
    
    
  }
  private static void doMove(String resultOfPrompt){
    
    if(resultOfPrompt.equals("1")){
      System.out.println("Which room would you like to move to?");
      String input2 = takeInput.nextLine();
      int roomNum = Integer.parseInt(input2);
    
      player.move(roomNum);
    }

    else if(resultOfPrompt.equals("2")){
      System.out.println("Which room would you like to shoot into?");
      String input2 = takeInput.nextLine();
      int roomNum = Integer.parseInt(input2);
      
      player.shootArrow(roomNum);
    }
    else{
      System.out.println("Invalid input");
      
    }
    
  }
  private static String promptForMove(){
    System.out.println("You are in cave ");
    player.printRoomInfo();
    System.out.println("What would you like to do?");
    System.out.println("1. Move");
    System.out.println("2. Shoot");
    String input = takeInput.nextLine();
    return input;
  }
  
  public static Cave findEmptyCave(CaveSystem caves){
    for (int i = 0; i < caves.caves.length; i++){
      if (caves.emptyCave(i)){
        return caves.accessCave(i);
      }
    }
    return null; //under normal circumstances this will never be ran 
  }
}
