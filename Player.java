public class Player {
    CaveSystem caveSystem;
    Cave currentCave;
    int arrows;
    boolean gameOver;

    public Player(CaveSystem caveSystem, Cave currentCave, int arrows, boolean alive) {
        this.caveSystem = caveSystem;
        this.currentCave = currentCave;
        this.arrows = 5;
        this.gameOver = false;

        int playerLoc = (int) (Math.random() * 20);
        while (!caveSystem.emptyCave(playerLoc)) {
            playerLoc = (int) (Math.random() * 20);
        }

        currentCave = caveSystem.accessCave(playerLoc);
    }

    private boolean isAdjacentTo(Cave loc) {
        for (Cave cave : currentCave.getAdjacentCaves()) {
            if (cave.equals(loc)) {
                return true;
            }
        }
        return false;
    }

    private void printRoomInfo() {

        currentCave.toString();
        System.out.println();

        if (isAdjacentTo(caveSystem.wumpusLoc)) {
            System.out.println("You smell something terrible!");
        }

        if (isAdjacentTo(caveSystem.bats[0]) || isAdjacentTo(caveSystem.bats[1])) {
            System.out.println("You hear a rustling.");
        }

        if (isAdjacentTo(caveSystem.pits[0]) || isAdjacentTo(caveSystem.pits[1])) {
            System.out.println("You feel a cold wind blowing.");
        }

        System.out.println();
    }

    public void shootArrow(int roomLoc) {
        Cave shotInto = caveSystem.accessCave(roomLoc);

        if (arrows > 0) {
            arrows--;
            // if room location contains Wumpus
            if (caveSystem.wumpusLoc.equals(shotInto)) {
                System.out.println("You killed the Wumpus! You win!");
                gameOver = true;
            }

            // ran out of arrows and Wumpus still alive
            else if (arrows == 0) {
                System.out.println("You ran out of arrows. Game over ☠☠☠");
                gameOver = true;
            }

            // if room location contains a bat
            else if (shotInto.equals(caveSystem.bats[0]) || shotInto.equals(caveSystem.bats[1])) {
                System.out.println("You killed a bat!");

                if (shotInto.equals(caveSystem.bats[0])) {
                    caveSystem.bats[0] = null;
                } else {
                    caveSystem.bats[1] = null;
                }
            }

             else if (???) {
                System.out.println("You missed the Wumpus! It woke up and moved to a random room.");
                int newRoom = findEmptyCave();
                cave.move(newRoom);
                
                //WHOOPS NEED TO DO THIS
            } 
    
            System.out.println();
            
        }

    }

    public void move(int room) {
        printRoomInfo();
        //NEED TO DO THIS
    }

    private void checkStatus() {
        if (currentCave.equals(caveSystem.wumpusLoc)) {
            System.out.println("You've been eaten by the Wumpus! Game over.");
            gameOver = true;
        } 

        else if (isAdjacentTo(caveSystem.bats[0]) || isAdjacentTo(caveSystem.bats[1])) {
            int newRoom = findEmptyCave;
            currentCave.move(newRoom);
            System.out.println("A bat picked you up and transported you to a random room!");
            checkStatus();
        } 

        else if (isAdjacentTo(caveSystem.pits[0]) || isAdjacentTo(caveSystem.pits[1])) {
            System.out.println("You fell into a bottomless pit! Game over.");
            gameOver = true;
        }
    }

}