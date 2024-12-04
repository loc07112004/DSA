/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmtrycatch;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author pham thanh long
 */
public class Stack {
 private ArrayList<Student> students;
    private int maxSize;

    public Stack(int maxSize) {
        this.students = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public void push(Student student) {
        if (students.size() < maxSize) {
            students.add(student);
        } else {
            System.out.println("Stack đầy. Không thể thêm sinh viên.");
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Trả về null nếu không tìm thấy sinh viên có ID đã nhập
    }

    public boolean deleteById(int id) {
        Student student = findById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
