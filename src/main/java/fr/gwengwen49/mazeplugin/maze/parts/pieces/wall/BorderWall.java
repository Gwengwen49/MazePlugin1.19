package fr.gwengwen49.mazeplugin.maze.parts.pieces.wall;

import fr.gwengwen49.mazeplugin.maze.parts.Direction;
import fr.gwengwen49.mazeplugin.util.Box;
import org.bukkit.Location;
import org.bukkit.Material;

import static fr.gwengwen49.mazeplugin.maze.Parameters.*;
public class BorderWall extends Wall
{


    public BorderWall(Box dimensions, Direction direction, Material... materials) {
        super(dimensions, direction, materials);
    }

    @Override
    public void generate(Location startPos) {
        for (int x = -chunkSize; x <= chunkSize; x++) {
            for (int z = -chunkSize; z <= chunkSize; z++) {
                for (int y = 1; y <= 45; y++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), startPos.getX() + x, startPos.getY() + y, startPos.getZ() - chunkSize)).setType(Material.STONE);
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), startPos.getX() + x, startPos.getY() + y, startPos.getZ() + chunkSize)).setType(Material.STONE);
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), startPos.getX() - chunkSize, startPos.getY() + y, startPos.getZ() + z)).setType(Material.STONE);
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), startPos.getX() + chunkSize, startPos.getY() + y, startPos.getZ() + z)).setType(Material.STONE);
                }

            }
        }
    }
}
