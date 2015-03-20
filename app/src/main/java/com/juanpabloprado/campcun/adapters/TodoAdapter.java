package com.juanpabloprado.campcun.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.juanpabloprado.campcun.R;
import com.juanpabloprado.campcun.model.Todo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Juan on 3/20/2015.
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>{

    private List<Todo> mTodos = new ArrayList<>();
    private Context mContext;

    public TodoAdapter(Context context, List<Todo> todos) {
        mTodos = todos;
        mContext = context;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_item, parent, false);
        TodoViewHolder viewHolder = new TodoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.bindTodo(mTodos.get(position));
    }

    @Override
    public int getItemCount() {
        return mTodos.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.todoItem) CheckBox mTodoCheckBox;

        public TodoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

        public void bindTodo(Todo todo) {
            mTodoCheckBox.setText(todo.getTodo());
            mTodoCheckBox.setChecked(todo.isDone());
        }
    }
}
