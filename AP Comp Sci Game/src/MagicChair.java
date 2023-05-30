public class MagicChair extends Goober
{
    public MagicChair()
    {
        super(60, 3, 1, 1, 4, 3);
    }

    public int attack1()
    {
        System.out.println("The table telekinetically throws an orbiting piece of debris at you!");
        return super.attack(15, 20) + getStat(3);
    }
    public String toString()
    {
        return "Magic Chair";
    }
}
