public class Player {
    CaveSystem caveSystem;
    Cave currentCave;
    int arrows;

    public Player(CaveSystem caveSystem, Cave currentCave) {
        this.caveSystem = caveSystem;
        this.currentCave = currentCave;
        this.arrows = 5;
        

        int playerLoc = (int) (Math.random() * 20);
        while (!caveSystem.emptyCave(playerLoc)) {
            playerLoc = (int) (Math.random() * 20);
        }

        currentCave = caveSystem.accessCave(playerLoc);
    }
    public void setRandomValidPLayerLoc(){
        int playerLoc = (int) (Math.random() * 20);
        while (!caveSystem.emptyCave(playerLoc)) {
            playerLoc = (int) (Math.random() * 20);
        }
    }

    private boolean isAdjacentTo(Cave loc) {
        for (Cave cave : currentCave.getAdjacentCaves()) {
            if (cave.equals(loc)) {
                return true;
            }
        }
        return false;
    }

    public void printRoomInfo() {

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
        System.out.println("You have " + arrows + " arrows left.");
        System.out.println();
        System.out.println("You are next to rooms " + currentCave.getAdjacentCaves()[0].getCaveNum() + ", "
                                                    + currentCave.getAdjacentCaves()[1].getCaveNum() + ", or "
                                                    + currentCave.getAdjacentCaves()[2].getCaveNum() + ".");
    }

    public void shootArrow(int roomLoc) {
        Cave shotInto = caveSystem.accessCave(roomLoc);

        if (arrows > 0) {
            arrows--;
            // if room location contains Wumpus
            if (caveSystem.wumpusLoc.equals(shotInto)) {
                System.out.println("You killed the Wumpus! You win!");
                System.exit(0);
            }

            // ran out of arrows and Wumpus still alive
            else if (arrows == 0) {
                System.out.println("You ran out of arrows. Game over ☠☠☠");
                System.exit(0);
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

             else {
                System.out.println("You missed the Wumpus! It woke up and moved to a random room.");
                caveSystem.randomWumpus();
                
                //WHOOPS NEED TO DO THIS
            } 
    
            System.out.println();
            
        }

    }
    public Boolean move(int roomLoc){
        Cave moveTo = caveSystem.accessCave(roomLoc);
        currentCave = moveTo;
        return checkStatus();
    }

    

    private boolean checkStatus() {
        if (currentCave.equals(caveSystem.wumpusLoc)) {
            System.out.println("You've been eaten by the Wumpus! Game over.");
            return false;
        } 

        else if (isAdjacentTo(caveSystem.bats[0]) || isAdjacentTo(caveSystem.bats[1])) {
            setRandomValidPLayerLoc();
            System.out.println("A bat picked you up and transported you to a random room!");
            checkStatus();
            return true;
        } 

        else if (isAdjacentTo(caveSystem.pits[0]) || isAdjacentTo(caveSystem.pits[1])) {
            System.out.println("You fell into a bottomless pit! Game over.");
            return false;
        }
            

                return true;
            
    }

}