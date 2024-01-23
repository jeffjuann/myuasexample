package com.jeffjuann.myuasexample.ListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.jeffjuann.myuasexample.R;
import com.jeffjuann.myuasexample.model.Product;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

  List<Product> list;
  public ListViewAdapter(List<Product> list) {
    this.list = list;
  }
  @Override
  public int getCount() {
    return 0;
  }

  @Override
  public Product getItem(int i) {
    return list.get(i);
  }

  @Override
  public long getItemId(int i) {
    return 0;
  }

  @SuppressLint("ViewHolder")
  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    LayoutInflater inflater =  LayoutInflater.from(view.getContext());
    view = inflater.inflate(R.layout.fragment_data_item, viewGroup, false);
    TextView nameTextView = view.findViewById(R.id.nameTextView);
    nameTextView.setText(getItem(i).name);
    TextView quantityTextView = view.findViewById(R.id.quantityTextView);
    quantityTextView.setText(getItem(i).quantity);

    return view;
  }
}
