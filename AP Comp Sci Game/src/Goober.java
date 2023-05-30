public class Goober extends Entity
{
    private int combatLocation;
    public Goober()
    {
        super();
    }
    public Goober(int h, int sp, int st, int fi, int fo, int si)
    {
        super(h, sp, st, fi, fo, si);
    }
    public static int attack(int low, int high)
    {
        return (int)(Math.random() * (high - low + 1)) + low;
    }
    public void setLocation(int l)
    {
        combatLocation = l;
    }

    public int getLocation()
    {
        return combatLocation;
    }
}