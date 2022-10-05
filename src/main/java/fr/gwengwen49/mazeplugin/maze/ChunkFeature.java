package fr.gwengwen49.mazeplugin.maze;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import fr.gwengwen49.mazeplugin.maze.steps.GenStep;
import org.bukkit.Location;

import java.util.Optional;
import java.util.Random;

import static fr.gwengwen49.mazeplugin.maze.MazeConfig.chunkSize;

public record ChunkFeature<T extends Part>(T part, Class<? extends GenStep> genStep, int spawnInterval, int chanceOfSpawn) implements RegistryEntry
{
    public ChunkFeature build(Location startPos)
    {
        Location finalPlacement;
        for (int x = -chunkSize; x <= chunkSize; x = x + spawnInterval) {
            for (int z = -chunkSize; z <= chunkSize; z = z + spawnInterval) {
                Random random = new Random();
                if(chanceOfSpawn >= 1) {
                    int randInt = random.nextInt(chanceOfSpawn + 1);
                    if (randInt == 1) {
                        finalPlacement = new Location(startPos.getWorld(), startPos.getX() + x, startPos.getY(), startPos.getZ() + z);
                        part.generate(finalPlacement);
                    }
                }
                else if(chanceOfSpawn == 0)
                {
                    finalPlacement = new Location(startPos.getWorld(), startPos.getX() + x, startPos.getY(), startPos.getZ() + z);
                    part.generate(finalPlacement);
                }
            }
        }

        return this;
    }
}
