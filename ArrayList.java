import java.lang.System;
import java.lang.StringBuffer;
import java.util.InputMismatchException;

/**
 * ArrayList ADT made specifically to s uit the needs of this ToDoList task 
 *
 * @author (Dominykas Jokubauskas)
 * @version (12-11-2022)
 */
public class ArrayList implements LinearList
{
    private Object[] arrayList;
    private int size;
    private int indexOf;    
    
    /**
     * Constructor for objects of class ArrayList that can be initiated with desired initial capacity
     */
    public ArrayList(int initialCapacity)
    {
        if(initialCapacity < 1)
        {
            throw new IllegalArgumentException("invalid initial capacity");
        } 
        else
        {
            ;
        }
        arrayList = new Object[initialCapacity];
        
        
        
        
    }
    /**
     * Default Constructor for capacity of 10
     */
    public ArrayList()
    {
        this(10);
    }
    /**
     * Method to check if the ArrayList is empty, if empty returns TRUE
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    /**
     * returns the size of the ArrayList
     */
    public int size()
    {
        return size;
    }
    /**
     * Checks the index in the ArrayList. If the index is out of the scope of the ArrayList produces
     * an error
     */
    public void checkIndex(int index)
    {
        try
        {
            if(index < 0 || index >= arrayList.length)
            {
                throw new IndexOutOfBoundsException("The index is out of the scope!");
            }
            else
            {
                ;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Number 0-10 required.");
        }
        
    }
    /**
     * Using checkIndex method combined with an index imput checks and returns the index for further
     * use.
     */
    public Object get(int index)
    {
        Object getter = null;
        try
        {
            checkIndex(index);
            getter = arrayList[index];
        }
        catch(InputMismatchException e)
        {
            System.out.println("Number from 0-10 is required!");
        }
        
        return getter ;         
    }
    /**
     * Method that uses the input of index returns the name field of an item
     */
    public String getName(int index)
    {
        String name = null;
        try
        {
            name = get(index).toString() ;
        }
        catch(NullPointerException e)
        {
            System.out.println("this index could not retreive a name!");

        }
        return name;
    }
    /**
     *  returns the index of an item in the ArrayList
     *  
     */
    public int indexOf(Object theElement)
    {
        
        for(int e = 0; e<size; e++)
        { 
            String listElement = get(e).toString();
            String theElementToString = theElement.toString();
            if(listElement.equals(theElementToString))
            {
                indexOf = e;
                e = size;
            }
            else
            {
                indexOf = -1;
            }
        }
        return indexOf;
    }
    /**
     * Method that adds a new object to the arrayList using the index checker to see if the index exsists
     * and is not ocupied by other element
     */
    public void add(int index, Object theElement)
    {
        try{
            checkIndex(index);
            if(size==arrayList.length)
            {
                Object[] newArray = new Object[arrayList.length*2];
                System.arraycopy(arrayList, 0, newArray, 0, arrayList.length);
                arrayList = newArray;
                
                
            }
            else
            {
               ;
            }
            if( size == 0)
            {
                arrayList[size] = theElement;
                size++;
            }
            else
            {
                for(int i = size - 1; i >= index; i--)
                {
                   arrayList[i+1] = arrayList[i];
                }
                arrayList[index] = theElement;
                size++;
                
                
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Number from 0-10 is required!");
        }
    }
    /**
     * Method that adds an item at the end of the list
     */
    public void append(Object theElement)
    {
        if(size==arrayList.length)
        {
            Object[] newArray = new Object[arrayList.length*2];
            System.arraycopy(arrayList, 0, newArray, 0, arrayList.length);
            arrayList = newArray;
            
            
        }
        else
        {
            ;
        }
        arrayList[size] = theElement;
            size++;
        
    }
    /**
     *  This method checks that the index presented is valid
     *  then the elements that have higher on the list have their indexes reduced by 1
     *  removed element is returned
     */
    public Object remove(int index)
    {
        Object removedElement = null;
        try
        {
            checkIndex(index);
            removedElement= arrayList[index];
            for (int i = index+1; i < size; i++)
            {
                arrayList[i-1] = arrayList[i];
            }
            arrayList[--size] = null;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Number from 0-10 is required!");
        }
        return removedElement;
    }
    /**
     * Method that returns the whole ArrayList as a String
     */
    public String outputList()
    {
        StringBuffer s = new StringBuffer("[");
        for (int i = 0; i < size; i++)
        {
            Object element = arrayList[i];
            if(element == null)
            {
                s.append("null, ");
            }
            else
            {
                s.append(element.toString()+", ");    
            }
        }
        return new String(s);
        
    }
    /**
     * Method that returns the whole ArrayList as a String
     */
    public void getList()
    {
        for (int i = 0; i < size; i++)
        {
            Object toDoTask = get(i);
            System.out.println(toDoTask.toString());
        }
    }
}
