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

import java.util.List;

public class TestCourse {
    public static void main(String[] args) throws IllegalAccessException {

        // Khởi tạo danh sách khóa học với dung lượng tối đa
        CourseList courseList = new CourseList(10);

        // Tạo và thêm các khóa học vào danh sách
        Course c1 = new Course("CS", "CS101", "Java Programming", 3);
        Course c2 = new Course("SE", "SE201", "Database Programming", 3);
        Course c3 = new Course("MA101", "Programming", "MA", 4);
        Course c4 = new Course("CS102", "Java", "CS", 3);

        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);

        // Hiển thị tất cả các khóa học
        System.out.println("Tất cả các khóa học:");
        for (Course c : courseList.getCourses()) {
            if (c != null) {
                System.out.println(c);
            }
        }

        // Kiểm tra tìm kiếm theo khoa
        String department = "CS";
        System.out.println("\nCác khóa học thuộc khoa " + department + ":");
        List<Course> csCourses = courseList.searchCourseByDepartment(department);
        if (csCourses != null) {
            for (Course c : csCourses) {
                System.out.println(c);
            }
        } else {
            System.out.println("Không tìm thấy khóa học nào.");
        }

        // Kiểm tra tìm kiếm theo tiêu đề
        String title = "Lập trình";
        System.out.println("\nCác khóa học có tiêu đề chứa '" + title + "':");
        List<Course> foundCourses = courseList.searchCourse(title);
        if (foundCourses != null) {
            for (Course c : foundCourses) {
                System.out.println(c);
            }
        } else {
            System.out.println("Không tìm thấy khóa học nào.");
        }

        // Kiểm tra tìm khoa có nhiều khóa học nhất
        System.out.println("\nKhoa có số lượng khóa học nhiều nhất:");
        String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
        if (departmentWithMostCourses != null) {
            System.out.println(departmentWithMostCourses);
        } else {
            System.out.println("Danh sách khóa học trống.");
        }

        // Kiểm tra tìm các khóa học có số tín chỉ cao nhất
        System.out.println("\nCác khóa học có số tín chỉ cao nhất:");
        List<Course> maxCreditCourses = courseList.findMaxCreditCourses();
        if (maxCreditCourses != null) {
            for (Course c : maxCreditCourses) {
                System.out.println(c);
            }
        } else {
            System.out.println("Danh sách khóa học trống.");
        }

        // Kiểm tra xóa khóa học
        System.out.println("\nXóa khóa học CS101...");
        boolean removed = courseList.removeCourse("CS101");
        if (removed) {
            System.out.println("Khóa học CS101 đã được xóa.");
        } else {
            System.out.println("Không thể xóa khóa học CS101.");
        }

        // Hiển thị tất cả các khóa học sau khi xóa
        System.out.println("\nTất cả các khóa học sau khi xóa:");
        for (Course c : courseList.getCourses()) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }
}
