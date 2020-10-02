package com.example.gsonretrofitrxjava.screens;

import com.example.gsonretrofitrxjava.classes.Employee;

import java.util.List;

public interface EmployeeListView {

    void showData(List<Employee> employees);
    void showError(Throwable throwable);


}
