/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmtrycatch;

/**
 *
 * @author pham thanh long
 */
public class Student {
  private int id;
    private String fullName;
    private double marks;

    public Student(int id, String fullName, double marks) {
        this.id = id;
        this.fullName = fullName;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Phương thức xếp hạng sinh viên dựa trên điểm
    public String getRank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + fullName + ", Điểm: " + marks + ", Xếp hạng: " + getRank();
    }
}
