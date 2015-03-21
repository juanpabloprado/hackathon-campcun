package com.juanpabloprado.campcun.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
        String[] todos =
                {"Casa campana", "Linterna", "Repelente de insectos", "Kit de primeros auxilios", "Agua", "Cocina (Cubiertos/Cacerolas)"};
        for (String todo : todos) {
            todoCampings.add(new Todo(todo, false));
        }

        TodoAdapter adapter = new TodoAdapter(this, todoCampings);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);
    }

    private void getTodos() {
        String apiKey = "2Q3xsKtpHe";
        String todosUrl = "http://tu-desarrollo.com/apps/camp-cun-api/todos/json?apiKey=" + apiKey;
        if (isNetworkAvailable()) {

        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }

        return isAvailable;
    }

    @OnClick(R.id.mapButton)
    public void startMapActivity(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.direcotoryButton)
    public void startDirectoryActivity(View view) {
        Intent intent = new Intent(this, DirectoryActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.todoButton)
    public void startTodoActivity(View view) {
        Toast.makeText(this, "Ready?", Toast.LENGTH_LONG).show();
    }
}
