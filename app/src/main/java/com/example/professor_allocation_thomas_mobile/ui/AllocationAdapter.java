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
import com.example.professor_allocation_thomas_mobile.model.Allocation;

import java.util.List;


public class AllocationAdapter extends ArrayAdapter<Allocation> {

    public AllocationAdapter(@NonNull Context context, List<Allocation> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.adapter_department, parent, false);
        Allocation allocation = getItem(position);

        TextView text = root.findViewById(R.id.text);
        text.setText(allocation.getDayOfWeek());

        return root;
    }
}