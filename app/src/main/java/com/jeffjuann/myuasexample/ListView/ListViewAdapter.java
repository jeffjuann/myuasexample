package com.jeffjuann.myuasexample.ListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.jeffjuann.myuasexample.R;
import com.jeffjuann.myuasexample.model.Product;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

  List<Product> list;
  Context context;
  public ListViewAdapter(Context context, List<Product> list) {
    this.context = context;
    this.list = list;
  }
  @Override
  public int getCount() {
    return list.size();
  }

  @Override
  public Product getItem(int i) {
    return list.get(i);
  }

  @Override
  public long getItemId(int i) {
    return 0;
  }

  @NonNull
  @Override
  public View getView(int position, View view, ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(context);
    view = inflater.inflate(R.layout.fragment_data_item, parent, false);

    TextView nameTextView = view.findViewById(R.id.nameTextView);
    TextView quantityTextView = view.findViewById(R.id.quantityTextView);

    Product curr = getItem(position);
    quantityTextView.setText(Integer.toString(curr.quantity));

    return view;
  }
}
