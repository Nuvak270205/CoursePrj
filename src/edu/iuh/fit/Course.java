/*
 * @ (#) Course.java   1.0 8/23/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package edu.iuh.fit;

/*
 * @description
 * @author: Duong Nguyen
 * @date: 8/23/2024
 * version: 1.0
 */
public class Course {

    //Attibutes
    private String id;
    private String title;
    private int credit;
    private String department;

    //Constructor
    public Course() throws IllegalAccessException {
        this("","","",0);
    }

    public Course(String department, String id, String title, int credit) throws IllegalAccessException {
        this.setDepartment(department);
        this.setId(id);
        this.setTitle(title);
        this.setCredit(credit);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalAccessException {
        if (id.trim().length() < 3) {
            throw new IllegalAccessException("ID must have at least 3 characters");
        }
        if (!id.matches("[A-Za-z0-9]+")) {
            throw new IllegalAccessException("ID must contain only letters or digits");
        }
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) throws IllegalAccessException {
        if (credit <= 0)
            throw new IllegalAccessException("Credit must be greater than 0");
        this.credit = credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.length() <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        this.department = department;
    }
    @Override
    public String toString() {
        return "Course ID: " + id + ", Title: " + title + ", Department: " + department + ", Credits: " + credit;
    }

}
