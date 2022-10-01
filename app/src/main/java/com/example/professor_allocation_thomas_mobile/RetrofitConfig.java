package com.example.professor_allocation_thomas_mobile;

import com.example.professor_allocation_thomas_mobile.service.AllocationService;
import com.example.professor_allocation_thomas_mobile.service.CourseService;
import com.example.professor_allocation_thomas_mobile.service.DepartmentService;
import com.example.professor_allocation_thomas_mobile.service.ProfessorService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://professor-allocation.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static RetrofitConfig newInstance() {
        return new RetrofitConfig();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public DepartmentService departmentService() { return retrofit.create(DepartmentService.class); }

    public CourseService courseService() {
        return retrofit.create(CourseService.class);
    }

    public ProfessorService professorService() { return retrofit.create(ProfessorService.class); }

    public AllocationService allocationService(){ return retrofit.create(AllocationService.class); }
}
