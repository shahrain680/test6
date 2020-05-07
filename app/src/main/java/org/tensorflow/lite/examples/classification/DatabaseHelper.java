package org.tensorflow.lite.examples.classification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME= "sqllitetest";
    private static final int DB_VERSION = 2;

    public DatabaseHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlUsers = "CREATE TABLE user_admin(id INTEGER PRIMARY KEY AUTOINCREMENT, user_name VARCHAR, user_password VARCHAR);";
        String sqlObjects = "CREATE TABLE objects(id INTEGER PRIMARY KEY AUTOINCREMENT, object_material VARCHAR, user_id INTEGER, FOREIGN KEY(user_id) REFERENCES user_admin(id));";
        String sqlMaterial = "CREATE TABLE material(id INTEGER PRIMARY KEY AUTOINCREMENT, material_name VARCHAR, material_count INTEGER);";
        String sqlInformation = "CREATE TABLE information(id INTEGER PRIMARY KEY AUTOINCREMENT);";
        String sqlBin = "CREATE TABLE bin(id INTEGER PRIMARY KEY AUTOINCREMENT, bin_name VARCHAR);";
        String sqlOmb = "CREATE TABLE object_material_bin(id INTEGER PRIMARY KEY AUTOINCREMENT, object_id INTEGER, material_id INTEGER, bin_id INTEGER, info_id INTEGER, FOREIGN KEY(object_id) REFERENCES objects(id), FOREIGN KEY(material_id) REFERENCES material(id), FOREIGN KEY(bin_id) REFERENCES bin(id), FOREIGN KEY(info_id) REFERENCES information(id))";

        sqLiteDatabase.execSQL(sqlUsers);
        sqLiteDatabase.execSQL(sqlObjects);
        sqLiteDatabase.execSQL(sqlMaterial);
        sqLiteDatabase.execSQL(sqlInformation);
        sqLiteDatabase.execSQL(sqlBin);
        sqLiteDatabase.execSQL(sqlOmb);


    }

    public int getIds()
    {
        String selectQuery = "SELECT id FROM user_admin";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }

    public boolean addUsers(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlString = String.format("INSERT INTO user_admin(user_name, user_password) VALUES(\"" + username + "\",\"" + password +"\");");
        db.execSQL(sqlString);
        db.close();
        return true;
    }

    public boolean addObjects(String material) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlString = String.format("INSERT INTO objects(object_material) VALUES(\"" + material + "\");");
        db.execSQL(sqlString);
        db.close();
        return true;
    }

    public boolean addMaterial(String material) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlString = String.format("INSERT INTO material(material_name) VALUES(\"" + material + "\");");
        db.execSQL(sqlString);
        db.close();
        return true;
    }

    public boolean addBin(String bin) {
        SQLiteDatabase db = getWritableDatabase();
        String sqlString = String.format("INSERT INTO bin(bin_name) VALUES(\"" + bin + "\");");
        db.execSQL(sqlString);
        db.close();
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlUsers = "DROP TABLE IF EXISTS user_admin";
        String sqlObjects = "DROP TABLE IF EXISTS objects";
        String sqlMaterial = "DROP TABLE IF EXISTS material";
        String sqlInformation = "DROP TABLE IF EXISTS information";
        String sqlBin = "DROP TABLE IF EXISTS bin";
        String sqlOmb = "DROP TABLE IF EXISTS object_material_bin";

        sqLiteDatabase.execSQL(sqlUsers);
        sqLiteDatabase.execSQL(sqlObjects);
        sqLiteDatabase.execSQL(sqlMaterial);
        sqLiteDatabase.execSQL(sqlInformation);
        sqLiteDatabase.execSQL(sqlBin);
        sqLiteDatabase.execSQL(sqlOmb);

        onCreate(sqLiteDatabase);
    }
}
