package com.example.zhangc.recyclerviewmine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by zhangc on 18/4/11.
 */

public class recyclerview extends RecyclerView.Adapter<recyclerview.MyViewHolder> {
    private List<Integer> listint;
    private Context context;

    public recyclerview (List<Integer> listint, Context context){
         this.listint = listint;
         this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.recyclerviewmine,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.iv.setImageResource(listint.get(position));
    }

    @Override
    public int getItemCount() {
        return listint.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
