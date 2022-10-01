package com.example.professor_allocation_thomas_mobile.service;

import com.example.professor_allocation_thomas_mobile.model.Course;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseService {

    @GET("/courses")
    Call<List<Course>> getAllCourses();
}