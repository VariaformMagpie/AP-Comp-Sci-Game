public class Crossbow extends Weapon
{
    private String ammo;

    public Crossbow()
    {
        super("Crossbow", "Ol' Betsy.", 20, 25, 3, "The bolt thunks through your enemy!");
        ammo = "bolts";
    }

    public String getAmmo()
    {
        return ammo;
    }
    public String toString()
    {
        return super.toString();
    }
}
