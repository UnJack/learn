package org.learn.tech.design.composite_pattern;

import lombok.Data;

import java.util.List;

/**
 * User: jimjian
 * Date: 16-3-23 下午4:49
 * 组合模式
 */
@Data
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary, List<Employee> subordinates) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = subordinates;
    }
}
