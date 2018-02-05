package com.example.mesut.todolist.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mesut.todolist.R;
import com.example.mesut.todolist.core.Category;
import com.example.mesut.todolist.db.DatabaseHelper;
import com.example.mesut.todolist.util.CatListAdapter;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private DatabaseHelper dbh;
    private ArrayList<Category> cats;
    private CatListAdapter catListAdapter;
    private ListView listView;

    private static final String TAG = "CategoryActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        dbh = new DatabaseHelper(this);

        cats = dbh.getAllCategories();
        catListAdapter = new CatListAdapter(this, R.layout.layout_category_settings, cats);
        listView = (ListView) findViewById(R.id.simpleListView);
        listView.setAdapter(catListAdapter);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.add_fab :
                newCategory();
                break;
            default :
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    private void newCategory(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.category_alert, null);
        dialogBuilder.setView(dialogView);

        final EditText userInput = (EditText) dialogView.findViewById(R.id.userInputnewCat);

        /*
        Zum fuzellen des Spinners benoetigte Funktion

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.string_size_Array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        choosenTextSize.setAdapter(adapter);*/

        dialogBuilder.setTitle("Add Category");

        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String usersNewCategory = userInput.getText().toString();
                getInputValue(usersNewCategory);
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

        private void getInputValue(String usersNewCategory){
            Toast.makeText(getApplicationContext(), usersNewCategory, Toast.LENGTH_SHORT).show();
            dbh.createCategory(usersNewCategory);
        }
}