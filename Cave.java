public class Cave {
    Cave[] linkedCaves = new Cave[3];
    CaveSystem caveSystem;
    public Cave(int caveNumber, int caveNumber2, int caveNumber3, CaveSystem caveSystem) {
        linkedCaves[0] = caveSystem.accsesCave(caveNumber);
        linkedCaves[1] = caveSystem.accsesCave(caveNumber2);
        linkedCaves[2] = caveSystem.accsesCave(caveNumber3);
    }
}
