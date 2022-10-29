package fr.gwengwen49.mazeplugin.maze.parts.pieces;
import org.bukkit.Location;
import org.bukkit.Material;

public class Floor extends MazePiece {

    private final Material[] materials;


    public Floor(Material material, Material... materials)
    {
        material = materials[0];
        this.materials = materials;

    }

    public Material[] getMaterials() {
        return materials;
    }

    @Override
    public void generate(Location startPos) {
        int rand = random.nextInt(this.getMaterials().length);
        Material material = this.getMaterials()[rand];
        startPos.getWorld().getBlockAt(startPos).setType(material);

    }


}
