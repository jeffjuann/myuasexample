# Important Code
## SQLite 
```java
public class DBHelper extends SQLiteOpenHelper
{

  public DBHelper(Context context)
  {
    super(context, "doubleDB", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase)
  {
    sqLiteDatabase.execSQL("CREATE TABLE products (id INT PRIMARY KEY, name TEXT, quantity INTEGER, price DOUBLE);");
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
  {
    sqLiteDatabase.execSQL("DROP TABLE products;");
    onCreate(sqLiteDatabase);
  }

  public long insertData(Product product)
  {
    SQLiteDatabase db = getWritableDatabase();

    ContentValues cv = new ContentValues();
    cv.put("name", product.name);
    cv.put("quantity", product.quantity);
    cv.put("price", product.price);

    return db.insert("products", null, cv);
  }

  public List<Product> getProducts()
  {
    List<Product> productList = new ArrayList<>();
    SQLiteDatabase db = getReadableDatabase();
    Cursor c = db.query("products", new String[]{"name", "quantity", "price"}, null, null, null, null, null);
    
    while (c.moveToNext()) {
      String name = c.getString(c.getColumnIndex("name"));
      int quantity = c.getInt(c.getColumnIndex("quantity"));
      double price = c.getDouble(c.getColumnIndex("price"));
      productList.add(new Product(name, quantity, price));
    }

    return productList;
  }
}
```

## Recycler View
```java
DBHelper db = new DBHelper(view.getContext());

...

recyclerView = view.findViewById(R.id.recycleView);
recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.getProducts());
adapter.notifyDataSetChanged();
recyclerView.setAdapter(adapter);

...
```

### Adapter
```java
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>
{
  List<Product> list;

  public RecyclerViewAdapter(List<Product> productList)
  {
    this.list = productList;
  }

  @Override
  public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
  {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View v = inflater.inflate(R.layout.fragment_data_item, parent, false);
    return new RecyclerViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position)
  {
    Product curr = list.get(position);
    holder.nameTextView.setText(curr.name);
    holder.quantityTextView.setText(Integer.toString(curr.quantity));
    holder.priceTextView.setText(Double.toString(curr.price));
  }

  @Override
  public int getItemCount()
  {
    return list.size();
  }
}
```
### View Holder
```java
public class RecyclerViewHolder extends RecyclerView.ViewHolder
{
  TextView nameTextView, quantityTextView, priceTextView;

  public RecyclerViewHolder(@NonNull View itemView)
  {
    super(itemView);

    nameTextView = itemView.findViewById(R.id.nameTextView);
    quantityTextView = itemView.findViewById(R.id.quantityTextView);
    priceTextView = itemView.findViewById(R.id.priceTextView);
  }
}
```

## List View
```java
DBHelper db = new DBHelper(view.getContext());

...

listView = view.findViewById(R.id.listView);
listView.setAdapter(new ListViewAdapter(view.getContext(), db.getProducts()));

...
```
### Adapter
```java
public class ListViewAdapter extends BaseAdapter
{
  List<Product> list;
  Context context;

  public ListViewAdapter(Context context, List<Product> list)
  {
    this.context = context;
    this.list = list;
  }
  @Override
  public int getCount()
  {
    return list.size();
  }

  @Override
  public Product getItem(int i)
  {
    return list.get(i);
  }

  @Override
  public long getItemId(int i)
  {
    return 0;
  }

  @Override
  public View getView(int position, View view, ViewGroup parent)
  {
    LayoutInflater inflater = LayoutInflater.from(context);
    view = inflater.inflate(R.layout.fragment_data_item, parent, false);

    Product curr = getItem(position);
    TextView nameTextView = view.findViewById(R.id.nameTextView);
    nameTextView.setText(curr.name);
    TextView quantityTextView = view.findViewById(R.id.quantityTextView);
    quantityTextView.setText(Integer.toString(curr.quantity));
    TextView priceTextView = view.findViewById(R.id.priceTextView);
    priceTextView.setText(Double.toString(curr.price));

    return view;
  }
}
```

## Fragment
```java
...

inputFragment = new InputFragment();
dataFragment = new DataFragment();

FragmentManager fm = getChildFragmentManager();
FragmentTransaction ft = fm.beginTransaction();
ft.replace(R.id.inputFragment, inputFragment);
ft.replace(R.id.dataFragment, dataFragment);
ft.commit();

...
```
### Bottom Navigation
```java
...

BottomNavigationView nav = findViewById(R.id.bottomNav);

FragmentManager fm = getSupportFragmentManager();
fm.beginTransaction().replace(R.id.mainFragment, new HomeFragment()).commit();

nav.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
{
  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item)
  {
    int id = item.getItemId();
    if (id == R.id.navigation_home)
    {
      fm.beginTransaction().replace(R.id.mainFragment, new HomeFragment()).commit();
      return true;
    } 
    else if (id == R.id.navigation_about)
    {
      fm.beginTransaction().replace(R.id.mainFragment, new AboutFragment()).commit();
      return true;
    }
    return false;
  }
});
...
```

## XML Components
### Constraint Layout
```xml
<androidx.constraintlayout.widget.ConstraintLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  android:id="@+id/container"
  android:layout_width="match_parent"
  android:layout_height="match_parent">

  ...

</androidx.constraintlayout.widget.ConstraintLayout>
```
### Recycle View
```xml
<androidx.recyclerview.widget.RecyclerView
  android:id="@+id/recycleView"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
/>
```
### Bottom Navigation
```xml
<com.google.android.material.bottomnavigation.BottomNavigationView
  android:id="@+id/bottomNav"
  android:layout_width="0dp"
  android:layout_height="wrap_content"
  android:layout_marginStart="0dp"
  android:layout_marginEnd="0dp"
  android:background="?android:attr/windowBackground"
  app:layout_constraintBottom_toBottomOf="parent"
  app:layout_constraintLeft_toLeftOf="parent"
  app:layout_constraintRight_toRightOf="parent"
  app:menu="@menu/bottom_nav_menu"
/>
```
