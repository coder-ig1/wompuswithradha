// Hunt the Wumpus Game
// Player Class – Controls all the "behind-the scenes" player interactions
// Authors: Ezra Newman and Radha Munver
// Date: June 6th, 2023

public class Player 
{
    CaveSystem caveSystem;  // create cave system object
    Cave currentCave;   // create cave to store location of player's current cave
    int arrows; // create int var storing the number of arrows remaining

    // construct player with the above fields
    public Player(CaveSystem caveSystem, Cave currentCave) {
        this.caveSystem = caveSystem;
        this.currentCave = currentCave;
        this.arrows = 5;
        
        // establish player's initial cave location randomly out of the 20 caves
        int playerLoc = (int) (Math.random() * 20);
        while (!caveSystem.emptyCave(playerLoc))    // ensure that the cave is empty so that the game may begin
            { playerLoc = (int) (Math.random() * 20); }

        currentCave = caveSystem.accessCave(playerLoc); // set current cave as a Cave object
    }

    // if the player is to be randomly transported, chech that it can be moved to an appropriate / valid cave
    public void setRandomValidPLayerLoc() {
        int playerLoc = (int) (Math.random() * 20);
        while (!caveSystem.emptyCave(playerLoc))
            { playerLoc = (int) (Math.random() * 20); }

        currentCave = caveSystem.accessCave(playerLoc); // set *new* current cave as a Cave object
    }

    // check if a cave is one of the adjacent caves to current cave
    private boolean isAdjacentTo(Cave loc) {
        for (Cave cave : currentCave.getAdjacentCaves()) {
            if (cave.equals(loc)) {
                return true;
            }
        }
        return false;
    }

    // set up information to provide the player if there is something "special" upon walking into a cave
    public void printRoomInfo() {
        System.out.println();   // line break

        // if near Wumpus...
        if (isAdjacentTo(caveSystem.wumpusLoc)) 
            { System.out.println("You smell something terrible!"); }

        // if near one or both bats...
        if (isAdjacentTo(caveSystem.bats[0]) || isAdjacentTo(caveSystem.bats[1])) 
            { System.out.println("You hear a rustling."); }

        // if near one or both pits...
        if (isAdjacentTo(caveSystem.pits[0]) || isAdjacentTo(caveSystem.pits[1]))
            { System.out.println("You feel a cold wind blowing."); }

        // specify number of arrows remaining
        System.out.println();
        System.out.println("You have " + arrows + " arrows left.");
        System.out.println();

        // provide the adjacent cave locations
        System.out.println("You are next to rooms " + currentCave.getAdjacentCaves()[0].getCaveNum() + ", "
                                                    + currentCave.getAdjacentCaves()[1].getCaveNum() + ", or "
                                                    + currentCave.getAdjacentCaves()[2].getCaveNum() + ".");
    }

    // if the player chooses to shoot an arrow into cave number, roomLoc:
    public void shootArrow(int roomLoc) {
        // conver cave number into cave object
        Cave shotInto = caveSystem.accessCave(roomLoc);

        // if there's were more than 0 arrows when the player attempted to shoot, shoot & decrement inventory / count
        if (arrows > 0) {
            arrows--;
            // if room location contains Wumpus, eaten & game over
            if (caveSystem.wumpusLoc.equals(shotInto)) {
                System.out.println("You killed the Wumpus! You win!");
                System.exit(0);
            }

            // ran out of arrows but Wumpus still alive, game over
            else if (arrows == 0) {
                System.out.println("You ran out of arrows. Game over ☠☠☠");
                System.exit(0);
            }

            // if room location contains a bat, bat dies
            else if (shotInto.equals(caveSystem.bats[0]) || shotInto.equals(caveSystem.bats[1])) {
                System.out.println("You killed a bat!");

                // remove the now dead bat's ability to move player and participate in game
                if (shotInto.equals(caveSystem.bats[0])) 
                    { caveSystem.bats[0] = null; }
                else 
                    { caveSystem.bats[1] = null; }
            }

            // if arrow shot into a pit or nothingness (AKA, missed the Wumpus), Wumpus moves randomly
             else {
                System.out.println("You missed the Wumpus! It woke up and moved to a random room.");
                caveSystem.randomWumpus();
            } 
    
            System.out.println();   // line break
        }
    }

    // if the player chooses to move into cave number, roomLoc, move them to that cave
    public boolean move(int roomLoc) {
        Cave moveTo = caveSystem.accessCave(roomLoc);
        currentCave = moveTo;
        return checkStatus();   // give the player the updated status and information about neighbors and life
    }

    // provide the appropriate / necessary information about the player's status in the game and their location
    private boolean checkStatus() {

        // case 1: eaten by Wumpus --> die
        if (currentCave.equals(caveSystem.wumpusLoc)) {
            System.out.println("You've been eaten by the Wumpus! Game over.");
            System.exit(0);
        } 

        // case 2: picked up by bat --> move to random, valid cave
        else if (isAdjacentTo(caveSystem.bats[0]) || isAdjacentTo(caveSystem.bats[1])) {
            setRandomValidPLayerLoc();
            System.out.println("A bat picked you up and transported you to a random room!");
            checkStatus();
            return true;
        } 

        // case 3: fell into pit --> die
        else if (isAdjacentTo(caveSystem.pits[0]) || isAdjacentTo(caveSystem.pits[1])) {
            System.out.println("You fell into a bottomless pit! Game over.");
            System.exit(0);
        }
        
        return true;    // indication of game still running
    }

    // getter for the current cave for accessibility in other classes
    public Cave getCurrentCave() {
        return currentCave;
    }

}