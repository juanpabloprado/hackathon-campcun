package com.juanpabloprado.campcun.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.juanpabloprado.campcun.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.todoButton)
    public void startMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.direcotoryButton)
    public void startDirectoryActivity(View view) {
        Intent intent = new Intent(this, DirectoryActivity.class);
        startActivity(intent);
    }
}
