package com.jeffjuann.myuasexample.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeffjuann.myuasexample.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

  TextView nameTextView, quantityTextView, priceTextView;

  public RecyclerViewHolder(@NonNull View itemView) {
    super(itemView);

    nameTextView = itemView.findViewById(R.id.nameTextView);
    quantityTextView = itemView.findViewById(R.id.quantityTextView);
    priceTextView = itemView.findViewById(R.id.priceTextView);

  }
}
