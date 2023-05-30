import java.util.*;
public class Entity
{
    private int health;
    private int speed;
    // in order: bonk melee weapons, precision melee weapons, casting magic, ranged weapons
    private int strength;
    private int finesse;
    private int focus;
    private int sight;

    public Entity()
    {
        health = speed = strength = finesse = focus = sight = 0;
    }
    // Stats go 0 to 5
    public Entity(int h, int sp, int st, int fi, int fo, int si)
    {
        health = h;
        speed = sp;
        strength = st;
        finesse = fi;
        focus = fo;
        sight = si;
    }
    public int attack1()
    {
        return -100;
    }
    public void takeDamage(int d)
    {
        health -= d;
    }
    public int getStat(int type)
    {
        if(type == 0)
            return strength;
        if(type == 1)
            return finesse;
        if(type == 2)
            return focus;
        if(type == 3)
            return sight;
        if(type == 4)
            return speed;
        if(type == 5)
            return health;
        return 0;
    }
}
