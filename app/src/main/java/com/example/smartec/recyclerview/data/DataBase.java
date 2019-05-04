package com.example.smartec.recyclerview.data;

/**
 * Created by Smartec on 3/18/2018.
 */

public class DataBase {
    public static final String TABLE_NAME = "interViewTable";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_Question = "question";
    public static final String COLUMN_Answer = "answer";
    public static final String COLUMN_Categ = "category";


    private int id;
    private String question;
    private String answer;
    private String category;

    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_Question + " TEXT,"
                    + COLUMN_Answer + " TEXT,"
                    + COLUMN_Categ + " TEXT"
                    + ")";

    public DataBase() {
    }

    public DataBase(int id, String question, String answer, String category) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

