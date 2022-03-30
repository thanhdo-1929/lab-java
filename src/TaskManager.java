
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class TaskManager {
    private int lastId;
    private List<Task> listTask = new ArrayList<>();
    
    public List<Task> getListTask() {
        return listTask;
    }
    
    //add task
    public void addTask(Task task){
        lastId++;
        task.setId(lastId);
        listTask.add(task);
    }
    
    //delete by id
    public boolean deleteTask(int id){
        for (int i = 0; i < listTask.size(); i++) {
            if(id==listTask.get(i).getId()){
                listTask.remove(i);
                return true;
            }
        }
        return false;
    }
}
