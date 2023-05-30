public class Item
{
    private String name;
    private String description;

    public Item()
    {
        name = description = "Lorem Ipsum";
    }
    public Item(String n, String d)
    {
        name = n;
        description = d;
    }

    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return name + "\n----------------------------\n" + description;
    }
}

