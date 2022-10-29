package fr.gwengwen49.mazeplugin.util;


public record Box(int x, int y, int z)
{
    public static Box generate(int startX, int xMax, int startY, int yMax, int startZ, int zMax, Generator thingToDo)
    {
        for (int X1 = startX; X1 <= xMax; X1++ )
        {
            for (int Y1 = startY; Y1 <= yMax; Y1++)
            {
                for(int Z1 = startZ; Z1 <= zMax; Z1++)
                {
                    thingToDo.generate(X1, Y1, Z1);
                }
            }
        }
    return new Box(xMax, yMax, zMax);
    }

    public int[] asArray()
    {
        return new int[]{this.x, this.y, this.z};
    }

    @FunctionalInterface
    public interface Generator {
        void generate(int x, int y, int z);
    }
}
