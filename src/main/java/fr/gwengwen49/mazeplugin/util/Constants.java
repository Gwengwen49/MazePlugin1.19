package fr.gwengwen49.mazeplugin.util;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import org.bukkit.Location;

public class Constants {

    public static Location DECORATION_FLOOR_STARTPOS = new Location(SummoningCommand.getStartPos().getWorld(), SummoningCommand.getStartPos().getX(), SummoningCommand.getStartPos().getY()+1, SummoningCommand.getStartPos().getZ());


}
