
/**
 * Test Class to see if the LinearLis and ArrayList work with the ToDoList class to perform the taska
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public Test()
    {
        ArrayList toDoList = new ArrayList(5);
        ToDo task1 = new ToDo("task1");
        ToDo task2 = new ToDo("task2");
        ToDo task3 = new ToDo("task3");
        ToDo task4 = new ToDo("task4");
        ToDo task5 = new ToDo("task5");
        ToDo task6 = new ToDo("task6");
        toDoList.append(task1);
        toDoList.append(task2);
        toDoList.append(task3);
        toDoList.append(task4);
        toDoList.add(0,task5);
        //int size = toDoList.size();
        System.out.println(toDoList.size());
        toDoList.getList();
        System.out.println(toDoList.indexOf("task1"));
        //System.out.println(toDoList.indexOf("task5"));
        System.out.println(toDoList.indexOf(task2));
        System.out.println(toDoList.indexOf(task6));
        //System.out.println(toDoList.indexOf(task3));
        System.out.println(toDoList.indexOf(task4));
        System.out.println(toDoList.get(2));
        System.out.println(toDoList.getName(2));
        //toDoList.getName(1);
        
    }

    
}
