package dev.brkic.lv1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.brkic.lv1.R;
import dev.brkic.lv1.ViewHolders.NameViewHolder;
import dev.brkic.lv1.common.NameClickListener;
import dev.brkic.lv1.models.Athlete;

public class RecyclerAdapter extends RecyclerView.Adapter<NameViewHolder>
{
    private List<Athlete> athletes = new ArrayList<Athlete>();
    private NameClickListener clickListener;

    public  RecyclerAdapter(NameClickListener listener) {this.clickListener=listener;}

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);
        return new NameViewHolder(cellView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.onBind(athletes.get(position));
    }

    @Override
    public int getItemCount() {
        return athletes.size();
    }

    public void updateRecycler(int position)
    {
        notifyItemChanged(position);
    }

    public void removeImage(int position)
    {
        Athlete athlete = athletes.get(position);
        athlete.setImageId(0);
        notifyItemChanged(position);
    }

    public void addData(List<Athlete> athletes)
    {
        this.athletes = athletes;
        notifyDataSetChanged();
    }
}
