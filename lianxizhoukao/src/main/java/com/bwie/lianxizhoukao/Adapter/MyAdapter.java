package com.bwie.lianxizhoukao.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.lianxizhoukao.R;
import com.bwie.lianxizhoukao.utils.Bean;
import com.bwie.lianxizhoukao.utils.User;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/2.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    public List<User> list;

    public MyAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.tv.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpl)
        SimpleDraweeView simpl;
        @BindView(R.id.tv)
        TextView tv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
