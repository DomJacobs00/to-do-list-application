import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This is the App class of the ToDoList, essentially what a user would interact with to add, remove,
 * calculate as well as find the tasks by name, or see if one exsists.
 * The application has been made possible using Scanner object that takes in the input of the user
 * 
 * @author (Dominykas Jokubauskas)
 * @version (12-11-2022)
 */
public class ToDoListApp extends ArrayList
{
    Scanner intScanner = new Scanner(System.in);
    Scanner stringScanner = new Scanner(System.in);
    private int pageSelector;
    private String taskName;
    private int taskIndex;
    ArrayList toDoList = new ArrayList(5);
    boolean isEmpty = false;
    
    public static void main(String[] args)
    {
        ToDoListApp App;
        App = new ToDoListApp();
        App.homeScreen();
    }
    /**
     * The main application screen that takes users input and redirects to other methods
     */
    public void homeScreen()
    {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Welcome to your ToDo list application.");
        System.out.println("Select one option to move forward:");
        System.out.println("Check your tasks:               1");
        System.out.println("Add a task to your list:        2");
        System.out.println("Remove a task from the list:    3");
        System.out.println("Find the task by name:          4");
        System.out.println("Check if the task exists:       5");
        System.out.println("Exit the application           10");
        System.out.println("\n------------------------------------------------------------------\n");
        
        try
        {
            pageSelector = intScanner.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Please enter a number 1-5");
            intScanner.next();
            homeScreen();
        }
        if(pageSelector == 1)
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("You Have Selected to Check all of your exsisting tasks:");
            System.out.println("\n------------------------------------------------------------------\n");
            checkTasks();
            
        }
        else if(pageSelector== 2)
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("You Have Selected to Add a task to your list");
            System.out.println("Please enter the name for the task:");
            System.out.println("\n------------------------------------------------------------------\n");
            taskName = stringScanner.nextLine();
            addTask(taskName);
        }
        else if(pageSelector == 3)
        {
            isEmpty = toDoList.isEmpty();
            if(isEmpty == true)
            {
                checkTasks();
            }
            else
            {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You Have Selected to remove a task from the list ");
                System.out.println("Please enter the position of the task you desire to remove: ");
                System.out.println("\n------------------------------------------------------------------\n");
                try{
                    taskIndex = intScanner.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Please enter a number!");
                    homeScreen();
                }
                removeTask(taskIndex);
            }  
        }
        else if(pageSelector == 4)
        {
            isEmpty = toDoList.isEmpty();
            if(isEmpty==true)
            {
                checkTasks();
            }
            else
            {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You Have Selected to find the task by name");
                System.out.println("Pleasse enter the name of the task: ");
                System.out.println("\n------------------------------------------------------------------\n");
                taskName = stringScanner.nextLine();
                findTask(taskName);
            }
        }
        else if(pageSelector == 5)
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("You Have Selected to check if the task exists");
            System.out.println("Please enter the name of the task:");
            System.out.println("\n------------------------------------------------------------------\n");
            taskName = stringScanner.nextLine();
            ifExists(taskName);
        }
        else if(pageSelector == 10)
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Please enter a number 1-5 to use the application or 10 to exit");
            homeScreen();
        }
    }
    /**
     * Method that uses ArrayList method isEmpty() that returns a boolean witch is checked in this method.
     */
    public void checkTasks()
    {
        isEmpty = toDoList.isEmpty();
        if(isEmpty == true)
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("Your List is empty");
            System.out.println("\n------------------------------------------------------------------\n");
            isEmpty = false;
            homeScreen();
        }
        else
        {
            toDoList.getList();
            homeScreen();
        }
    }
    /**
     * Method that uses the ArrayList append() method to add a task at the end of the list 
     * by taking an input of a name for the task.
     */
    public void addTask(String name)
    {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("the name for the task is: "+ name);
        System.out.println("Task named: " + name + " has been created.");
        System.out.println("\n------------------------------------------------------------------\n");
        ToDo task = new ToDo(name);
        toDoList.append(task);
        homeScreen();
    }
    /**
     * Method that uses the ArrayList remove() method that initially checks if the index input from a user actually exists
     * in the ArayList scope. If if does then it attempts to remove the item.
     */
    public void removeTask(int index)
    {
        try
        {
            checkIndex(index);
            System.out.println("\n------------------------------------------------------------------\n");
            toDoList.remove(index);
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("task has been removed..");
            homeScreen();
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("No task has been found!");
            homeScreen();
        }
    }
    /**
     * Method that shows the possition of the task in the list.
     */
    public void findTask(String name)
    {
        int location = toDoList.indexOf(name);
        int printLocation = location +1;
        if(location < 0)
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("The task is not in the list");
            System.out.println("\n------------------------------------------------------------------\n");
        }
        else
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("The task number is:  " + printLocation);
            System.out.println("\n------------------------------------------------------------------\n");
        }
        homeScreen();
    }
    /**
     * Method that checks if the task exists in the list.
     */
    public void ifExists(String name)
    {
        int location = toDoList.indexOf(name);
        
        if(location < 0)
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("The task does not exist on the list");
            System.out.println("\n------------------------------------------------------------------\n");
        }
        else
        {
            System.out.println("\n------------------------------------------------------------------\n");
            System.out.println("The task exists on the list");
            System.out.println("\n------------------------------------------------------------------\n");
        }
        homeScreen();
    }
    /**
     * Method that has the initial check for the item in the list if that index is occupied or if it exists.
     */
    public void checkIndex(int index)
    {
       int size = toDoList.size();
        
        if(index< 0 || index>= size)
        {
            throw new IndexOutOfBoundsException();
            
        }
        else
        {
            ;
        }
        
    }
}
