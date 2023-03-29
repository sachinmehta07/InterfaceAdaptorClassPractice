package com.example.interfaceadaptorclasspractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private String[] mMenuItems;

    private OnMenuItemClickListener mListener;

    public MenuAdapter(String[] menuItems, OnMenuItemClickListener listener) {
       this.mMenuItems = menuItems;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        String menuItem = mMenuItems[position];
        holder.mTextView.setText(menuItem);
        holder.itemView.setOnClickListener(view -> {
            if (mListener != null) {
                mListener.onMenuItemClick(position, menuItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMenuItems.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.menu_item_text);
        }
    }
}
