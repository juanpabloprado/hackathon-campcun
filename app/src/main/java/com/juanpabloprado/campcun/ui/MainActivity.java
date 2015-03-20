package com.juanpabloprado.campcun.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.juanpabloprado.campcun.R;
import com.juanpabloprado.campcun.adapters.TodoAdapter;
import com.juanpabloprado.campcun.model.Todo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        List<Todo> todoCampings = new ArrayList<>();
        String[] todos = {"Casa campana", "Linterna", "Viveres", "Agua"};
        for (String todo : todos) {
            todoCampings.add(new Todo(todo, false));
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todos);
        TodoAdapter adapter = new TodoAdapter(this, todoCampings);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
    }

    @OnClick(R.id.mapButton)
    public void startMapActivity(View view) {
        Toast.makeText(this, "Map", Toast.LENGTH_LONG).show();
    }

    @OnClick (R.id.direcotoryButton)
    public void startDirectoryActivity(View view) {
        Toast.makeText(this, "Directory", Toast.LENGTH_LONG).show();
    }

    @OnClick (R.id.todoButton)
    public void startTodoActivity(View view) {
        Toast.makeText(this, "Ready?", Toast.LENGTH_LONG).show();
    }
}
