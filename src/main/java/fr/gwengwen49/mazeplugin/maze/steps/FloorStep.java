package fr.gwengwen49.mazeplugin.maze.steps;

import org.bukkit.Location;

public class FloorStep extends GenStep{
    public FloorStep(Location startPos) {
        super(startPos, FloorStep.class);
    }

    @Override
    public boolean isInfinite() {
        return false;
    }
}
