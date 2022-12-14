package fr.gwengwen49.mazeplugin.maze.parts.decorations;


import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.Location;
import org.bukkit.Material;

public class SimpleBlockMazeDecoration extends MazeDecoration
{

    public SimpleBlockMazeDecoration(Type decorationType, Material material) {
        super(decorationType, material);
    }


    @Override
    public void generate(Location startPos) {

        switch(this.getPlacementType())
        {
            case FLOOR :
            {
                    startPos.getWorld().getBlockAt(Constants.getDecorationFloorStartpos()).setType(this.getMaterial());

            }

            case MURAL :
            {

            }

            case ROOF:
            {

            }
        }
    }

}
