// Hunt the Wumpus Game
// Cave Class – Creates cave objects and links them to their neighboring caves
// Authors: Ezra Newman and Radha Munver
// Date: June 6th, 2023

public class Cave
{
    Cave[] linkedCaves = new Cave[3];   // linkedCaves array to be connected to a cave linked to adjacent caves
    CaveSystem caveSystem;  // access the caveSystem structure
    int cavenum;    // stores specific cave number

    // Construct a cave with its own numbers and linked with its neighbors'
    public Cave(int caveNumber, int caveNumber2, int caveNumber3, CaveSystem caveSystem, int thisCaveNum) {
        linkedCaves[0] = caveSystem.accessCave(caveNumber);
        linkedCaves[1] = caveSystem.accessCave(caveNumber2);
        linkedCaves[2] = caveSystem.accessCave(caveNumber3);
        this.caveSystem = caveSystem;
        cavenum = thisCaveNum;
    }

    // Construct a cave with no numbers or links (overload)
    public Cave() {
        linkedCaves[0] = null;
        linkedCaves[1] = null;
        linkedCaves[2] = null;
        this.caveSystem = null;
    }

    // set a cave number
    public void setCaveNum(int caveNum){
        this.cavenum = caveNum;
    }

    // set linked caves with input of neighbors' numbers
    public void setLinkedCaves(int caveNumber, int caveNumber2, int caveNumber3) {
        linkedCaves[0] = caveSystem.accessCave(caveNumber);
        linkedCaves[1] = caveSystem.accessCave(caveNumber2);
        linkedCaves[2] = caveSystem.accessCave(caveNumber3);
    }
    
    // set cave system
    public void setCaveSystem(CaveSystem caveSystem) {
        this.caveSystem = caveSystem;
    }

    // getter for cave number
    public int getCaveNum() {
        return cavenum;
    }

    // getter for linked caves
    public Cave[] getAdjacentCaves() {
        return linkedCaves;
    }
}
