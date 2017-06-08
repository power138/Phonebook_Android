package com.example.iliqn.phonebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button AddNewContactButton,ContactListButton,SearchButton,UpdateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddNewContactButton = (Button)
                findViewById(R.id.addNewContactButton);
        ContactListButton = (Button)
                findViewById(R.id.contactListButton);
        SearchButton = (Button)
                findViewById(R.id.searchButton);
        UpdateButton=(Button)
                findViewById(R.id.updateButton);

        AddNewContactButton.setOnClickListener(onClick);
        ContactListButton.setOnClickListener(onClick);
        SearchButton.setOnClickListener(onClick);
        UpdateButton.setOnClickListener(onClick);
    }
    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.addNewContactButton)
            {
                Intent intent = new Intent(MainActivity.this,
                        NewContactActivity.class);

                startActivity(intent);
            }else if(v.getId() == R.id.contactListButton){
                Intent intent = new Intent(MainActivity.this,
                        DataListActivity.class);

                startActivity(intent);
            }else if(v.getId() == R.id.searchButton){
                Intent intent = new Intent(MainActivity.this,
                        SearchContactActivity.class);

                startActivity(intent);
            }else if(v.getId() == R.id.updateButton){
                Intent intent = new Intent(MainActivity.this,
                        UpdateContactActivity.class);

                startActivity(intent);
            }
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
