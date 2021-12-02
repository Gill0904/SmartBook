package com.example.smartbook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StaticRvAdapter extends  RecyclerView.Adapter<StaticRvAdapter.StaticRVViewHolder>{

    private ArrayList<StaticRvModel> items;
    int rowIndex = -1;

    public StaticRvAdapter(ArrayList<StaticRvModel> items) {
        this.items = items;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return  staticRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull StaticRvAdapter.StaticRVViewHolder holder, int position) {
        StaticRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rowIndex = position;
                notifyDataSetChanged();
                if(currentItem.getText().equals("Terror")){
                    MainActivity.agregarLibrosTerror();
                    MainActivity.actualizar();
                }else if(currentItem.getText().equals("Fantasia")){
                    MainActivity.agregarLibrosFantasia();
                    MainActivity.actualizar();
                }else if (currentItem.getText().equals("Aventura")){
                    MainActivity.agregarLibrosAventura();
                    MainActivity.actualizar();
                }else{
                    MainActivity.agregarLibrosAll();
                    MainActivity.actualizar();
                }
            }
        });
        holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rowIndex = position;
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), ""+currentItem.getText(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        if (rowIndex == position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        Context context;
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            imageView = itemView.findViewById(R.id.imagen);
            textView = itemView.findViewById(R.id.texto);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
