package Toy;

public final class ToyService {
    private static int staticId =-1;
    public static int setIdForToy() {
        staticId++;
        return staticId;
    }
    public static void createDuplicateToy(Toy toy, int total){
        for (int i = 1; i < total; i++) {
           new Toy(toy);
        }
    }
}
