package fr.gwengwen49.mazeplugin.util;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import org.bukkit.Location;

public class Constants {

    private static Location DECORATION_FLOOR_STARTPOS;

    public static void init()
    {
        DECORATION_FLOOR_STARTPOS = new Location(SummoningCommand.getStartPos().getWorld(), SummoningCommand.getStartPos().getX(), SummoningCommand.getStartPos().getY()+1, SummoningCommand.getStartPos().getZ());
    }


    public static Location getDecorationFloorStartpos() {
        return DECORATION_FLOOR_STARTPOS;
    }


}
