public class HealingPotion extends Potion
{
    public HealingPotion()
    {
        super("Healing Potion", "A glass bottle with a simple cork stopper. It holds a glimmering red liquid that reminds you of strawberry jam.");
    }

    public void potionFunction(Player p)
    {
        System.out.println("You uncap the potion bottle and drink it.");
        if (p.getStat(0) <= 40)
        {
            p.takeDamage(-20);
            System.out.println("You are healed for 20 health.");
        }
        else
        {
            int h = (60 - p.getStat(0));
            p.takeDamage(-h);
            System.out.println("You are healed for " + h + " health.");
        }
    }
}
