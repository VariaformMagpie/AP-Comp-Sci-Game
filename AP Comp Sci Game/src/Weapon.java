public class Weapon extends Item
{
    public int lowDamage;
    public int highDamage;
    // 0 = strength, 1 = finesse, 2 = focus, 3 = sight
    public int type;
    public String attackFlavor;

    public Weapon(String n, String d, int l, int h, int t, String a)
    {
        super(n, d);
        lowDamage = l;
        highDamage = h;
        type = t;
        attackFlavor = a;
    }

    public int weaponAttack()
    {
        System.out.println(attackFlavor);
        return ((int)(Math.random() * (highDamage - lowDamage + 1)) + lowDamage);
    }
    public int getType()
    {
        return type;
    }
    public String getAmmo()
    {
        return "default";
    }
    public String toString()
    {
        return super.getName();
    }
}
