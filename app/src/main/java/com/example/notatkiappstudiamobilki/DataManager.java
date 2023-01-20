package com.example.notatkiappstudiamobilki;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager dmInstance = null;

    private List<NoteInfo> noteList = new ArrayList<>();

    public static DataManager getInstance() {
        if(dmInstance == null) {
            dmInstance = new DataManager();
            dmInstance.initializeNotes();
        }
        return dmInstance;
    }

    public List<NoteInfo> getNotes() {
        return noteList;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null);
        noteList.add(note);
        return noteList.size() - 1;
    }

    public void removeNote(int index) {
        noteList.remove(index);
    }

    private DataManager() {
    }

    public void initializeNotes() {
        final DataManager dm = getInstance();

        noteList.add(new NoteInfo("Dom",
                "Posprzątać chate"));
        noteList.add(new NoteInfo("Studia",
                "Mobilki trzeba machnąć"));
        noteList.add(new NoteInfo("red",
                "sus"));
        noteList.add(new NoteInfo("black",
                "sus"));
        noteList.add(new NoteInfo("Paczka",
                "Odebrać paczkie"));
    }
}
