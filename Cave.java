public class Cave {
    Cave[] linkedCaves = new Cave[3];
    CaveSystem caveSystem;
    int cavenum;

    public Cave(int caveNumber, int caveNumber2, int caveNumber3, CaveSystem caveSystem, int thisCaveNum) {
        linkedCaves[0] = caveSystem.accessCave(caveNumber);
        linkedCaves[1] = caveSystem.accessCave(caveNumber2);
        linkedCaves[2] = caveSystem.accessCave(caveNumber3);
        this.caveSystem = caveSystem;
        cavenum = thisCaveNum;
    }

    public Cave() {
        linkedCaves[0] = null;
        linkedCaves[1] = null;
        linkedCaves[2] = null;
        this.caveSystem = null;
    }
    public void setCaveNum(int caveNum){
        this.cavenum = caveNum;
    }

    public void setLinkedCaves(int caveNumber, int caveNumber2, int caveNumber3) {
        linkedCaves[0] = caveSystem.accessCave(caveNumber);
        linkedCaves[1] = caveSystem.accessCave(caveNumber2);
        linkedCaves[2] = caveSystem.accessCave(caveNumber3);
    }
    
    public void setCaveSystem(CaveSystem caveSystem) {
        this.caveSystem = caveSystem;
    }

    public int getCaveNum() {
        return cavenum;
    }

    public Cave[] getAdjacentCaves() {
        return linkedCaves;
    }

    @Override 
    public String toString(){
        return "";
    }
}
