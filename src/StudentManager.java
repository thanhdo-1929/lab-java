
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class StudentManager {
    private ArrayList<Student> stuList=new ArrayList<>();
    
    public StudentManager(){
        stuList.add(new Student(1, "Nguyen Van A", 1, ".net"));
        stuList.add(new Student(2, "Nguyen Van A", 2, "java"));
        stuList.add(new Student(3, "Nguyen Van A", 1, ".net"));
        stuList.add(new Student(4, "Nguyen Van A", 3, "c/c++"));
    }
    
    public ArrayList<Student> getStuList(){
        return stuList;
    }
    
    //create student
    public boolean createStu(Student newStu){
        if (newStu!=null) {
            stuList.add(newStu);
            return true;
        } else {
            return false;
        }
    }
    
    //find and sort student
    public ArrayList<Student> findAndSortStu(String key){
        ArrayList<Student> findList=new ArrayList<>();
        //loop from the begin to the last of element or list
        for (Student student : stuList) {
            if (student.getName().contains(key)) {
                findList.add(student);
            }
        }
        //sort list
        Collections.sort(findList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return findList;
    }
    
    //delete student
    public void deleteStu(int id){
        for (int i = stuList.size()-1; i>=0; i--) {
            if (stuList.get(i).getId()==id) {
                stuList.remove(i);
            }
        }
    }
    
    //update student
    public void updateStu(Student newStu, int index){
        stuList.get(index).setName(newStu.getName());
        stuList.get(index).setSemester(newStu.getSemester());
        stuList.get(index).setCourseName(newStu.getCourseName());
    }
    
    //report
    public ArrayList<StudentReport> report(){
        ArrayList<StudentReport> reportList=new ArrayList<>();
        ArrayList<String> courseList=new ArrayList<>();
        courseList.add("java");
        courseList.add(".net");
        courseList.add("c/c++");
        //loop in courseList
        for (String course : courseList) {
            for (Student student : stuList) {
                //check course of student equal course in courselist or not
                if (student.getCourseName().equalsIgnoreCase(course)) {
                    //check student inlist already
                    int indexStuReport=getIndexStuInReport(reportList, student.getId(), course);
                    //if not create one
                    if (indexStuReport==-1) {
                        int totalCourse=countByIdAndCourseName(student.getId(),course);
                        reportList.add(new StudentReport(student.getId(), student.getName(), course, totalCourse));
                    }
                }
            }
        }
        return reportList;
    }
    
    //get index for student report
    public int getIndexStuInReport(ArrayList<StudentReport> reportList, int id, String courseName){
        for (int i = 0; i < reportList.size(); i++) {
            StudentReport studentReport = reportList.get(i);
            //check id and course name
            if (studentReport.getId()==id&&studentReport.getCourseName().equalsIgnoreCase(courseName)) {
                return i;
            }
        }
        return -1;
    }
    
    //
    public int countByIdAndCourseName(int id, String courseName){
        int count=0;
        for (Student student : stuList) {
            if (student.getId()==id&&student.getCourseName().equalsIgnoreCase(courseName)) {
                count++;
            }
        }
        return count;
    }
    
    //find student by id
    public Student findStu(int id){
        for (Student student : stuList) {
            if (student.getId()==id) {
                return student;
            }
        }
        return null;
    }
    
    //
}
