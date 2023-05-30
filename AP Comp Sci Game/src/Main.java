import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Player p = new Player();
            p.equip(new RustyShiv(), 0);
            p.equip(new Spear(), 1);
            p.equip(new Crossbow(), 2);
            p.equip(new BoltPouch(), 6);
            Scanner scan = new Scanner(System.in);
            System.out.println("Pick a room type: Normal (0) - Magic (1) - Boss (2)");
            int l = scan.nextInt();
            Game.setLocation(l);
            Game.combat(p);
            System.out.println("Yay, no fucking errors happened.");
        }
        catch(Exception e)
        {
            System.out.println("You fucked up. Talk to Jakob.");
        }
    }
}