package com.example.notatkiappstudiamobilki;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>{

    private final Context context;
    private final List<NoteInfo> listNotes;
    private final LayoutInflater layoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        this.context = context;
        listNotes = notes;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.itemnotelist, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        NoteInfo note = listNotes.get(position);
        holder.textTitle.setText(note.getCourse().getTitle());
        holder.textContent.setText(note.getTitle());
        holder.currPos = position;
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView textTitle;
        public final TextView textContent;
        public int currPos;

        public ViewHolder(View itemView){
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_title2);
            textContent = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NoteActivity.class);
                    intent.putExtra(NoteActivity.notePos, currPos);
                    context.startActivity(intent);
                }
            });
        }
    }
}
