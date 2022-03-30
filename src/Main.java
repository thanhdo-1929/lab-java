
import java.util.ArrayList;


/**
 *
 * @author trinh
 */
public class Main {
    public static void main(String[] args) {
        DataInput in = new DataInput();
        TaskView view = new TaskView();
        TaskManagement manager = new TaskManagement();
        while(true){
            System.out.println("======== Task Program ========");
            System.out.println("1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. Display task");
            System.out.println("4. Exit");
            System.out.print("Input your choice: ");
            int choice = in.inputInt(1, 4, "Choice must from 1-4!");
            switch(choice){
                case 1:
                    System.out.println("\n------------ Add Task ---------------");
                    manager.addTask(view.inputTask());
                    System.out.println("Add success!\n");
                    break;
                case 2:
                    System.out.println("\n-------------- Del Task -----------------");
                    if(manager.getListTask().isEmpty()){
                        System.out.println("List of task is empty!\n");
                        break;
                    }
                    int idDelete = view.inputID();
                    if(manager.delete(idDelete)){
                        System.out.println("Delete successful!\n");
                    }else{
                        System.out.println("Delete fail!\n");
                    }
                    break;
                case 3:
                    view.display(manager.getListTask());
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
        
    }
}
