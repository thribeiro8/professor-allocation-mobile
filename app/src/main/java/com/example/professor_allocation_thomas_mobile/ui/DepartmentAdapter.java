package com.example.professor_allocation_thomas_mobile.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.professor_allocation_thomas_mobile.R;
import com.example.professor_allocation_thomas_mobile.model.Department;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class DepartmentAdapter extends ArrayAdapter<Department> {

    public DepartmentAdapter(@NonNull Context context, List<Department> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.adapter_department, parent, false);
        Department departament = getItem(position);

        TextView text = root.findViewById(R.id.text);
        text.setText(departament.getName());

        return root;
    }
}
