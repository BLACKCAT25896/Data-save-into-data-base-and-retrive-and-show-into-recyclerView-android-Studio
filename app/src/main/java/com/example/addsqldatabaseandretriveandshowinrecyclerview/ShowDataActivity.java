package com.example.addsqldatabaseandretriveandshowinrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {

    private DatabaseOpenHelper helper;
    private RecyclerView userrecyclerView;
    private UserAdapter adapter;
    private List<User> userList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        init();

        recyclerViewinit();


        retriveData();
    }


    private void retriveData() {
        Cursor cursor = helper.showData();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(helper.COL_AGE));
            userList.add(new User(id, name, age));
            adapter.notifyDataSetChanged();
        }


    }

    private void recyclerViewinit() {
        userrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userrecyclerView.setAdapter(adapter);
    }

    private void init() {
        helper = new DatabaseOpenHelper(this);
        userList = new ArrayList<>();
        userrecyclerView = findViewById(R.id.usersRecyclerView);
        adapter = new UserAdapter(helper,userList,this);
    }
}
