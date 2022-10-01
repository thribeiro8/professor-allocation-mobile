package com.example.professor_allocation_thomas_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.professor_allocation_thomas_mobile.model.MenuModel;
import com.example.professor_allocation_thomas_mobile.ui.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridModule = findViewById(R.id.gridModule);

        List<MenuModel> menuChecklists = new ArrayList<>();

        menuChecklists.add(new MenuModel(R.drawable.ic_list, getString(R.string.allocation)));
        menuChecklists.add(new MenuModel(R.drawable.ic_course, getString(R.string.course)));
        menuChecklists.add(new MenuModel(R.drawable.ic_departament, getString(R.string.department)));
        menuChecklists.add(new MenuModel(R.drawable.ic_professor, getString(R.string.professor)));
        MenuAdapter MenuAdapter = new MenuAdapter(this, menuChecklists);
        gridModule.setAdapter(MenuAdapter);

        gridModule.setOnItemClickListener((adapterView, view, i, l) -> {
            switch (MenuAdapter.getItem(i).getTitle()) {
                case "Allocation":
                    startActivity(new Intent(MainActivity.this, AllocationActivity.class));
                    break;
                case "Course":
                    startActivity(new Intent(MainActivity.this, CourseActivity.class));
                    break;
                case "Department":
//                    startActivity(new Intent(MainActivity.this, DepartmentActivity.class));
                    break;
                case "Professor":
                    startActivity(new Intent(MainActivity.this, ProfessorActivity.class));
                    break;
            }
        });
    }
}