package dev.brkic.lv1.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.brkic.lv1.R;
import dev.brkic.lv1.common.NameClickListener;
import dev.brkic.lv1.models.Athlete;

public class NameViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener
{

    private TextView nameTextView;
    private ImageView athleteImageView;
    private NameClickListener clickListener;
    private TextView bornDiedTextView;
    private TextView descriptionTextView;

    public NameViewHolder(@NonNull View itemView, NameClickListener listener) {
        super(itemView);
        this.clickListener = listener;
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        bornDiedTextView = itemView.findViewById(R.id.bornDiedTextView);
        athleteImageView = itemView.findViewById(R.id.athleteImageView);
    }

    public void onBind(Athlete athlete)
    {
        nameTextView.setText(athlete.getName());
        descriptionTextView.setText(athlete.getDescription());
        bornDiedTextView.setText(athlete.getBornDiedDate());
        athleteImageView.setImageResource(athlete.getImageId());
        athleteImageView.setOnClickListener(this);
    {

    };
    }


    @Override
    public void onClick(View view)
    {
        clickListener.onNameClick(getAdapterPosition());
    }
}
