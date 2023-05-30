import java.util.*;
import java.util.ArrayList;

public class Game
{
    public static ArrayList<Entity> turnOrder;
    // 0 = normal room, 1 = magic room, 2 = boss room
    public static int locator = 0;
    public static ArrayList<Encounter> encounterList = new ArrayList<Encounter>();
    public static ArrayList<Entity> combatOrder = new ArrayList<Entity>();

    //will try and run attack1 for every goober that comes in the turn order
    public static void gooberAttack(Player p, Entity a)
    {
        try
        {
            int d = a.attack1();
            p.takeDamage(d);
            System.out.println("You take " + d + " damage.");
        }
        catch (Exception e)
        {
            System.out.println("You done goofed: either that's not actually a Goober, or attack1 does not exist, and it should. Talk to Jakob");
        }
    }

    public static void setLocation(int l)
    {
        locator = l;
    }

    public static Goober locateEnemy(int lo)
    {
        for(Entity e : combatOrder)
        {
            if(e.getClass() != Player.class)
            {
                if(((Goober)e).getLocation() == lo)
                {
                    return (Goober)e;
                }
            }
        }
        return null;
    }

    public static boolean checkHP()
    {
        int enemyCount = combatOrder.size() - 1;
        int deadCount = 0;
        for (Entity e : combatOrder)
        {
            if (e.getClass() == Player.class && e.getStat(5) <= 0)
            {
                System.out.println("You have perished. Game over.");
                return false;
            }
            else if (e.getStat(5) <= 0)
                deadCount++;
        }
        if (deadCount == enemyCount)
        {
            System.out.println("All enemies have been vanquished.");
            System.out.println("\n----------------------------\n");
            return false;
        }
        return true;
    }

    public static void sortCombatOrder()
    {
        combatOrder.sort((a, b) -> b.getStat(4) - a.getStat(4));
    }

    // main gameplay feature
    public static void combat(Player p)
    {
        Scanner in = new Scanner(System.in);
        if (locator == 0)
        {
            encounterList.clear();
            combatOrder.add(new Guy());
            encounterList.add(new Encounter("\nThe lid of a coffin lying on the floor is pried open by a bony hand. A skeleton jumps out, eyes fixed on you.", combatOrder));
        }
        else if (locator == 1)
        {
            encounterList.clear();
            combatOrder.add(new MagicChair());
            encounterList.add(new Encounter("\nA rotting table suddenly floats up off the ground, as various bits of debris begin swirling around it.", combatOrder));
        }
        else if (locator == 2)
        {
            encounterList.clear();
            combatOrder.add(new ArmoredDude());
            encounterList.add(new Encounter("\nHeralded by the clanking of plate armor and the stomping of metal feet, a massive armored warrior carrying an equally big bec de corbin enters the room.", combatOrder));
        }
        System.out.println(encounterList.get(0));
        combatOrder.add(p);
        sortCombatOrder();
        while (checkHP())
        {
            for (Entity a : combatOrder)
            {
                in = new Scanner(System.in);
                if (a.getClass() == Player.class && a.getStat(5) > 0)
                {
                    for (int action = 2; action > 0; action--)
                    {
                        System.out.println("Current Health: " + p.getStat(5));
                        System.out.print("\nActions: ");
                        System.out.println("Attack (0) - Switch Weapon (1) - Item (2) - Check Bag (3) - Run (4)");
                        String input = in.nextLine();
                        if (input.equalsIgnoreCase("Attack") || input.equalsIgnoreCase("0"))
                        {
                            System.out.println("\nChoose Target: ");
                            int i = 0;
                            for (Entity e : combatOrder)
                            {
                                if (e.getClass() != Player.class)
                                {
                                    try
                                    {
                                        ((Goober) e).setLocation(i);
                                        System.out.print(e.toString() + " (" + ((Goober) e).getLocation() + ")");
                                        i++;
                                        if (i != combatOrder.size() - 1)
                                            System.out.print(" - ");
                                    }
                                    catch (Exception ee)
                                    {
                                        System.out.print("");
                                    }
                                }
                            }
                            System.out.println("");
                            int target = in.nextInt();
                            System.out.print("\nAttacks: ");
                            i = 0;
                            try
                            {
                                for (Weapon w : p.weapons)
                                {
                                    try
                                    {
                                        System.out.print(w.getName() + " (" + i + ")");
                                        i++;
                                        if (i != p.weapons.length)
                                            System.out.print(" - ");
                                    }
                                    catch (Exception e)
                                    {
                                        System.out.print("");
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.print("You don't have weapons, idiot.");
                                System.exit(69);
                            }
                            System.out.println("");
                            int x = in.nextInt();
                            int attack = p.playerAttack(x);
                            locateEnemy(target).takeDamage(attack);
                            if (x == 2)
                            {
                                action--;
                            }
                            System.out.println("\n----------------------------\n");
                        }
                        else if (input.equalsIgnoreCase("Switch") || input.equalsIgnoreCase("Switch Weapon") || input.equalsIgnoreCase("1"))
                        {
                            try
                            {
                                for (int i = 0; i < 2; i++)
                                {
                                    try
                                    {
                                        System.out.print(p.weapons[i].getName() + " (" + i + ")");
                                        if (i != p.weapons.length - 2)
                                            System.out.print(" - ");
                                    }
                                    catch (Exception e)
                                    {
                                        System.out.print("");
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                System.out.print("You don't have weapons, idiot.");
                                System.exit(69);
                            }
                            System.out.println("\nWhich weapon?");
                            int l = in.nextInt();
                            System.out.println("You draw your " + p.weapons[2].getName() + " and put away your " + p.weapons[l].getName() + ".");
                            Weapon temp = p.weapons[2];
                            p.weapons[2] = p.weapons[l];
                            p.weapons[l] = temp;
                            System.out.println("\n----------------------------\n");
                        }
                        else if (input.equalsIgnoreCase("Item") || input.equalsIgnoreCase("2"))
                        {
                            System.out.println("\nWhere are you looking?");

                        }
                    }
                }
                else if (a.getStat(5) > 0)
                {
                    gooberAttack(p, a);
                    System.out.println("\n----------------------------\n");
                }
            }
        }
    }
}
