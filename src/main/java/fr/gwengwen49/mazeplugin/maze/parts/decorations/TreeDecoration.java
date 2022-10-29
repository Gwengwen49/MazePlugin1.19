package fr.gwengwen49.mazeplugin.maze.parts.decorations;

import fr.gwengwen49.mazeplugin.util.Box;
import fr.gwengwen49.mazeplugin.util.Constants;
import fr.gwengwen49.mazeplugin.util.Functions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class TreeDecoration extends MazeDecoration{

    private Material leaves;
    private Material trunk;
    private int trunkHeight;
    private int leavesRadius;
    protected TreeDecoration(Type decorationType, Material material) {
        super(decorationType, material);
    }

    public TreeDecoration()
    {

    }
    public TreeDecoration(Type decorationType, Material leaves, int maxLeavesRadius, Material trunk, int maxTrunkHeight)
    {
        this(decorationType, null);
        this.leaves = leaves;
        this.trunk = trunk;
        this.trunkHeight = maxTrunkHeight;
        this.leavesRadius = maxLeavesRadius;
    }

    public Material getLeaves() {
        return leaves;
    }

    public Material getTrunk() {
        return trunk;
    }

    public TreeDecoration setLeaves(Material leaves) {
        this.leaves = leaves;
        return this;
    }

    public TreeDecoration setTrunk(Material trunk) {
        this.trunk = trunk;
        return this;
    }

    public int getTrunkHeight() {
        return trunkHeight;
    }

    public int getLeavesRadius() {
        return leavesRadius;
    }

    public TreeDecoration setTrunkHeight(int trunkHeight) {
        this.trunkHeight = trunkHeight;
        return this;
    }

    public TreeDecoration setLeavesRadius(int leavesRadius) {
        this.leavesRadius = leavesRadius;
        return this;
    }

    @Override
    public void generate(Location startPos) {

        int x = (int) startPos.getX();
        int y = (int) Constants.getDecorationFloorStartpos().getY();
        int z = (int) startPos.getZ();
            int randomHeight = random.nextInt(getTrunkHeight()/2);
            for (int finalTrunkHeight = 0; finalTrunkHeight <= getTrunkHeight() - randomHeight; finalTrunkHeight++) {
                Location loc = new Location(startPos.getWorld(), x, y+finalTrunkHeight, z);
                if(random.nextInt(3) == 1)
                {
                    switch(random.nextInt(8))
                    {
                        case 0 : loc = Functions.movedToSouth(loc);
                        case 1 : loc = Functions.movedToSouthEast(loc);
                        case 2 : loc = Functions.movedToEast(loc);
                        case 3 : loc = Functions.movedToNorthEast(loc);
                        case 4 : loc = Functions.movedToNorth(loc);
                        case 5 : loc = Functions.movedToNorthWest(loc);
                        case 6 : loc = Functions.movedToWest(loc);
                        case 7 : loc = Functions.movedToSouthWest(loc);
                    }
                }
                Functions.setMaterial(loc, getTrunk());
                if (finalTrunkHeight == getTrunkHeight() - randomHeight)
                {
                    this.generateLeaves(startPos.getWorld(), x, y+finalTrunkHeight, z);
                        }
                    }
                }

    public void generateLeaves(World world, int x, int y, int z)
    {
        Box.generate(x-getLeavesRadius(), x+getLeavesRadius(), y, y, z-getLeavesRadius(), z+getLeavesRadius(), (x1, y1, z1) -> Functions.setMaterial(world, x1, y1, z1, this.leaves));
    }

}

