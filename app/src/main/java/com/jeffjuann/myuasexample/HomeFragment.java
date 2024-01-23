package com.jeffjuann.myuasexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jeffjuann.myuasexample.ListView.ListViewAdapter;
import com.jeffjuann.myuasexample.RecyclerView.RecyclerViewAdapter;

public class HomeFragment extends Fragment {

  Fragment inputFragment, dataFragment;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    inputFragment = new InputFragment();
    dataFragment = new DataFragment();

    FragmentManager fm = getChildFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.inputFragment, inputFragment);
    ft.replace(R.id.dataFragment, dataFragment);
    ft.commit();

    return view;
  }
}
