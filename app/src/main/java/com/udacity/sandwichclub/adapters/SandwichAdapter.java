package com.udacity.sandwichclub.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.udacity.sandwichclub.DetailActivity;
import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class SandwichAdapter extends RecyclerView.Adapter<SandwichAdapter.ListViewHolder> {

    private Context mContext;
    private String[] mSandwichList;
    private static String TAG = "SandwicthAdapter";

    public SandwichAdapter(Context context, String[] sandwichList) {
        mContext = context;
        mSandwichList = sandwichList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.sandwich_list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.textView.setText(mSandwichList[position]);
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return mSandwichList.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        private int mPosition;

        public ListViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.sandwichName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_POSITION, mPosition);
            mContext.startActivity(intent);
        }

        public void setPosition(int position) {
            mPosition = position;
        }
    }
}
