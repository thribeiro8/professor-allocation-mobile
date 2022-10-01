package com.example.professor_allocation_thomas_mobile.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.professor_allocation_thomas_mobile.R;
import com.example.professor_allocation_thomas_mobile.model.MenuModel;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuModel> {

    public MenuAdapter(@NonNull Context context, List<MenuModel> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.adapter_menu, parent, false);
        MenuModel menuChecklist = getItem(position);

        ImageView image = root.findViewById(R.id.image);
        image.setImageResource(menuChecklist.getDrawable());

        TextView text = root.findViewById(R.id.text);
        text.setText(menuChecklist.getTitle());

        return root;
    }
}