package com.example.professor_allocation_thomas_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.professor_allocation_thomas_mobile.model.Professor;
import com.example.professor_allocation_thomas_mobile.service.ProfessorService;
import com.example.professor_allocation_thomas_mobile.ui.ProfessorAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorActivity extends AppCompatActivity {
    private ProfessorService professorService;
    private ListView list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        list = findViewById(R.id.listview_professor);
        professorService = RetrofitConfig.newInstance().professorService();

        professorService.getAllProfessors().enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> professors = response.body();

                for (Professor professor : professors){
                    Log.e("professor >>>>", professor.getName());
                }
                setAdapter(professors);
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<Professor> professors){
        ProfessorAdapter professorAdapter = new ProfessorAdapter(ProfessorActivity.this, professors);
        professorAdapter.setDropDownViewResource(0);
        list.setAdapter(professorAdapter);

        list.setOnItemClickListener((adapterView, view, i, l) -> {
            Professor professor = professorAdapter.getItem(i);
            Toast.makeText(ProfessorActivity.this, " Professor "
                    + professor.getName(), Toast.LENGTH_LONG).show();
        });
    }
}