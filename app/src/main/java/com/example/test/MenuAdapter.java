package com.example.test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<Menu> items = new ArrayList<>();

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder viewHolder, int position) {

        Menu item = items.get(position);

//        url로 이미지 받는방법
//        Glide.with(viewHolder.itemView.getContext())
//                .load(item.getImage())
//                .into(viewHolder.ivMenu);

//      구현부
        viewHolder.ivMenu.setImageResource(item.getImage());
        viewHolder.tvName.setText(item.getName());
        viewHolder.tvContent.setText(item.getContent());
        viewHolder.tvType.setText(item.getType());

//        리스트를 클릭했을때 동작구현부
//        viewHolder.itemView.setTag(position);
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Menu> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMenu;
        TextView tvName, tvContent, tvType;

        ViewHolder(View itemView) {
            super(itemView);

            ivMenu = itemView.findViewById(R.id.iv_item_menu);
            tvName = itemView.findViewById(R.id.tv_item_menu_name);
            tvContent = itemView.findViewById(R.id.tv_item_menu_content);
            tvType = itemView.findViewById(R.id.tv_item_menu_type);
        }
    }

}
