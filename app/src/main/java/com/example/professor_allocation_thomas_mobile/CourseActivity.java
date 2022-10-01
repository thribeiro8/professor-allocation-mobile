package com.example.professor_allocation_thomas_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.professor_allocation_thomas_mobile.ui.CourseAdapter;
import com.example.professor_allocation_thomas_mobile.model.Course;
import com.example.professor_allocation_thomas_mobile.service.CourseService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    private CourseService courseService;
    private ListView list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        list = findViewById(R.id.listview_course);

        courseService = RetrofitConfig
                .newInstance()
                .courseService();

        courseService.getAllCourses().enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courses = response.body();

                for (Course course : courses){
                    Log.e(">>>>", course.getName());
                }
                setAdapter(courses);
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<Course> Courses) {
        CourseAdapter CourseAdapter = new CourseAdapter(CourseActivity.this, Courses);
        CourseAdapter.setDropDownViewResource(0);
        list.setAdapter(CourseAdapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {
            Course Course = CourseAdapter.getItem(i);
            Toast.makeText(CourseActivity.this, " Course "
                    + Course.getName(), Toast.LENGTH_LONG).show();
        });
    }
}