package com.example.smartec.recyclerview.data;

import android.support.v7.widget.LinearLayoutManager;

import com.example.smartec.recyclerview.adapter.PostAdapter;
import com.example.smartec.recyclerview.model.Post;

import java.util.ArrayList;

/**
 * Created by Smartec on 3/13/2018.
 */

public class DataPost {

    private static ArrayList<Post> posts;
    public static ArrayList<Post> getArrayListPost(){
        posts=new ArrayList<>();
        posts.add(new Post("head1","title1"));
        posts.add(new Post("head2","title2"));
        posts.add(new Post("head3","title3"));
        posts.add(new Post("head4","title4"));
        return posts;
    }
}
