
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class TaskView {
    private DataInput in = new DataInput();

    public Task inputTask(){
        Task t = new Task();
        t.setName(inputName());
        t.setTypeID(inputTypeId());
        t.setDate(inputDate());
        t.setFrom(inputFrom());
        t.setTo(inputTo(t.getFrom()));
        t.setAssignee(inputAssign());
        t.setReviewer(inputReviewer());
        return t;
    }

    //input task name
    private String inputName() {
        System.out.print("Requirement Name: ");
        String name = in.inputString();
        return name;
    }

    //input type of task
    private int inputTypeId() {
        int id = 0;
        System.out.print("Task Type: ");
        id = in.inputInt(1, 4, "Type ID must from 1-4!");
        return id;
    }

    //input date
    private String inputDate() {
        System.out.print("Date: ");
        String date = in.inputDate();
        return date;
    }

    //input start time
    private double inputFrom() {
        double from = 0;
        System.out.print("From: ");
        from = in.inputDouble(8, 17.5, "Start time from 8h to 17h30");
        return from;
    }

    //input end time
    public double inputTo(double from) {
        double to = 0;
        System.out.print("To: ");
        to = in.inputDouble(from, 17.5, "End time from start time to 17h30");
        return to;
    }

    //input assignee
    private String inputAssign() {
        System.out.print("Assignee: ");
        String assign = in.inputString();
        return assign;
    }

    //input reviewer
    private String inputReviewer() {
        System.out.print("Reviewer: ");
        String review = in.inputString();
        return review;
    }

    //input id
    public int inputID() {
        System.out.print("ID: ");
        int id = in.inputInt(Integer.MIN_VALUE, Integer.MAX_VALUE, "ID is an integer");
        return id;
    }

    //display task
    public void display(List<Task> listT) {
        System.out.println("\n----------------------------------------- Task ---------------------------------------------");
        System.out.println("ID\tName\t\tTask Type\tDate\t\tTime\t\tAssignee\tReviewer");
        for (Task t : listT) {
            System.out.println(t);
        }
    }
}
