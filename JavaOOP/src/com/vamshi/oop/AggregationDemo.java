package com.vamshi.oop;

import java.util.ArrayList;
import java.util.List;

class College{
    String name;
    private List<Teacher> teacher;
    public  College(String name,List<Teacher> teacher){
        this.name=name;
        this.teacher=teacher;
    }


    public List<Teacher> getTeacher() {
        return teacher;
    }
}
class Teacher{
    String name;
    String subject;
    public Teacher(String name,String subject){
        this.name=name;
        this.subject=subject;
    }
    @Override
    public String toString(){
        return "[ Teacher : "+name+" ,Subject : "+subject+"]";
    }
}
public class AggregationDemo {
    public static void main(String[] args) {
        ArrayList<Teacher> teachers=new ArrayList<Teacher>();
        teachers.add(new Teacher("ram","java"));
        teachers.add(new Teacher("rani","python"));
        College myCollege = new College("Governmnet",teachers);


    }
}
