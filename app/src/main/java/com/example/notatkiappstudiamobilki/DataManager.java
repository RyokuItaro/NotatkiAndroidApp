package com.example.notatkiappstudiamobilki;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager dmInstance = null;

    private List<NoteInfo> mNotes = new ArrayList<>();

    public static DataManager getInstance() {
        if(dmInstance == null) {
            dmInstance = new DataManager();
            dmInstance.initializeExampleNotes();
        }
        return dmInstance;
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null);
        mNotes.add(note);
        return mNotes.size() - 1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    private DataManager() {
    }

    public void initializeExampleNotes() {
        final DataManager dm = getInstance();

        mNotes.add(new NoteInfo("Dynamic intent resolution",
                "Wow, intents allow components to be resolved at runtime"));
        mNotes.add(new NoteInfo("Delegating intents",
                "PendingIntents are powerful; they delegate much more than just a component invocation"));

        mNotes.add(new NoteInfo("Service default threads",
                "Did you know that by default an Android Service will tie up the UI thread?"));
        mNotes.add(new NoteInfo("Long running operations",
                "Foreground Services can be tied to a notification icon"));

        mNotes.add(new NoteInfo("Parameters",
                "Leverage variable-length parameter lists"));
        mNotes.add(new NoteInfo("Anonymous classes",
                "Anonymous classes simplify implementing one-use types"));

        mNotes.add(new NoteInfo("Compiler options",
                "The -jar option isn't compatible with with the -cp option"));
        mNotes.add(new NoteInfo("Serialization",
                "Remember to include SerialVersionUID to assure version compatibility"));
    }
}
