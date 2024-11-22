package DB_new;


import java.util.List;

public abstract class TaskList {
    public List<Task> tasks = new List<>();
    public abstract void addTask(Task task);
    public abstract void DeleteTask(Task task)
    public abstract void EditTask(Task task);


}
