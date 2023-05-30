import java.util.*;
public class Player extends Entity
{
    // 0 main hand, 1 offhand, 2 scabbard, 3-5 hip pouches, 6 quiver
    public Item[] equipped = new Item[7];
    public Weapon[] weapons = new Weapon[3];
    public Item[][] inventory = new Item[10][5];

    public Player()
    {
        super(60, 2, 2, 2, 2, 2);
    }

    // this goes 0-2
    public void equip(Item i, int l)
    {
        if (l <= 7)
            equipped[l] = i;
        if (l <= 2)
            weapons[l] = (Weapon)i;
    }
    public int playerAttack(int hand)
    {
        String a = "";
        boolean b = false;
        try
        {
            a = weapons[hand].getAmmo();
            b = true;
        }
        catch (Exception e)
        {
            b = false;
        }
        if (b && !(a.equalsIgnoreCase("default")))
        {
            if (a.equalsIgnoreCase(((AmmoCase)equipped[6]).getAmmoType()) && ((AmmoCase)equipped[6]).getAmmoStored() != 0)
            {
                int d = weapons[hand].weaponAttack() + getStat(weapons[hand].getType());
                ((AmmoCase)equipped[6]).shoot();
                System.out.println("You hit for " + d + " damage.");
                return d;
            }
            else
            {
                System.out.println("You don't have ammo for that.");
            }
        }
        else
        {
            int d = weapons[hand].weaponAttack() + getStat(weapons[hand].getType());
            System.out.println("You hit for " + d + " damage.");
            return d;
        }
        return -100;
    }
    public String toString()
    {
        return "Player";
    }
}
