package com.hzdawoud.myowndagger.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.hzdawoud.myowndagger.R;
import com.hzdawoud.myowndagger.model.Ring;

import java.util.ArrayList;

public class RingsAdapter extends RecyclerView.Adapter<RingsAdapter.RingViewHolder> {
    private ArrayList<Ring> mList = new ArrayList<>();
    private Context mContext;

    public RingsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ring_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RingViewHolder holder, int position) {
        holder.bookID.setText(mList.get(position).get_id());
        holder.bookName.setText(mList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<Ring> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public Ring getRingAt(int position){
        return mList.get(position);
    }

    public class RingViewHolder extends RecyclerView.ViewHolder {
        private TextView bookID, bookName;
        public RingViewHolder(@NonNull View itemView) {
            super(itemView);
            bookID = itemView.findViewById(R.id.book_id);
            bookName = itemView.findViewById(R.id.book_name);
        }
    }
}