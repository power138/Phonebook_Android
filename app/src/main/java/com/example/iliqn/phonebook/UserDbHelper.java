package com.example.iliqn.phonebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by iliqn on 3/30/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1 ;
    private static final String CREATE_QUERY =
    "CREATE TABLE "+ UserContact.NewUserInfo.TABLE_NAME+"("+ UserContact.NewUserInfo.USER_NAME+" TEXT,"+
            UserContact.NewUserInfo.USER_MOBILE+" TEXT,"+ UserContact.NewUserInfo.USER_EMAIL+" TEXT);";
    public  UserDbHelper(Context context)
    {

    super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS","Database created / opened...");

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "Table created...");
    }
    public void  addInformation(String name,String mobile,String email,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContact.NewUserInfo.USER_MOBILE,mobile);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContact.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "One row is inserted...");
    }

    public Cursor getInformations(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {UserContact.NewUserInfo.USER_NAME, UserContact.NewUserInfo.USER_MOBILE,
                UserContact.NewUserInfo.USER_EMAIL};
        cursor = db.query(UserContact.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }

    public Cursor getContact(String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String[] projections= {UserContact.NewUserInfo.USER_MOBILE,UserContact.NewUserInfo.USER_EMAIL};
        String selection = UserContact.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_args = {user_name};
        Cursor cursor=sqLiteDatabase.query(UserContact.NewUserInfo.TABLE_NAME,projections,selection,selection_args,null,null,null);
        return cursor;
    }
    public void deleteInformation(String user_name,SQLiteDatabase sqLiteDatabase)
    {
        String selection = UserContact.NewUserInfo.USER_NAME+" LIKE ?";
        String[] selection_args = {user_name};
        sqLiteDatabase.delete(UserContact.NewUserInfo.TABLE_NAME,selection,selection_args);
    }
    public int updateInformation(String old_name,String new_name,String new_mobile,String new_email,SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME,new_name);
        contentValues.put(UserContact.NewUserInfo.USER_MOBILE,new_mobile);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,new_email);
        String selection = UserContact.NewUserInfo.USER_NAME + " Like ? ";
        String[] selection_arg={old_name};
        int count = sqLiteDatabase.update(UserContact.NewUserInfo.TABLE_NAME,contentValues,selection,selection_arg);
        return count;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
