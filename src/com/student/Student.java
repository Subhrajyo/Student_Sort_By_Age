package com.student;

public class Student {
     int id;
     String name;
     int age;
     public Student(int id,String name,int age) {
    	 this.id=id;
    	 this.name=name;
    	 this.age=age;
     }
     public String toString() {
    	 return "id:-"+id+"name:-"+name+"Age:-"+age;
     }
}
