/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmtrycatch;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack studentStack = new Stack(5);
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Chỉnh sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo điểm");
            System.out.println("5. Tìm kiếm sinh viên");
            System.out.println("6. Hiển thị danh sách sinh viên");
            System.out.println("7. Thoát");

            int choice = 0;
            boolean validChoice = false;

            while (!validChoice) {
                try {
                    System.out.print("\nChọn chức năng (1-7): ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (choice >= 1 && choice <= 7) {
                        validChoice = true;
                    } else {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại (1-7).");
                    }
                } catch (Exception e) {
                    System.out.println("Vui lòng nhập một số từ 1 đến 7.");
                    scanner.nextLine(); // Xóa input không hợp lệ
                }
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Nhập thông tin sinh viên mới:");

                        int id = 0;
                        boolean validId = false;
                        while (!validId) {
                            try {
                                System.out.print("Enter student ID: ");
                                id = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                validId = true;
                            } catch (Exception e) {
                                System.out.println("ID chỉ được nhập số. Vui lòng thử lại.");
                                scanner.nextLine(); // Xóa input không hợp lệ
                            }
                        }

                        System.out.print("Enter student full name: ");
                        String fullName = scanner.nextLine();

                        if (!fullName.matches("[a-zA-Z\\p{L} ,.']+")) {
                            System.out.println("Tên không được chứa ký tự đặc biệt. Thêm sinh viên thất bại.");
                            break;
                        }

                        System.out.print("Enter student marks (0-10): ");
                        double marks = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline

                        if (marks < 0 || marks > 10) {
                            System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10. Thêm sinh viên thất bại.");
                            break;
                        }

                        studentStack.push(new Student(id, fullName, marks));
                        System.out.println("Thêm sinh viên thành công.");
                        break;

                    case 2:
                        System.out.print("Nhập ID của sinh viên cần chỉnh sửa: ");
                        int editId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Student studentToEdit = studentStack.findById(editId);

                        if (studentToEdit != null) {
                            System.out.print("Nhập tên mới: ");
                            String newName = scanner.nextLine();
                            if (!newName.matches("[a-zA-Z\\p{L} ,.']+")) {
                                System.out.println("Tên không hợp lệ. Chỉnh sửa thất bại.");
                                break;
                            }
                            System.out.print("Nhập điểm mới (0-10): ");
                            double newMarks = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            if (newMarks < 0 || newMarks > 10) {
                                System.out.println("Điểm không hợp lệ. Chỉnh sửa thất bại.");
                                break;
                            }
                            studentToEdit.setFullName(newName);
                            studentToEdit.setMarks(newMarks);
                            System.out.println("Chỉnh sửa thông tin sinh viên thành công.");
                        } else {
                            System.out.println("Không tìm thấy sinh viên với ID: " + editId);
                        }
                        break;

                    case 3:
                        System.out.print("Nhập ID của sinh viên cần xóa: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (studentStack.deleteById(deleteId)) {
                            System.out.println("Xóa sinh viên thành công.");
                        } else {
                            System.out.println("Không tìm thấy sinh viên với ID: " + deleteId);
                        }
                        break;

                    case 4:
                        studentStack.bubbleSort();
                        System.out.println("Danh sách sau khi sắp xếp:");
                        studentStack.displayStudents();
                        break;

                    case 5:
                        System.out.print("Nhập ID của sinh viên cần tìm: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Student studentFound = studentStack.findById(searchId);
                        if (studentFound != null) {
                            System.out.println("Thông tin sinh viên:");
                            System.out.println(studentFound);
                        } else {
                            System.out.println("Không tìm thấy sinh viên với ID: " + searchId);
                        }
                        break;

                    case 6:
                        System.out.println("Danh sách sinh viên:");
                        studentStack.displayStudents();
                        break;

                    case 7:
                        isRunning = false;
                        System.out.println("Đã thoát chương trình.");
                        break;

                    default:
                        System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                scanner.nextLine(); // Xóa input không hợp lệ
            }
        }

        scanner.close();
    }
}


