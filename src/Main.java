/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    private static StudentManager manager = new StudentManager();
    private static StudentView view = new StudentView();

    private static void showMenu() {
        System.out.println("-----STUDENT MANEGEMENT----\n"
                + "\n"
                + "1.Create\n"
                + "2.Find and Sort\n"
                + "3.Update/delete\n"
                + "4.Report\n"
                + "5.exit.");
    }

    private static void addStu() {
       final int NUMBER_STUDENT_CREATED = 1;
        int i = 0;
        int id = view.inputId();
        Student oldStudent = manager.findStu(id);
        //while number of time small than number student created
        while (i < NUMBER_STUDENT_CREATED) {
            Student newStu = view.inputNewStu(manager.getStuList(), oldStudent);
            //check add fail
            if (!manager.createStu(newStu)) {
                System.out.println("Add fail");
                i = 0;
            } else {
                System.out.println("Add sucessfully");
            }
            //question create more
            if (i == NUMBER_STUDENT_CREATED) {
                String c = view.inputAnswer();
                if (c.equalsIgnoreCase("n")) {
                    view.displayStudent(manager.getStuList());
                    break;
                } else {
                    i = 0;
                }
            }
        }

    }

    private static void findAndSort() {
        //input keyword then find in the list and sort last thing is display
        view.displayStudent(manager.findAndSortStu(view.inputFindStu()));
    }

    private static void updateOrDelete() {
        int number = view.inputId();
        Student oldStu = manager.findStu(number);
        int id = view.inputCheckIdExist(oldStu);
        if (id != -1) {
            String answer = view.inputUpdateOrDelete();
            //check answer equal to call funtion delete
            if (answer.equalsIgnoreCase("d")) {
                manager.deleteStu(id);
                view.displayStudent(manager.getStuList());
            } else {
                int indexStu = view.getIndexStudent(id, manager.getStuList());
                manager.updateStu(view.inputUpdateStudent(id, manager.getStuList(), indexStu), indexStu);
                view.displayStudent(manager.getStuList());
            }
        } else {
            System.out.println("ID not found");
        }
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = view.inputOption();
            switch (option) {
                case 1:
                    addStu();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    updateOrDelete();
                    break;
                case 4:
                    view.displayReport(manager.report());
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
