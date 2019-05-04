package com.example.smartec.recyclerview.data;

import android.support.v7.widget.GridLayoutManager;

import com.example.smartec.recyclerview.R;
import com.example.smartec.recyclerview.adapter.BookAdapter;
import com.example.smartec.recyclerview.model.Book;

import java.util.ArrayList;

/**
 * Created by Smartec on 3/13/2018.
 */

public class DataBook {

   private static ArrayList<Book> books;
   private static String category="Anthologies";
    private static String description="";
    public static ArrayList<Book> getArrayListBook(){
        books=new ArrayList<>();
        books.add(new Book("Android questions and answers","android",description, R.drawable.rsz_android));
        books.add(new Book("Java Programming","java",description,R.drawable.rsz_java));
        books.add(new Book("Brothers Beast",category,description,R.drawable.brothersbeast));
        books.add(new Book("Clock Work Orange",category,description,R.drawable.clockworkorange));
        books.add(new Book("Counting Crows",category,description,R.drawable.countingcrows));
        books.add(new Book("Dutch",category,description,R.drawable.dutch));
        books.add(new Book("Fall In Love",category,description,R.drawable.fallinlove));
        books.add(new Book("Gone",category,description,R.drawable.gone));
        books.add(new Book("Good Faith",category,description,R.drawable.goodfaith));
        books.add(new Book("Harry Potter",category,description,R.drawable.harrypotter));
        books.add(new Book("Hesse",category,description,R.drawable.hesse));
        books.add(new Book("History Of Modern",category,description,R.drawable.historyofmodern));
        books.add(new Book("La Familia",category,description,R.drawable.lafamilia));
        books.add(new Book("Tony Smith",category,description,R.drawable.tonysmith));
        books.add(new Book("To Kill A Mocking Bird",category,description,R.drawable.tokillamockingbird));
        books.add(new Book("The Face On The Milk",category,description,R.drawable.thefaceonthemilk));
        books.add(new Book("The Boy Tiger",category,description,R.drawable.theboytiger));
        books.add(new Book("Stephen King",category,description,R.drawable.stephenking));
        books.add(new Book("Somthing Nasty In The Wood",category,description,R.drawable.somthingnastyinthewood));
        books.add(new Book("Leather Maiden",category,description,R.drawable.leathermaiden));
        books.add(new Book("Nominasi",category,description,R.drawable.nominasi));
        return books;
    }

}
