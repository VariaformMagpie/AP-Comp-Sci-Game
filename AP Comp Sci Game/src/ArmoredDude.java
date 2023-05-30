public class ArmoredDude extends Goober
{
    public ArmoredDude()
    {
        super(150, 0, 5, 2, 2, 1);
    }

    public int attack1()
    {
        System.out.println("The armored behemoth swings its massive axe at you.");
        int a = super.attack(25, 35) + getStat(0);
        System.out.println("You are hit for " + a + " damage!");
        return a;
    }
    public String toString()
    {
        return "Big boss";
    }
}
