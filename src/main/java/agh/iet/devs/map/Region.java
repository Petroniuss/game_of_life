package agh.iet.devs.map;

import agh.iet.devs.data.Vector;
import agh.iet.devs.elements.MapElement;

import java.util.Optional;
import java.util.Set;

public interface Region {

    /**
     * @return whether position is within region.
     */
    boolean isWithin(Vector position);

    /**
     * @return set with elements occupying position, empty if none.
     */
    Set<MapElement> objectsAt(Vector position);


    /**
     * @return set of all objects on the region.
     */
    Set<MapElement> objectsInRegion();

}
