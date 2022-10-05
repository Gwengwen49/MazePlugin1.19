package fr.gwengwen49.mazeplugin.maze.steps;

import org.bukkit.Location;

public class DecorationStep extends GenStep {


    public DecorationStep(Location startPos) {
        super(startPos, DecorationStep.class);
    }

    @Override
    public boolean isInfinite() {
        return false;
    }
}
