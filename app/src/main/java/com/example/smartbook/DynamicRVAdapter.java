package com.example.smartbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

class LoadingViewHolder extends RecyclerView.ViewHolder {

    public ProgressBar progressBar;

    public LoadingViewHolder(@NonNull  View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progress_bar);
    }
}

class  ItemViewHolder extends RecyclerView.ViewHolder{

    public TextView name,contenido,fechaAutor;
    public ImageView imagen;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        contenido=itemView.findViewById(R.id.details);
        fechaAutor= itemView.findViewById(R.id.fechaAutor);
        imagen= itemView.findViewById(R.id.imagen);
    }
}

public class DynamicRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int VIEW_TYPE_ITEM = 0, VIEW_TYPE_LOADING = 1;
    public static String id;
    Activity activity;
    List<DynamicRVModel> items;
    int lastVisibleItem, totalItemCount;



    public DynamicRVAdapter(RecyclerView recyclerView,Activity activity, List<DynamicRVModel> items) {
        this.activity = activity;
        this.items = items;

        final LinearLayoutManager linearLayoutManager =(LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull  RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    public DynamicRVAdapter(ArrayList<DynamicRVModel> items) {
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout,parent,false);
            return new ItemViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder){
            DynamicRVModel item = items.get(position);
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.name.setText(item.getTitulo());
            viewHolder.contenido.setText(item.getSinopsis());
            viewHolder.fechaAutor.setText(item.getAutor()+"  |  "+item.getFecha());
            viewHolder.imagen.setImageResource(item.getImagen());

           viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                MainActivity.libro= item.getTitulo();
                                Intent intent= new Intent(view.getContext(),Visualizador.class);
                                view.getContext().startActivity(intent);
                            }
                        }, 500);
                    } catch (Exception e) {
                        Log.e(TAG, "onCreateView", e);
                        throw e;
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}


