package com.example.gsonretrofitrxjava.classes;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

import com.example.gsonretrofitrxjava.Converter.ListConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "employees")
@TypeConverters(value = ListConverter.class)
public class Employee {
    @PrimaryKey(autoGenerate = true)
    int id;

    @SerializedName("f_name")
    @Expose
    private String fName;
    @SerializedName("l_name")
    @Expose
    private String lName;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("avatr_url")
    @Expose
    private String avatrUrl;


    @SerializedName("specialty")
    @Expose
    private List<Specialty> specialty = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatrUrl() {
        return avatrUrl;
    }

    public void setAvatrUrl(String avatrUrl) {
        this.avatrUrl = avatrUrl;
    }

    public List<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }

    public Employee(int id, String fName, String lName, String birthday, String avatrUrl, List<Specialty> specialty) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.avatrUrl = avatrUrl;
        this.specialty = specialty;
    }

    @Ignore
    public Employee(String fName, String lName, String birthday, String avatrUrl, List<Specialty> specialty) {
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.avatrUrl = avatrUrl;
        this.specialty = specialty;
    }
}