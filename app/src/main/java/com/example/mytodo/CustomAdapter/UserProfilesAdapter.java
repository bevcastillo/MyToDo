package com.example.mytodo.CustomAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytodo.Objects.UserObj;
import com.example.mytodo.R;
import com.example.mytodo.ViewUserProfileActivity;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class UserProfilesAdapter extends RecyclerView.Adapter<UserProfilesAdapter.ViewHolder> {

    Context context;
    List<UserObj> list;

    public UserProfilesAdapter(Context context, List<UserObj> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_user_profile, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = list.get(viewHolder.getAdapterPosition()).getName();
                String username = list.get(viewHolder.getAdapterPosition()).getUsername();

                Intent intent = new Intent(v.getContext(), ViewUserProfileActivity.class);
                intent.putExtra("user_name", name);
                intent.putExtra("user_uname", username);
                v.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserObj data = list.get(position);

        holder.txtName.setText(data.getName());
        holder.txtUsername.setText(data.getUsername());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView userImage;
        TextView txtName, txtUsername;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = (ImageView) itemView.findViewById(R.id.imageview_user);
            txtName = (TextView) itemView.findViewById(R.id.textview_username);
            txtUsername = (TextView) itemView.findViewById(R.id.textview_userName);
            layout = (LinearLayout) itemView.findViewById(R.id.layout_profile);

        }
    }
}
