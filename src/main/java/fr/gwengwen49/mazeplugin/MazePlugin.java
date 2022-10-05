package fr.gwengwen49.mazeplugin;


import fr.gwengwen49.mazeplugin.commands.SpawnPartCommand;
import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.parts.ChunkFeatures;
import fr.gwengwen49.mazeplugin.maze.parts.Parts;
import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.plugin.java.JavaPlugin;


public final class MazePlugin extends JavaPlugin {

    public static MazePlugin INSTANCE;
    @Override
    public void onEnable()
    {
        ChunkFeatures.register();
        Parts.register();
      getCommand("createmaze").setExecutor(new SummoningCommand());
      getCommand("part").setExecutor(new SpawnPartCommand());
      INSTANCE = this;
    }

    @Override
    public void onDisable() {


    }


}
