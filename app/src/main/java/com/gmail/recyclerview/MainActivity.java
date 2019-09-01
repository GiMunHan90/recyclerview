package com.gmail.recyclerview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainRecyclerAdapter adapter;
    private ArrayList<User> users = new ArrayList<>();;
    private Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0; i<20; i++){
            User user = new User();
            user.setName("한기문"+i);
            user.setPhone("010-"+i);
            users.add(user);
        }

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(manager);

        adapter = new MainRecyclerAdapter(MainActivity.this, users,recyclerView);
        recyclerView.setAdapter(adapter);

        btnInsert = findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test","success");
                User user = new User();
                user.setName("한기문"+users.size());
                user.setPhone("010-"+users.size());

                adapter.addUser(user);

                Log.d("test","유저 수 : "+users.size());
            }
        });
    }

}
