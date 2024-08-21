/*
 * @ (#) Course.java   1.0 8/21/2024
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
public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;

    // Constructor
    public Course() {}

    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    // Getter và Setter cho các thuộc tính
    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

}
