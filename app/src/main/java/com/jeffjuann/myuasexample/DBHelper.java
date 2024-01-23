package com.jeffjuann.myuasexample;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jeffjuann.myuasexample.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

  public DBHelper(Context context) {
    super(context, "productsDatabase", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("CREATE TABLE products (id INT PRIMARY KEY, name TEXT, quantity INT);");
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE products;");
    onCreate(sqLiteDatabase);
  }

  public long insertData(Product product) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put("name", product.name);
    cv.put("quantity", product.quantity);
    return db.insert("products", null, cv);
  }

  @SuppressLint("Range")
  public List<Product> getProducts() {
    List<Product> productList = new ArrayList<>();
    SQLiteDatabase db = getReadableDatabase();
    Cursor c = db.query("products", new String[]{"name", "quantity"}, null, null, null, null, null);

    while (c.moveToNext()) {
      String name = c.getString(c.getColumnIndex("name"));
      int quantity = c.getInt(c.getColumnIndex("quantity"));
      productList.add(new Product(name, quantity));
    }

    return productList;
  }
}
