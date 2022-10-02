package fr.gwengwen49.mazeplugin.maze.parts.decorations;

import com.sun.source.tree.Tree;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Random;

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
        int y = (int) startPos.getY();
        int z = (int) startPos.getZ();
            int randomTrunkPos = random.nextInt(-2, 2);
            int randomHeight = random.nextInt(getTrunkHeight()/2);
            for (int maxTrunkHeight = 0; maxTrunkHeight <= getTrunkHeight() - randomHeight; maxTrunkHeight++) {


                startPos.getWorld().getBlockAt(x, y + maxTrunkHeight, z).setType(getTrunk());

                if (maxTrunkHeight == getTrunkHeight() - randomHeight) {
                    for (int diameterX = x - getLeavesRadius(); diameterX <= x + getLeavesRadius(); diameterX++) {
                        for (int diameterY = z - getLeavesRadius(); diameterY <= z + getLeavesRadius(); diameterY++) {
                            int posY = y+getTrunkHeight()-randomHeight;
                            startPos.getWorld().getBlockAt(diameterX, posY, diameterY).setType(getLeaves());

                        }
                    }
                }
            }
        }

    public void generateLeaves(Location startPos, int x, int y, int z)
    {
        for (int diameterX = x - getLeavesRadius(); diameterX <= x + getLeavesRadius(); diameterX++) {
            for (int diameterY = z - getLeavesRadius(); diameterY <= z + getLeavesRadius(); diameterY++) {
                startPos.getWorld().getBlockAt(diameterX, y, diameterY).setType(getLeaves());

            }
        }
    }


    public Location movedToSouth(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ());
        return location1;
    }
    public Location movedToSouthEast(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ()-1);
        return location1;
    }
    public Location movedToEast(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ()-1);
        return location1;
    }
    public Location movedToNorthEast(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ()-1);
        return location1;
    }
    public Location movedToNorth(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ());
        return location1;
    }
    public Location movedToNorthWest(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ()+1);
        return location1;
    }
    public Location movedToWest(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ()+1);
        return location1;
    }
    public Location movedToSouthWest(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ()+1);
        return location1;
    }
}

