public class Player {
    CaveSystem caveSystem;
    int currentCave;
    
    public Player(CaveSystem caveSystem, int currentCave) {
        this.caveSystem = caveSystem;
        this.currentCave = currentCave;
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