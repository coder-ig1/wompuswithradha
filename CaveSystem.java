public class CaveSystem {
    Cave[] caves = new Cave[20];
    public CaveSystem() {
        
    }
    public Cave accsesCave(int caveNumber) {
        return caves[caveNumber];
    }
}
