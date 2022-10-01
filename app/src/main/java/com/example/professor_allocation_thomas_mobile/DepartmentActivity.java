//package com.example.professor_allocation_thomas_mobile;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.example.professor_allocation_thomas_mobile.model.dto.DepartmentDTO;
//import com.example.professor_allocation_thomas_mobile.model.Department;
//import com.example.professor_allocation_thomas_mobile.service.DepartmentService;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class DepartmentActivity extends AppCompatActivity {
//
//    private Button btnSave, btnUpdate, btnDelete;
//    private DepartmentService departmentService;
//    private ListView list;
//    private EditText departmentUpdateName, departmentUpdateId;
//    //    private CourseService courseService;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initialize();
//
//        btnSave.setOnClickListener(view -> {
//            createDepartment(departmentUpdateName.getText().toString());
//        });
//
//        btnUpdate.setOnClickListener(view -> {
//            if (departmentUpdateId.getText() != null) {
//                Long id = Long.valueOf(departmentUpdateId.getText().toString());
//                updateDepartment(id, departmentUpdateName.getText().toString());
//            } else {
//                Toast.makeText(this, "Informe um ID para atualizar", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        btnDelete.setOnClickListener(view -> {
//            if (departmentUpdateId.getText() != null) {
//                Long id = Long.valueOf(departmentUpdateId.getText().toString());
//                deleteDepartment(id);
//            } else {
//                Toast.makeText(this, "Informe um ID para excluir", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void getAllDepartments() {
//        departmentService.getAlldepartments().enqueue(
//                new Callback<List<Department>>() {
//                    @Override
//                    public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
//                        List<Department> lista = response.body();
//                        for (Department item : lista) {
//                            Log.i("DEPARTMENT >>>", item.getName());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Department>> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Falha na lista de departments!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//    }
//
//    private void createDepartment(String name) {
//        DepartmentDTO dto = new DepartmentDTO();
//
//        dto.setName(name);
//        departmentService.createDepartment(dto).enqueue(new Callback<Department>() {
//            @Override
//            public void onResponse(Call<Department> call, Response<Department> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "Department criado com sucesso", Toast.LENGTH_SHORT).show();
//                    departmentUpdateName.getText().clear();
//                    if (departmentUpdateId.getText() != null) {
//                        departmentUpdateId.getText().clear();
//                    }
//                } else {
//                    Toast.makeText(MainActivity.this, "Falha ao criar department", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Department> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Falha no request department", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void updateDepartment(Long id, String name) {
//        DepartmentDTO dto = new DepartmentDTO();
//        dto.setName(name);
//
//        departmentService.updateDepartment(id, dto).enqueue(new Callback<Department>() {
//            @Override
//            public void onResponse(Call<Department> call, Response<Department> response) {
//                Toast.makeText(MainActivity.this, "Nome Atualizado", Toast.LENGTH_SHORT).show();
//                departmentUpdateName.getText().clear();
//                departmentUpdateId.getText().clear();
//            }
//
//            @Override
//            public void onFailure(Call<Department> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Falha ao realizar request de PUT Department", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void deleteDepartment(Long id) {
//        departmentService.deleteDepartment(id).enqueue(new Callback<Department>() {
//            @Override
//            public void onResponse(Call<Department> call, Response<Department> response) {
//                Toast.makeText(MainActivity.this, "Department excluído", Toast.LENGTH_SHORT).show();
//                departmentUpdateId.getText().clear();
//            }
//
//            @Override
//            public void onFailure(Call<Department> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Falha no request Delete department", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//    private void initialize() {
////        btnSave = findViewById(R.id.save);
////        btnUpdate = findViewById(R.id.update);
////        btnDelete = findViewById(R.id.delete);
////        departmentUpdateName = findViewById(R.id.editTextUpdateName);
////        departmentUpdateId = findViewById(R.id.editDepartmentUpdateID);
////        departmentService = RetrofitConfig.newInstance().departmentService();
////        courseService = RetrofitConfig.newInstance().courseService();
//    }
//}