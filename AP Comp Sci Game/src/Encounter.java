import java.util.*;

public class Encounter
{
    private String flavor;
    private ArrayList<Entity> enemies;

    public Encounter(String f, ArrayList<Entity> e)
    {
        flavor = f;
        enemies = e;
    }
    public String toString()
    {
        return flavor + "\n\n----------------------------\n";
    }
}
