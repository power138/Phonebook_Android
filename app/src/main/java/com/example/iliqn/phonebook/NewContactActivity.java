package com.example.iliqn.phonebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewContactActivity extends AppCompatActivity {
    EditText ContactName,ContactMobile,ContactEmail;
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        ContactName =(EditText) findViewById(R.id.contact_name);
        ContactMobile =(EditText) findViewById(R.id.contact_mobile);
        ContactEmail =(EditText) findViewById(R.id.contact_email);
    }

    public void addContact(View view)
    {
    String name = ContactName.getText().toString();
    String mobile = ContactMobile.getText().toString();
    String email = ContactEmail.getText().toString();
    userDbHelper = new UserDbHelper(context);
    sqLiteDatabase=userDbHelper.getWritableDatabase();
    userDbHelper.addInformation(name,mobile,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();

    }
}
