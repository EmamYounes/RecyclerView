package com.example.smartec.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartec.recyclerview.view.BookActivity;
import com.example.smartec.recyclerview.model.Book;
import com.example.smartec.recyclerview.R;

import java.util.List;

/**
 * Created by Smartec on 3/13/2018.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    Context context;
    List<Book> bookList;
    DataBaseAdapter dataBaseAdapter;
    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.book_image_id);
           textView =itemView.findViewById(R.id.book_title_id);
           cardView=itemView.findViewById(R.id.card_view_id);
           recyclerView=itemView.findViewById(R.id.data_list);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.book_layout,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(bookList.get(position).getTitle());
        holder.imageView.setImageResource(bookList.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BookActivity.class);
                intent.putExtra("Title",bookList.get(position).getTitle());
                intent.putExtra("Category",bookList.get(position).getCategory());
                intent.putExtra("Image",bookList.get(position).getImage());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return bookList.size();
    }
    
}
