package com.tincio.example.projectnotes.presentation.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tincio.example.projectnotes.R;
import com.tincio.example.projectnotes.data.model.Note;
import com.tincio.example.projectnotes.data.repository.services.response.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by juan on 26/10/2016.
 */

public class ListNoteAdapter extends RecyclerView.Adapter<ListNoteAdapter.ListNoteViewHolder>{


    List<Result> list;
    private Cursor cursor;
    private ListNoteAdapterOnClickHandler handler;

    public ListNoteAdapter(List<Result> list){
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
        Result mNote = list.get(position);
        holder.txtTitle.setText(mNote.getTitle());
        holder.txtTitle.setText(mNote.getDescription());
    }

    void setCursor(Cursor cursor){
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_description)
        TextView txtDescription;

        public ListNoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            //cursor.moveToPosition(adapterPosition);
            handler.onItemClick(list.get(adapterPosition));
        }
    }

    public interface ListNoteAdapterOnClickHandler{
        void onItemClick(Result mNote);
    }

    public void onItemClickAdapter(ListNoteAdapterOnClickHandler handler){
        this.handler = handler;
    }
}
