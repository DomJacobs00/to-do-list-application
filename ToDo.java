
/**
 * A class for a ToDo list item (task).
 *
 * @author (Dominykas Jokubauskas)
 * @version (12-11-2022)
 */
public class ToDo
{
    private String name;

    

    /**
     * Constructor for objects of class ToDo
     */
    public ToDo(String name)
    {
        this.name = name;
       
    }
    /**
     * Method that sets a name for the ToDo item
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     *  Method that returns name of a ToDo as a String
     */
    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return name;
    }
}
