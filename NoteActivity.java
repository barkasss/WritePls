package com.brks.writepls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    private String NoteTitle;
    private String NoteText;
    EditText textNote;
    EditText titleNote;
    Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        saveBtn = findViewById(R.id.save_btn);
       // saveBtn.setCompoundDrawablesWithIntrinsicBounds(
        //        AppCompatResources.getDrawable(this, R.drawable.save), null, null, null); --иконочка

        titleNote = findViewById(R.id.title_note);
        textNote = findViewById(R.id.main_text_note);


        Intent intent = getIntent();
        NoteTitle = intent.getStringExtra("Title");
        NoteText = intent.getStringExtra("Text");

        titleNote.setText(NoteTitle);
        textNote.setText(NoteText);




        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(getApplicationContext(),MainActivity.class);
              //  startActivity(intent);  -- создание новой мейн активности


                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("TitleGet",titleNote.getText().toString());
                finish();
            }
        });




    }

    @Override
    protected void onStop() {


        super.onStop();
    }

    public void setNoteText(String noteText) {
        NoteText = noteText;
    }

    public void setNoteTitle(String noteTitle) {
        NoteTitle = noteTitle;
    }


    public String getNoteText() {
        return NoteText;
    }

    public String getNoteTitle() {
        return NoteTitle;
    }


}
