package com.example.professor_allocation_thomas_mobile.service;

import com.example.professor_allocation_thomas_mobile.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProfessorService {

    @GET("/professors")
    Call<List<Professor>> getAllProfessors();
}
