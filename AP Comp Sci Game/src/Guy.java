public class Guy extends Goober
{
    public Guy()
    {
        super(30, 1, 2, 2, 0, 0);
    }

    public int attack1()
    {
        System.out.println("The skeleton rattles as it whips its arms towards you.");
        return super.attack(5, 10) + getStat(0);
    }
    public String toString()
    {
        return "Skeleton";
    }
}
