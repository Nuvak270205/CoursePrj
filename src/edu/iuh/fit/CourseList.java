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
import java.util.*;
public class CourseList {

    private Course[] courses;
    private int count = 0;

    CourseList(int n) throws IllegalAccessException {
        if (n <= 0)
            throw new IllegalAccessException("");
        courses = new Course[n];
    }
    public  Course[] getCourses(){
        return courses;
    }

    public boolean addCourse(Course course){
        if (course == null)
            return false;

        if (isExists(course))
            return  false;
        //Check if array is full
        if (count == courses.length)
            return false;

        courses[count++] = course;
        return true;
    }


    private boolean isExists(Course course){
        for (int i = 0; i < count; i++){
            if (courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        }
        return false;
    }

    // Method to find the department with the most courses
    public String findDepartmentWithMostCourses() {
        if (count == 0) return null;

        Map<String, Integer> departmentCount = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }

        return departmentCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Method to find courses with the maximum credits
    public List<Course> findMaxCreditCourses() {
        if (count == 0) return new ArrayList<>();

        int maxCredit = Arrays.stream(courses, 0, count)
                .mapToInt(Course::getCredit)
                .max()
                .orElse(0);

        List<Course> maxCreditCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                maxCreditCourses.add(courses[i]);
            }
        }
        return maxCreditCourses;
    }

    // Method to remove a course
    public boolean removeCourse(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                // Shift the elements to remove the course
                System.arraycopy(courses, i + 1, courses, i, count - i - 1);
                courses[--count] = null;
                return true;
            }
        }
        System.out.println("Course ID not found: " + id);
        return false;
    }

    // Method to search for courses by title (partial match)
    public List<Course> searchCourse(String title) {
        List<Course> foundCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundCourses.add(courses[i]);
            }
        }
        return foundCourses.isEmpty() ? null : foundCourses;
    }

    // Method to search for courses by department
    public List<Course> searchCourseByDepartment(String department) {
        List<Course> foundCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                foundCourses.add(courses[i]);
            }
        }
        return foundCourses.isEmpty() ? null : foundCourses;
    }


}
