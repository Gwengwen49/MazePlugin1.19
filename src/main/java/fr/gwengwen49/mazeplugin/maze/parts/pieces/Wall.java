package fr.gwengwen49.mazeplugin.maze.parts.pieces;

import static fr.gwengwen49.mazeplugin.maze.MazeConfig.*;

import fr.gwengwen49.mazeplugin.maze.parts.Direction;
import fr.gwengwen49.mazeplugin.util.Box;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

import javax.swing.*;
import java.awt.*;


public class Wall extends MazePiece {

    private int valuePlus = 16;
    private int valueMinus = 3;
    private int randomMaxValueForStartPlacement = 2;
    private Box dimensions;
    private Direction direction;
    private Material[] materials;
    public Wall(Box dimensions, Direction direction, Material... materials) {
        this.dimensions = dimensions;
        this.direction = direction;
        this.materials = materials;
    }

    public Wall(Direction direction) {
        this(new Box(wallMaxDimensions[0], wallMaxDimensions[1], wallMaxDimensions[2]), direction, wallMaterials);

    }

    public Box getDimensions() {
        return dimensions;
    }

    public Direction getDirection() {
        return direction;
    }
    public Material[] getMaterials() {
        return materials;
    }

    public Wall setDimensions(Box dimensions) {
       this.dimensions = dimensions;
        return this;
    }
    public Wall setDimensions(int x, int y, int z) {
        this.dimensions = new Box(x, y, z);
        return this;
    }

    public Wall setDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Wall setMaterials(Material[] materials) {
        this.materials = materials;
        return this;
    }

    public void setToNorth(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 <= startPos.getX()+x; x1++) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 >= startPos.getZ()-z; z1--) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
               }
            }
        }
    }

    public void setToWest(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 >= startPos.getX()-x; x1--) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 <= startPos.getZ()+z; z1++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
                }
            }
        }
    }

    public void setToSouth(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 <= startPos.getX()+x; x1++) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 <= startPos.getZ()+z; z1++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
                }
            }
        }
    }

    public void setToEast(Location startPos, int x, int y, int z, Material... materialsList)
    {
        for (int x1 = (int) startPos.getX(); x1 <= startPos.getX()+x; x1++) {
            for (int y1 = (int) startPos.getY(); y1 <= startPos.getY()+y; y1++) {
                for (int z1 = (int) startPos.getZ(); z1 <= startPos.getZ()+z; z1++) {
                    startPos.getWorld().getBlockAt(new Location(startPos.getWorld(), x1, y1, z1)).setType(materialsList[random.nextInt(materialsList.length)]);
                }
            }
        }
    }


    @Override
    public void generate(Location startPos) {

        if(this.getDirection().equals(Direction.NORTH))
        {
            this.setToNorth(startPos, dimensions.x(), dimensions.y(), dimensions.z(), getMaterials());
        }
        if(this.getDirection().equals(Direction.EAST))
        {
            this.setToEast(startPos, dimensions.x(), dimensions.y(), dimensions.z(), getMaterials());
        }
        if(this.getDirection().equals(Direction.SOUTH))
        {
            this.setToSouth(startPos, dimensions.x(), dimensions.y(), dimensions.z(), getMaterials());
        }
        if(this.getDirection().equals(Direction.WEST))
        {
            Bukkit.broadcastMessage("generate");
            this.setToWest(startPos, dimensions.x(), dimensions.y(), dimensions.z(), getMaterials());
        }
               if(this.getDirection().equals(Direction.RANDOM)){
                    switch (random.nextInt(4)) {
                        case 0: {
                            int x = dimensions.x();
                            int z = dimensions.z();
                            this.setToNorth(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x-valueMinus, x-1), random.nextInt(dimensions.y()-4, dimensions.y()), random.nextInt(z,z+valuePlus), this.getMaterials());

                        }

                        case 1: {
                            int x = dimensions.x();
                            int z = dimensions.z();
                            this.setToWest(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x,x+valuePlus), random.nextInt(dimensions.y()-4, dimensions.y()), random.nextInt(z-valueMinus, z-1), this.getMaterials());

                        }

                        case 2: {
                            int x = dimensions.x();
                            int z = dimensions.z();
                            this.setToSouth(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x-valueMinus, x-1), random.nextInt(dimensions.y()-4, dimensions.y()), random.nextInt(z,z+valuePlus), this.getMaterials());

                        }

                        case 3: {
                            int x = dimensions.x();
                            int z = dimensions.z();
                            this.setToEast(new Location(startPos.getWorld(), startPos.getX()+random.nextInt(0,randomMaxValueForStartPlacement), startPos.getY(), startPos.getZ()+random.nextInt(0,4)), random.nextInt(x,x+valuePlus), random.nextInt(dimensions.y()-4, dimensions.y()), random.nextInt(z-valueMinus, z-1), this.getMaterials());

                        }
                    }
                }
            }
    }





