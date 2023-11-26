package com.iweb.test1;

/**
 * @author wmn
 * @date 2023/11/25 9:15
 */
public class Student implements Person{
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void eat() {
        System.out.println("学生吃穷鬼套餐");
    }
}
