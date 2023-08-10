package com.example.offline_data_base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import com.example.offline_data_base.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper;
    RecyclerView recycleView;
    ArrayList<Modelclass> list = new ArrayList<>();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHelper = new DBHelper(MainActivity.this);
        displayalldata();
        binding.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.adddata(binding.name.getText().toString(), binding.number.getText().toString());
                displayalldata();
            }
        });
        binding.displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayalldata();
            }
        });
        binding.updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.updatedata(binding.id.getText(),binding.name.getText().toString(), binding.number.getText().toString());
                displayalldata();
            }
        });
        binding.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deletedata(binding.id.getText());
                displayalldata();
            }
        });
    }
    private void displayalldata() {
        Cursor cursor = dbHelper.displaydata();
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String number = cursor.getString(2);
            Modelclass mc = new Modelclass(id,name,number);
            list.add(mc);
        }
        RecycleAdapter adapter = new RecycleAdapter(MainActivity.this,list);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView=findViewById(R.id.recycleview);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
    }

}