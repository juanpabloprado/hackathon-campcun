package com.juanpabloprado.campcun.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.juanpabloprado.campcun.R;
import com.juanpabloprado.campcun.model.TodoCamping;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        List<TodoCamping> todoCampings = new ArrayList<>();
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
