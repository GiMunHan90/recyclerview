package com.gmail.recyclerview;


import android.content.Context;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainRecyclerAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<User> users;

    public MainRecyclerAdapter(Context context, ArrayList<User> us) {
        this.context = context;
        this.users = us;
    }

    public void addUser(User user){
        //notifyDataSetChanged();
        users.add(user);
        notifyItemInserted(users.indexOf(user));
    }

    public void deleteUser(User user){
        notifyItemRemoved(users.indexOf(user));
        users.remove(user);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder mHolder = (ViewHolder) viewHolder;
        mHolder.name.setText(users.get(position).getName());
        mHolder.phone.setText(users.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return users.size();
    } //제일 먼저 불림, 도장을 몇개 찍을래


    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView phone;

        public ViewHolder(final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);

            itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View view) {
                    //Toast.makeText(context,"testing",Toast.LENGTH_LONG).show();
                    final Snackbar snackbar = Snackbar.make(view, "지울게!", Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("응!", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            deleteUser(users.get(getLayoutPosition()));
                            snackbar.dismiss();
                        }
                    });
                    snackbar.show();
                    return false;
                }
            });
        }

    }

}