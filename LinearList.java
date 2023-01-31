
/**
 * Linear List is a interface that ArrayList class uses as an implementation for function.
 * This interface has all the essential basic functions for the ArrayList to implement for storing
 * manipulating thhe elements inside the ArrayList. Use of IndexOutOfBoundsExeptions only applied where
 * input of integer is required.
 *
 * @author (Dominykas Jokubauskas)
 * @version (12-11-2022)
 */
public interface LinearList
{
    public boolean isEmpty();
    public int size();
    public Object get(int index) throws IndexOutOfBoundsException;
    public int indexOf(Object element);
    public void add(int index, Object element) throws IndexOutOfBoundsException;
    public Object remove(int index)  throws IndexOutOfBoundsException;
    public String outputList();
}
