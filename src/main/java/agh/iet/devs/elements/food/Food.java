package agh.iet.devs.elements.food;

import agh.iet.devs.data.Vector;
import agh.iet.devs.elements.AbstractMapElement;

public class Food extends AbstractMapElement {

    public Food(Vector initialPosition, int initialEnergy) {
        super(initialPosition, initialEnergy);
    }

    @Override
    protected void update() {
        // Ignore!
    }
}
