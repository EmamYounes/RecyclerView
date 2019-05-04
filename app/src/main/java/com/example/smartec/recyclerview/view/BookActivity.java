package com.example.smartec.recyclerview.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartec.recyclerview.R;
import com.example.smartec.recyclerview.adapter.DataBaseAdapter;
import com.example.smartec.recyclerview.data.DataBase;
import com.example.smartec.recyclerview.data.InterViewDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class BookActivity extends AppCompatActivity {

    android.support.v7.widget.SearchView searchView;
    TextView textViewTitle,textViewCategory,textViewResult;
    EditText editTextResult;
    ImageView imageView;
    InterViewDataBase interViewDataBase;
    RecyclerView recyclerView;
    DataBaseAdapter dataBaseAdapter;
    String question="";
    String answer="";
    String categ="java";
    String category;
    com.example.smartec.recyclerview.adapter.ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String >> listDataChild;
    List<DataBase> dataBaseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        textViewTitle=findViewById(R.id.book_title_id2);
        textViewCategory=findViewById(R.id.book_category_id2);
        textViewResult=findViewById(R.id.search_tv);
        editTextResult=findViewById(R.id.search_ed);
        imageView=findViewById(R.id.book_image_id2);
        setExtraData();
        setDataExpadleList();
        setDataBase();
        editTextResult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                editTextResult.getText().toString().toLowerCase(Locale.getDefault());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText(interViewDataBase.getSearchResult(editTextResult.getText().toString()
                .trim()));
                Toast.makeText(getApplicationContext(),
                        interViewDataBase.getSearchResult(editTextResult.getText().toString()),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void setExtraData(){
        Intent intent=getIntent();
        String title=intent.getExtras().getString("Title");
        category=intent.getExtras().getString("Category");
        int image=intent.getExtras().getInt("Image");
        textViewTitle.setText(title);
        textViewCategory.setText(category);
        imageView.setImageResource(image);

    }
    public void setDataBase(){
        interViewDataBase=new InterViewDataBase(this);
//        interViewDataBase.insertDataBase(question,answer,categ);
        recyclerView=findViewById(R.id.data_list);
        dataBaseAdapter=new DataBaseAdapter(getApplicationContext(),interViewDataBase.getAllData(category));
        dataBaseList=interViewDataBase.getAllData(category);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(dataBaseAdapter);
        Toast.makeText(getApplicationContext(),""+interViewDataBase.getDataCount(),Toast.LENGTH_LONG).show();
    }
    public void setDataExpadleList(){
        expListView = findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new com.example.smartec.recyclerview.adapter.ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }
    private void prepareListData() {
        interViewDataBase=new InterViewDataBase(this);
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        String temp;
        for (int i=0;i<interViewDataBase.getDataCount(category);i++){
            listDataHeader.add(interViewDataBase.getAllData(category).get(i).getQuestion());
            temp=interViewDataBase.getAllData(category).get(i).getAnswer();
            List<String> top250 = new ArrayList<>();
            top250.add(temp);
            listDataChild.put(listDataHeader.get(i), top250);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile, menu);

        final MenuItem myActionMenuItem = menu.findItem(R.id.search);
        searchView = (android.support.v7.widget.SearchView) myActionMenuItem.getActionView();
        changeSearchViewTextColor(searchView);
        ((EditText) searchView.findViewById(
                android.support.v7.appcompat.R.id.search_src_text)).
                setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!searchView.isIconified()) {
                    searchView.setIconified(true);
                }
                myActionMenuItem.collapseActionView();

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<String> filtermodelist = filter(listDataHeader, newText);
                listAdapter.setfilter(filtermodelist);
                return true;
            }
        });

        return true;
    }

    private List<String> filter(List<String> pl, String query) {
        query = query.toLowerCase();
        final List<String> filteredModeList = new ArrayList<>();
        for (String model : pl) {
            final String text = model.toLowerCase();
            if (text.contains(query)) {
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }

    private void changeSearchViewTextColor(View view) {
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.WHITE);
                return;
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    changeSearchViewTextColor(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
