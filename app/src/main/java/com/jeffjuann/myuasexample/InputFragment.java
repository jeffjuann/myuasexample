package com.jeffjuann.myuasexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jeffjuann.myuasexample.model.Product;

public class InputFragment extends Fragment {

  EditText nameField, quantityField, priceField;
  Button saveBtn;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_input, container, false);

    nameField = view.findViewById(R.id.nameField);
    quantityField = view.findViewById(R.id.quantityField);
    priceField  = view.findViewById(R.id.priceField);
    saveBtn = view.findViewById(R.id.saveBtn);

    saveBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        DBHelper db = new DBHelper(view.getContext());
        String name = nameField.getText().toString();
        String quantityString = quantityField.getText().toString();
        int quantity = Integer.parseInt(quantityString);
        double price = Double.parseDouble(priceField.getText().toString());
        db.insertData(new Product(name, quantity, price));
        loadRecyclerView();
      }
    });

    return view;
  }

  private void loadRecyclerView()
  {
    getParentFragmentManager().beginTransaction()
            .replace(R.id.dataFragment, new DataFragment()).commit();
  }
}

