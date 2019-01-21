package daymos.lodz.uni.math.pl.calculator_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, "result.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table result(" +
                        "nr integer primary key autoincrement," +
                        "expression text);" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void addExpression(String expression) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("expression", expression);

        db.insertOrThrow("result", null, value);
    }

    public Cursor showAll() {
        String[] column = {"nr", "expression"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("result", column, null, null, null, null, null);
        return cursor;
    }


}