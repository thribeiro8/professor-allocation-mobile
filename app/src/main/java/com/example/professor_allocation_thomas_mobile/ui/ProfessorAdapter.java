package com.example.professor_allocation_thomas_mobile.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.professor_allocation_thomas_mobile.R;
import com.example.professor_allocation_thomas_mobile.model.Professor;

import java.util.List;

public class ProfessorAdapter extends ArrayAdapter<Professor> {

    public ProfessorAdapter(@NonNull Context context, List<Professor> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.adapter_professor, parent, false);
        Professor professor = getItem(position);

        TextView text = root.findViewById(R.id.text);
        text.setText(professor.getName());

        return root;
    }
}