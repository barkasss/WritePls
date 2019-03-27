package com.brks.writepls;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static java.text.DateFormat.getDateInstance;

public class NotesFragment extends Fragment implements View.OnClickListener {
    Button addBtn;



    private RecyclerView notesRecyclerView;
    private List<Note> lstNote = new ArrayList<>();
    private int position = 0;

    public NotesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //Создание первой заметки при входе
        lstNote.add(position,new Note("Моя первая заметка",
                getDateInstance().format(System.currentTimeMillis()),
                R.drawable.btn_favourite_off, "Текст заметки" ));
        position++;

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_notes, container, false);



        notesRecyclerView = v.findViewById(R.id.notes_recyclerView);
        final RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),lstNote);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        notesRecyclerView.setAdapter(recyclerAdapter);

        addBtn = v.findViewById(R.id.addBtn);





        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Создание новой заметки
                recyclerAdapter.addItem(position,new Note("Новая заметка " + position,
                        getDateInstance().format(System.currentTimeMillis()),
                        R.drawable.btn_favourite_off, "Текст заметки" ));
                //Обновление адаптера
                recyclerAdapter.notifyItemInserted(position);
                //Обновление позиции
                position++;
                System.out.println(123);
            }
        });

        return v;
    }
    @Override
    public void onClick(View v) {


    }
}