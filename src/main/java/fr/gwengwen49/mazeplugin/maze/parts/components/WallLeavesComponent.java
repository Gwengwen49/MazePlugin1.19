package fr.gwengwen49.mazeplugin.maze.parts.components;

import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import fr.gwengwen49.mazeplugin.util.Functions;
import org.bukkit.Location;
import org.bukkit.Material;

public class WallLeavesComponent implements Component<Wall>{

    @Override
    public void generate(Location loc, Wall wall) {
        if(random.nextInt(5) == 1)
        {
            if(Functions.movedToNorth(loc).getBlock().getType() == Material.AIR)
            {

            }
        }
    }
}
