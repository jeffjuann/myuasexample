package com.jeffjuann.myuasexample.RecyclerView;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jeffjuann.myuasexample.R;
import com.jeffjuann.myuasexample.model.Product;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

  List<Product> list;

  public RecyclerViewAdapter(List<Product> productList) {
    this.list = productList;
  }

  @NonNull
  @Override
  public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View v = inflater.inflate(R.layout.fragment_data_item, parent, false);
    return new RecyclerViewHolder(v);
  }

  @SuppressLint("SetTextI18n")
  @Override
  public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
    Product curr = list.get(position);
    holder.nameTextView.setText(curr.name);
    holder.quantityTextView.setText(Integer.toString(curr.quantity));
  }

  @Override
  public int getItemCount() {
    return list.size();
  }
}
