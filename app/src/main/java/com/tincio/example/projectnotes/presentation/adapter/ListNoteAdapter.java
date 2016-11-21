package com.tincio.example.projectnotes.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tincio.example.projectnotes.R;
import com.tincio.example.projectnotes.data.model.Note;

import java.util.List;

/**
 * Created by juan on 26/10/2016.
 */

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder> {

    List<Note> list;

    public ListNoteAdapter(List<Note> list){
        this.list = list;
    }
    @Override
    public ListNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_list_note, parent, false);
        ListNoteViewHolder viewHolder = new ListNoteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListNoteViewHolder holder, int position) {
        Note mNote = list.get(position);
        holder.txtTitle.setText(mNote.getTitle());
        holder.txtTitle.setText(mNote.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListNoteViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtDescription;

        public ListNoteViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView)itemView.findViewById(R.id.txt_title);
            txtDescription = (TextView)itemView.findViewById(R.id.txt_description);
        }
    }
}
