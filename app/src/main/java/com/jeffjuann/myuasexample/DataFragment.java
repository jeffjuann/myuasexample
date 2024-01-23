package com.jeffjuann.myuasexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jeffjuann.myuasexample.RecyclerView.RecyclerViewAdapter;

public class DataFragment extends Fragment {

  RecyclerView recyclerView;
  ListView

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_data, container, false);
    recyclerView = view.findViewById(R.id.recycleView);




    DBHelper db = new DBHelper(view.getContext());
    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getProducts());
    adapter.notifyDataSetChanged();
    recyclerView.setAdapter(adapter);

    return view;
  }
}