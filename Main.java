// Hunt the Wumpus Game
// Main Class
// Authors: Ezra Newman and Radha Munver
// Date: June 6th, 2023

import java.util.Scanner;

public class Main
{
  private static boolean gameOn = true; // check if game is not over
  private static CaveSystem cavesystem = new CaveSystem();  // create dodecahedron 20-cave structure
  private static Player player = new Player(cavesystem,findEmptyCave(cavesystem));  // create the player
  private static Scanner takeInput = new Scanner(System.in);  // create scanner object for taking task and cave input from user
  public static void main(String[] args)
  {
    // instructions
    System.out.println();
    System.out.println("Welcome to Hunt the Wumpus!");
    System.out.println();
    System.out.println("You are in a cave system with 20 caves. Each cave is linked to three other caves. In one of the caves is the Wumpus; it is your mission to kill it.");
    System.out.println("Two of the caves contain bottomless pits, and will plummett to your death upon entrance into their caves.");
    System.out.println("Two of the caves contain bats, which will pick you up and drop you in a random cave if you enter them.");
    System.out.println("You have 5 arrows on your quiver. Once you run out, if the Wumpus is not dead, the game is over.");
    System.out.println("You have two choices of action: 1) move caves to one of the three adjacent ones or 2) shoot an arrow at an adjacent cave.");
    System.out.println("If your arrow strikes the Wumpus, it dies and you win the game.");
    System.out.println("If the arrow misses the Wumpus, the Wumpus will be startled and move to another room.");
    System.out.println("If you strike a bat, the bat will die.");
    System.out.println("Upon entering a room, if the Wumpus is nearby, you will smell a disgusting odor.");
    System.out.println("If a bat(s) is/are nearby, you will hear a rustling.");
    System.out.println("If you are nearby a pit, you will feel a cold wind blowing.");
    System.out.println("It's your job to kill the Wumpus before you run out of arrows and make it out alive. Good luck!");

    // shall we play a game...
    while (gameOn) {
      // prompt user for action and do that action while the game isn't over
      String resultOfPrompt = promptForMove();
      doMove(resultOfPrompt);
    }
  }

  // ask user what they would like to do
  private static String promptForMove(){
    // Give information
    System.out.println(); // line break
    System.out.println("You are in cave " + String.valueOf(player.getCurrentCave().getCaveNum()) + ".");
    player.printRoomInfo();

    // prompt for move or shoot
    System.out.println("What would you like to do?");
    System.out.println("1. Move");
    System.out.println("2. Shoot");
    String input = takeInput.nextLine();
    return input;
  }


  // perform the action
  private static void doMove(String resultOfPrompt) {
    
    // if user selected "move":
    if (resultOfPrompt.equals("1")) {
      System.out.println("Which room would you like to move to?");
      String input2 = takeInput.nextLine();
      int roomNum = Integer.parseInt(input2);
    
      // move player to specified adjacent cave
      player.move(roomNum);
    }

    // if user selected "shoot":
    else if (resultOfPrompt.equals("2") ){
      System.out.println("Which room would you like to shoot into?");
      String input2 = takeInput.nextLine();
      int roomNum = Integer.parseInt(input2);
      
      // shoot arrow into specified adjacent cave
      player.shootArrow(roomNum);
    }

    // if not a correct input, state invalid
    else {
      System.out.println("Invalid Input.");
    }

  }
  
  // find an empty cave
  public static Cave findEmptyCave(CaveSystem caves){
    while (true) {
      int i = (int) (Math.random() * 20);

      if(caves.emptyCave(i)){
        return caves.accessCave(i);
      }
    }
  }

}
