package com.example.smartec.recyclerview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.smartec.recyclerview.R;
import com.example.smartec.recyclerview.adapter.BookAdapter;
import com.example.smartec.recyclerview.adapter.PostAdapter;
import com.example.smartec.recyclerview.data.DataBook;
import com.example.smartec.recyclerview.data.DataPost;
import com.example.smartec.recyclerview.data.InterViewDataBase;
import com.example.smartec.recyclerview.model.Book;
import com.example.smartec.recyclerview.model.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter postAdapter;
    BookAdapter bookAdapter;
    InterViewDataBase  dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_id);
        setBookList();
        dataBase=new InterViewDataBase(this);
    }

    public void setBookList(){

        bookAdapter=new BookAdapter(getApplicationContext(), DataBook.getArrayListBook());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(bookAdapter);
    }

    public void setPostList(){
        postAdapter=new PostAdapter(getApplicationContext(), DataPost.getArrayListPost());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);
    }
}
