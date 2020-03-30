package edu.sharif.yousefi.first_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private CardContent[] dataset;

    public CardAdapter(CardContent[] dataset) {
        this.dataset = dataset;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        ViewHolder(CardView c) {
            super(c);
            cardView = c;
        }
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView view = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder viewHolder, int i) {
        CardView cardView = viewHolder.cardView;
        TextView name = cardView.findViewById(R.id.name_card);
        name.setText(dataset[i].getName());
        TextView explain = cardView.findViewById(R.id.explain_card);
        explain.setText(dataset[i].getExplain());
        ImageView image = cardView.findViewById(R.id.image_card);
        image.setImageResource(dataset[i].getImage());

    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
