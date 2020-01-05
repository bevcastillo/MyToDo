package com.example.mytodo.CustomAdapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytodo.Objects.ToDoObjList;
import com.example.mytodo.R;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {

    Context context;
    List<ToDoObjList> list;

    public ToDoListAdapter(Context context, List<ToDoObjList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_to_do_list, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ToDoObjList data = list.get(position);

        holder.toDoTitle.setText(data.getToDoTitle());
        holder.toDoCreatedAt.setText(data.getToDoCreateAt());
        holder.toDoDone.setChecked(data.isToDoDone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView toDoTitle, toDoCreatedAt;
        CheckBox toDoDone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            toDoTitle = (TextView) itemView.findViewById(R.id.textview_title);
            toDoCreatedAt = (TextView) itemView.findViewById(R.id.textview_date);
            toDoDone = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
