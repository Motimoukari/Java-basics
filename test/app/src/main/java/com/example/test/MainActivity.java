package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private List<ListItem> listItems = new ArrayList<>();
    private EditText itemEditText;

    private Button AbcButton;

    private Button DateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemEditText = findViewById(R.id.item_edit_text);

        listAdapter = new ListAdapter(listItems);
        recyclerView.setAdapter(listAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            String itemName = itemEditText.getText().toString().trim();
            if (!itemName.isEmpty()) {
                ListItem listItem = new ListItem(itemName);
                listItems.add(listItem);
                listAdapter.notifyItemInserted(listItems.size() - 1);
                itemEditText.getText().clear();
            } else {
                Toast.makeText(MainActivity.this, "Enter an item name", Toast.LENGTH_SHORT).show();
            }
        });


        Button AbcButton = findViewById(R.id.SortButtonAbc);
        AbcButton.setOnClickListener(view -> {
            sortItems(AbcButton);


        });

        Button DateButton = findViewById(R.id.SortButtonDate);
        AbcButton.setOnClickListener(view -> {
            sortByDate(DateButton);

        });
    }

    public void deleteItem(View view) {
        int position = recyclerView.getChildLayoutPosition(view);
        listItems.remove(position);
        listAdapter.notifyItemRemoved(position);
    }

    public void sortItems(View view) {
        Collections.sort(listItems, new Comparator<ListItem>() {
            @Override
            public int compare(ListItem listItem, ListItem t1) {
                return listItem.getName().compareToIgnoreCase(t1.getName());
            }
        });
        listAdapter.notifyDataSetChanged();
    }

    public void sortByDate(View view) {
        // Add code here to sort items by date

    }

    public void clearList(View view) {
        listItems.clear();
        listAdapter.notifyDataSetChanged();
    }
}
