package com.juanpabloprado.campcun.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.juanpabloprado.campcun.R;
import com.juanpabloprado.campcun.adapters.TodoAdapter;
import com.juanpabloprado.campcun.model.Todo;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @InjectView(R.id.recyclerView) RecyclerView mRecyclerView;
    List<Todo> mTodos = new ArrayList<>();

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
        //getTodos();
        Log.i(TAG, mTodos.size() + "");

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
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(todosUrl)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {

                @Override
                public void onFailure(Request request, IOException e) {
                    alertUserAboutError();
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mTodos = parseTodos(jsonData);
                        } else {
                            alertUserAboutError();
                        }
                    }
                    catch (IOException | JSONException e) {
                        Log.e(TAG, "Exception caught: ", e);
                    }
                }
            });
        }
    }

    private List<Todo> parseTodos(String jsonData) throws JSONException {
        JSONArray data = new JSONArray(jsonData);

        List<Todo> todos = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            JSONObject jsonTodo = data.getJSONObject(i);
            String name = jsonTodo.getString("todo");
            todos.add(new Todo(name, false));
        }
        return todos;
    }

    private void alertUserAboutError() {
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
