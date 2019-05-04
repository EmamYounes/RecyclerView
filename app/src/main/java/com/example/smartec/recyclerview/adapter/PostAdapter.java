package com.example.smartec.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartec.recyclerview.model.Post;
import com.example.smartec.recyclerview.R;

import java.util.List;

/**
 * Created by Smartec on 3/13/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    Context context;
    List<Post> arrayPost;

    public PostAdapter(Context context, List<Post> arrayPost) {
        this.context = context;
        this.arrayPost = arrayPost;
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {

        TextView header;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            header=itemView.findViewById(R.id.header);
            title=itemView.findViewById(R.id.title);
        }
    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.post_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, int position) {

        Post post=new Post();
        post=arrayPost.get(position);
        holder.header.setText(post.getHeader());
        holder.title.setText(post.getTitle());

    }
    @Override
    public int getItemCount() {
        return arrayPost.size();
    }
}
