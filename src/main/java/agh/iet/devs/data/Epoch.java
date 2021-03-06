package agh.iet.devs.data;

public class Epoch {
    public final double averageEnergy;
    public final double lifeExpectancy;
    public final double averageChildren;

    public final int dominatingGen;
    public final int animalCount;
    public final int foodCount;
    public final int epoch;

    public Epoch(int dominatingGen,
                 double averageEnergy, double lifeExpectancy, double averageChildren,
                 int animalCount, int foodCount, int epoch) {
        this.dominatingGen = dominatingGen;
        this.averageEnergy = averageEnergy;
        this.lifeExpectancy = lifeExpectancy;
        this.averageChildren = averageChildren;
        this.animalCount = animalCount;
        this.foodCount = foodCount;
        this.epoch = epoch;
    }

}
