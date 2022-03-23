
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class StudentView {

    private DataInput dataInput = new DataInput();

    //input option
    public int inputOption() {
        int number = dataInput.inputIntVal("Enter option: ", 1, 5);
        return number;
    }

    //input id
    public int inputId() {
        int id = dataInput.inputIntVal("Enter ID: ", 1, Integer.MAX_VALUE);
        return id;
    }

    //input answer
    public String inputAnswer() {
        String answer = dataInput.inputStringVal("Do you want to continue (Y/N)", "[yYnN]");
        return answer;
    }

    //
    public String inputUpdateOrDelete(){
         String string = dataInput.inputStringVal("Enter (U/D)", "[uUdD]");
        return string;
    }
    //input check id
    public int inputCheckIdExist(Student oldStu) {
        if (oldStu == null) {
            System.out.println("ID not Found");
            return -1;
        } else {
            int id = oldStu.getId();
            return id;
        }
    }

    //get index of student
    public int getIndexStudent(int id, ArrayList<Student> stuList) {
        int oldSemester = dataInput.inputIntVal("Enter search semsester[1-9]: ", 1, 9);
        String oldCourseName;
        do {
            oldCourseName = dataInput.inputStringVal("Enter search course name: ", "[a-zA-Z./+]+");
            //check course name correct or not
            if (!oldCourseName.equalsIgnoreCase("java")
                    && !oldCourseName.equalsIgnoreCase(".net")
                    && !oldCourseName.equalsIgnoreCase("c/c++")) {
                System.out.println("Course must in [java,.net,c/c++]");
            }
        } while (!oldCourseName.equalsIgnoreCase("java")
                && !oldCourseName.equalsIgnoreCase(".net")
                && !oldCourseName.equalsIgnoreCase("c/c++"));
        for (int i = 0; i < stuList.size(); i++) {
            Student student = stuList.get(i);
            //chewck correct condition
            if (student.getId() == id
                    && student.getSemester() == oldSemester
                    && student.getCourseName().equalsIgnoreCase(oldCourseName)) {
                return i;
            }
        }
        return -1;
    }
    
    //input new student
    public Student inputNewStu(ArrayList<Student> stuList, Student oldStu){
        int id;
        String name="";
        String courseName="";
        if (oldStu!=null) {
            name=oldStu.getName();
            id=oldStu.getId();
        } else {
            id=1;
            //check student list empty
            if (!stuList.isEmpty()) {
                id=stuList.get(stuList.size()-1).getId()+1;
            }
            name=dataInput.inputStringVal("Enter name: ", "[a-zA-Z]+");
        }
        int semester=dataInput.inputIntVal("Enter semseter[1-9]", 1, 9);
        do {
            courseName=dataInput.inputStringVal("Enter course name: ","[a-zA-Z./+]+" );
            //check course name correct or not
            if (!courseName.equalsIgnoreCase("java")
                    &&!courseName.equalsIgnoreCase(".net")
                    &&!courseName.equalsIgnoreCase("c/c++")) {
                System.out.println("Course must in [java,.net,c/c++]");
            }
        } while (!courseName.equalsIgnoreCase("java")
                    &&!courseName.equalsIgnoreCase(".net")
                    &&!courseName.equalsIgnoreCase("c/c++"));
        Student newStu=new Student(id, name, semester, courseName);
        return newStu;
    }
    
    //find student
    public String inputFindStu(){
        String keyword=dataInput.inputStringVal("Enter keyword: ", "[a-zA-Z]+");
        return keyword;
    }
    
    //
    public Student inputUpdateStudent(int id, ArrayList<Student> stuList, int indexStu){
        if (indexStu!=-1) {
            String newName=dataInput.inputStringVal("Enter new name: ", "[a-zA-Z]+");
            int newSemester=dataInput.inputIntVal("Enter new semesester[1-9]", 1, 9);
            String newCourseName;
            do {                
                newCourseName=dataInput.inputStringVal("Enter new name: ", "[a-zA-Z]+");
                //check course name
                if (!newCourseName.equalsIgnoreCase("java")
                        &&!newCourseName.equalsIgnoreCase(".net")
                        &&!newCourseName.equalsIgnoreCase("c/c++")) {
                    System.out.println("Course must in [java,.net,c/c++]");
                }
            } while (!newCourseName.equalsIgnoreCase("java")
                        &&!newCourseName.equalsIgnoreCase(".net")
                        &&!newCourseName.equalsIgnoreCase("c/c++"));
            Student newStu= new Student(id, newName, newSemester, newCourseName);
            return newStu;
        }else{
            System.out.println("Student not found");
            return null;
        }
    }
    
    //display list sudent
    public void displayStudent(ArrayList<Student> stuList){
        System.out.println("List all student: ");
        for (Student student : stuList) {
            System.out.println(student.toString());
        }
        System.out.println();
    }
    
    //display list report student
    public void displayReport(ArrayList<StudentReport> reportList){
        System.out.println("List all student: ");
        for (StudentReport studentReport : reportList) {
            System.out.println(studentReport.toString());
        }
        System.out.println();
    }
}
