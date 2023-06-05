public class Player {
    CaveSystem caveSystem;
    Cave currentCave;
    int arrows;
    boolean alive;

    public Player(CaveSystem caveSystem, Cave currentCave, int arrows, boolean alive) {
        this.caveSystem = caveSystem;
        this.currentCave = currentCave;
        this.arrows = 5;
        this.alive = true;

        int playerLoc = (int) (Math.random() * 20);
        while (!caveSystem.emptyCave(playerLoc)) {
            playerLoc = (int) (Math.random() * 20);
        }

        currentCave = caveSystem.accessCave(playerLoc);
    }

    public void shootArrow(int roomLoc) {
        if (arrows > 0) {
            arrows--;
            // if room location contains Wumpus
            if (caveSystem.wumpusLoc == roomLoc) {
                System.out.println("You killed the Wumpus! You win!");
            }

            // ran out of arrows and Wumpus still alive
            else if (arrows == 0) {
                alive = false;
                System.out.println("You ran out of arrows. Game over ☠☠☠");
            }

            // if room location contains a bat
            else if (roomLoc == caveSystem.bats[0] || roomLoc == caveSystem.bats[1]) {
                System.out.println("You killed a bat!");
                if (roomLoc == caveSystem.bats[0]) {
                    caveSystem.bats[0] = -1;
                } else {
                    caveSystem.bats[1] = -1;
                }
            }
            
        }
    }


}

/*
public class Player {
    private int loc;
    private int arrows;
    private boolean alive;

    public Player() {
        arrows = 5;
        loc = (int) (Math.random() * 20);
        alive = true;
    }

    public void shootArrow(int roomLoc) {
        if (arrows > 0) {
            arrows--;
            // if Wumpus location contains Wumpus
            System.out.println("You hear a scream!");
        }
    }

    public void enterRoom(int roomLoc) {
        loc = roomLoc;

        //if room is linked to Wumpus:
        System.out.println("You smell something terrible!");

        //if room is linked to Pit:
        System.out.println("You feel a cold wind blowing.");

        //if room is linked to Bat:
        System.out.println("You hear a rustling.");

        if (roomLoc == getWumpusLoc()) {
            System.out.println("The Wumpus ate you. Game over ☠☠☠");
            alive = false;
        }

        //if room contains Pit:
        System.out.println("You fell into a pit. Game over ☠☠☠");
        alive = false;

        //if room contains Bat:
        System.out.println("A bat picked you up and dropped you in a random empty room.");
        alive = false;
    }
}
 */