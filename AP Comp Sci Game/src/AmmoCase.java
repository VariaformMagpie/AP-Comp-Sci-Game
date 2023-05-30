public class AmmoCase extends Item
{
    private String ammoType;
    private int ammoStored;

    public AmmoCase(String a, int s, String n, String d)
    {
        super(n, d);
        ammoType = a;
        ammoStored = s;
    }

    public String getAmmoType()
    {
        return ammoType;
    }
    public int getAmmoStored()
    {
        return ammoStored;
    }
    public void shoot()
    {
        ammoStored--;
    }
}
