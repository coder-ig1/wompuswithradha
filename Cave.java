public class Cave {
    Cave[] linkedCaves = new Cave[3];
    CaveSystem caveSystem;
    public Cave(int caveNumber, int caveNumber2, int caveNumber3, CaveSystem caveSystem) {
        linkedCaves[0] = caveSystem.accsesCave(caveNumber);
        linkedCaves[1] = caveSystem.accsesCave(caveNumber2);
        linkedCaves[2] = caveSystem.accsesCave(caveNumber3);
        this.caveSystem = caveSystem;
    }
    public Cave(){
        linkedCaves[0] = null;
        linkedCaves[1] = null;
        linkedCaves[2] = null;
        this.caveSystem = null;
    }
    public void setLinkedCaves(int caveNumber, int caveNumber2, int caveNumber3) {
        linkedCaves[0] = caveSystem.accsesCave(caveNumber);
        linkedCaves[1] = caveSystem.accsesCave(caveNumber2);
        linkedCaves[2] = caveSystem.accsesCave(caveNumber3);
    }
    public void setCaveSystem(CaveSystem caveSystem) {
        this.caveSystem = caveSystem;
    }
}
