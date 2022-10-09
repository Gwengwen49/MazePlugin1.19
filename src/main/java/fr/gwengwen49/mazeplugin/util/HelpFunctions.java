package fr.gwengwen49.mazeplugin.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class HelpFunctions
{

    public static boolean isAir(Location location)
    {
        return location.getWorld().getBlockAt(location).getType() == Material.AIR;
    }

    /**
     * Return true if the block at the specified location is composed by the specified material
     * @param location
     * @param material
     * @return
     */
    public static boolean isMaterial(Location location, Material material)
    {
        return location.getWorld().getBlockAt(location).getType() == material;
    }

    public static int convertToPercentage(float total, float number)
    {
        float finalPercentage = (number/total)*100;
        return (int)finalPercentage;

    }
    public static Location movedToSouth(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ());
        return location1;
    }
    public static Location movedToSouthEast(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ()-1);
        return location1;
    }
    public static Location movedToEast(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ()-1);
        return location1;
    }
    public static Location movedToNorthEast(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ()-1);
        return location1;
    }
    public static Location movedToNorth(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ());
        return location1;
    }
    public static Location movedToNorthWest(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()-1, location.getY(), location.getZ()+1);
        return location1;
    }
    public static Location movedToWest(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ()+1);
        return location1;
    }
    public static Location movedToSouthWest(Location location)
    {
        Location location1 = new Location(location.getWorld(), location.getX()+1, location.getY(), location.getZ()+1);
        return location1;
    }

}
