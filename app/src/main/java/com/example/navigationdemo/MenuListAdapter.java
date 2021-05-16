package com.example.navigationdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.NumberViewHolder>{
    private static final String TAG = ListAdapter.class.getSimpleName();
    final private MenuListAdapter.ListItemClickListener mOnClickListener;
    private static int viewHolderCount;

    private int mNumberItems;
    public interface ListItemClickListener {
        void onListItemClick(View v);
    }

    public MenuListAdapter(int numberOfItems, MenuListAdapter.ListItemClickListener listener) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
    }
    @Override
    public MenuListAdapter.NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.menu_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MenuListAdapter.NumberViewHolder viewHolder = new MenuListAdapter.NumberViewHolder(view);
        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuListAdapter.NumberViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public NumberViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }
        void bind(int listIndex) {
            //listItemNumberView.setText(String.valueOf(listIndex));
        }
        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(v);
        }
    }
}
