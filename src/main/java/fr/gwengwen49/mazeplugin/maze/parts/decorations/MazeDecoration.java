package fr.gwengwen49.mazeplugin.maze.parts.decorations;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.components.ComponentOf;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import org.bukkit.Location;
import org.bukkit.Material;
import java.util.Random;

public abstract class MazeDecoration implements Part
{

    private Material material;
    private Type type;
    public MazeDecoration(Type decorationType, Material material)
    {
    this.material = material;
    this.type = decorationType;
    }

    public MazeDecoration()
    {

    }
    public Type getPlacementType()
    {
        return type;
    }

    public Material getMaterial()
    {
        return material;
    }


    public enum Type
    {
        ROOF,
        MURAL,
        FLOOR;
    }

}
