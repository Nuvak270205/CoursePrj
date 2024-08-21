/*
 * @ (#) CourseList.java   1.0 8/21/2024
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
import java.util.ArrayList;
import java.util.List;
public class CourseList {

    private int count = 0;
    private List<Course> courses;

    // Thêm một khóa học
    public boolean addCourse(Course course) {
        if (!exists(course)) {
            courses.add(course);
            count++;
            return true;
        } else {
            System.out.println("Mã khóa học đã tồn tại.");
            return false;
        }
    }

    // Kiểm tra xem khóa học đã tồn tại chưa
    private boolean exists(Course course) {
        return courses.stream().anyMatch(c -> c.getId().equals(course.getId()));
    }

    // Tìm khoa có nhiều khóa học nhất
    public String findDepartmentWithMostCourses() {
        return courses.stream().map(Course::getDepartment)
                .reduce((a, b) -> courses.stream().filter(c -> c.getDepartment().equals(a)).count() >
                        courses.stream().filter(c -> c.getDepartment().equals(b)).count() ? a : b).orElse(null);
    }

    // Tìm các khóa học có số tín chỉ lớn nhất
    public List<Course> findMaxCreditCourses() {
        int maxCredits = courses.stream().mapToInt(Course::getCredit).max().orElse(0);
        List<Course> maxCreditCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCredit() == maxCredits) {
                maxCreditCourses.add(course);
            }
        }
        return maxCreditCourses;
    }
    // Xóa một khóa học
    public boolean removeCourse(String id) {
        Course course = searchCourseById(id);
        if (course != null) {
            courses.remove(course);
            count--;
            return true;
        } else {
            System.out.println("Không tìm thấy khóa học với mã: " + id);
            return false;
        }
    }

    // Tìm kiếm khóa học theo tên (tìm tương đối)
    public List<Course> searchCourse(String title) {
        List<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundCourses.add(course);
            }
        }
        return foundCourses.isEmpty() ? null : foundCourses;
    }

    // Tìm kiếm khóa học theo khoa
    public List<Course> searchCourseByDepartment(String department) {
        List<Course> foundCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equalsIgnoreCase(department)) {
                foundCourses.add(course);
            }
        }
        return foundCourses.isEmpty() ? null : foundCourses;
    }
    // Tìm kiếm khóa học theo mã
    public Course searchCourseById(String id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    // Sắp xếp khóa học theo tên
    public List<Course> sortCourses() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        sortedCourses.sort((c1, c2) -> c1.getTitle().compareToIgnoreCase(c2.getTitle()));
        return sortedCourses;
    }
    //constructor
    // Constructor
    public CourseList(int n) {
        if (n > 0) {
            courses = new ArrayList<>(n);
        } else {
            throw new IllegalArgumentException("Số lượng khóa học phải lớn hơn 0");
        }
    }
    //property get
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }
}
