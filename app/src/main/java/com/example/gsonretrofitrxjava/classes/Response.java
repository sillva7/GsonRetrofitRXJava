package com.example.gsonretrofitrxjava.classes;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("response")
    @Expose
    private  List<Employee> response = null;

    public  List<Employee> getEmployees() {
        return response;
    }

    public void setResponse(List<Employee> response) {
        this.response = response;
    }

}