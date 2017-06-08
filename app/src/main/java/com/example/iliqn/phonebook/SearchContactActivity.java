package com.example.iliqn.phonebook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchContactActivity extends AppCompatActivity {

    TextView Display_Email,Display_Mobile,title_email,title_mobile;
    EditText Search_Name;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;
    TextView title_text;
    Button DeleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        Search_Name=(EditText)findViewById(R.id.search_name);
        Display_Mobile=(TextView)findViewById(R.id.display_mobile);
        Display_Email=(TextView)findViewById(R.id.display_email);
        title_email=(TextView)findViewById(R.id.title_email);
        title_mobile=(TextView)findViewById(R.id.title_mobile);
        title_text=(TextView)findViewById(R.id.textView5);
        DeleteButton=(Button)findViewById(R.id.deleteButton);
        Display_Mobile.setVisibility(View.GONE);
        Display_Email.setVisibility(View.GONE);
        title_email.setVisibility(View.GONE);
        title_mobile.setVisibility(View.GONE);
        title_text.setVisibility(View.GONE);
        DeleteButton.setVisibility(View.GONE);

    }
    public void  searchContact(View view)
    {
      search_name = Search_Name.getText().toString();
        userDbHelper= new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        Cursor cursor= userDbHelper.getContact(search_name,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String MOBILE = cursor.getString(0);
            String EMAIL = cursor.getString(1);
            Display_Mobile.setText(MOBILE);
            Display_Email.setText(EMAIL);
            Display_Mobile.setVisibility(View.VISIBLE);
            Display_Email.setVisibility(View.VISIBLE);
            title_mobile.setVisibility(View.VISIBLE);
            title_email.setVisibility(View.VISIBLE);
            title_text.setVisibility(View.VISIBLE);
            DeleteButton.setVisibility(View.VISIBLE);
        }
    }
    public void deleteContact(View view)
    {
        userDbHelper= new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Contact deleted",Toast.LENGTH_LONG).show();
    }

}
