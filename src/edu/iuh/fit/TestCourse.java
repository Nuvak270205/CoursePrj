/*
 * @ (#) TestCourse.java   1.0 8/21/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package edu.iuh.fit;


/*
 * @description
 * @author: Duong Nguyen
 * @date: 8/21/2024
 * version: 1.0
 */
import java.util.List;
import java.util.Scanner;

public class TestCourse {
    public static void initData(CourseList courseList) {
        courseList.addCourse(new Course("CS101", "Nhập môn lập trình", 4, "CNTT"));
        courseList.addCourse(new Course("CS102", "Cấu trúc dữ liệu", 3, "CNTT"));
        courseList.addCourse(new Course("MT101", "Giải tích", 4, "Toán"));
        courseList.addCourse(new Course("PH101", "Vật lý đại cương", 3, "Vật lý"));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Xóa khóa học");
            System.out.println("3. Tìm kiếm khóa học theo mã");
            System.out.println("4. Tìm kiếm khóa học theo tên");
            System.out.println("5. Tìm kiếm khóa học theo khoa");
            System.out.println("6. Sắp xếp khóa học theo tên");
            System.out.println("7. Tìm khóa học có tín chỉ lớn nhất");
            System.out.println("8. Tìm khoa có nhiều khóa học nhất");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã khóa học: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên khóa học: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Nhập khoa phụ trách: ");
                    String department = scanner.nextLine();
                    Course course = new Course(id, title, credit, department);
                    courseList.addCourse(course);
                    break;
                case 2:
                    System.out.print("Nhập mã khóa học cần xóa: ");
                    String removeId = scanner.nextLine();
                    courseList.removeCourse(removeId);
                    break;
                case 3:
                    System.out.print("Nhập mã khóa học cần tìm: ");
                    String searchId = scanner.nextLine();
                    Course foundCourse = courseList.searchCourseById(searchId);
                    System.out.println(foundCourse != null ? foundCourse : "Không tìm thấy khóa học.");
                    break;
                case 4:
                    System.out.print("Nhập tên khóa học cần tìm: ");
                    String searchTitle = scanner.nextLine();
                    List<Course> foundCoursesByTitle = courseList.searchCourse(searchTitle);
                    if (foundCoursesByTitle != null) {
                        foundCoursesByTitle.forEach(System.out::println);
                    } else {
                        System.out.println("Không tìm thấy khóa học.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập tên khoa cần tìm: ");
                    String searchDepartment = scanner.nextLine();
                    List<Course> foundCoursesByDepartment = courseList.searchCourseByDepartment(searchDepartment);
                    if (foundCoursesByDepartment != null) {
                        foundCoursesByDepartment.forEach(System.out::println);
                    } else {
                        System.out.println("Không tìm thấy khóa học.");
                    }
                    break;
                case 6:
                    List<Course> sortedCourses = courseList.sortCourses();
                    sortedCourses.forEach(System.out::println);
                    break;
                case 7:
                    List<Course> maxCreditCourses = courseList.findMaxCreditCourses();
                    maxCreditCourses.forEach(System.out::println);
                    break;
                case 8:
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    System.out.println("Khoa có nhiều khóa học nhất: " + departmentWithMostCourses);
                    break;
                case 9:
                    System.out.println("Thoát chương trình...");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
