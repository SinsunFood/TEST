package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private ArrayList<Menu> items = new ArrayList<>();
    public Menu sellectedItem;
    private int mclickCount = 0;
    public interface OnItemClickListener {
        void onItemClick(View v, int position, Menu item,int mclickCount) ;
    }
    private OnItemClickListener mListener = null ;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

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
        Glide.with(viewHolder.itemView.getContext())
                .load(item.getImage())
                .into(viewHolder.ivMenu);
//      구현부

        viewHolder.tvName.setText(item.getMenuName());
        viewHolder.tvContent.setText(String.valueOf(item.getPrice()));
        viewHolder.tvType.setText(String.valueOf(item.getGrams()));


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
        Button click_btn;
        TextView tv_test;
        int mtest = 0;

        ViewHolder(View itemView) {
            super(itemView);

            ivMenu = itemView.findViewById(R.id.iv_item_menu);
            tvName = itemView.findViewById(R.id.tv_item_menu_name);
            tvContent = itemView.findViewById(R.id.tv_item_menu_content);
            tvType = itemView.findViewById(R.id.tv_item_menu_type);

            click_btn = itemView.findViewById(R.id.click_Btn);

            click_btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        if(mListener != null)
                        {
                            sellectedItem = items.get(pos);
                            mListener.onItemClick(v,pos,sellectedItem,mclickCount);

                        }
                    }

                }
            });
        }
    }

}
