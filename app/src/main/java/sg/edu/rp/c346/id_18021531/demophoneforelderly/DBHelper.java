package sg.edu.rp.c346.id_18021531. demophoneforelderly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_Contacts = "contacts";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_name = "name";
    private static final String COLUMN_number = "number";
    private static final String COLUMN_relationship = "relationship";
    private static final String COLUMN_Son = "son";
    private static final String COLUMN_Daughter = "daughter";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_Contacts +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_name + " TEXT," + COLUMN_number + " INTEGER,"
                + COLUMN_relationship + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Contacts);
        // Create table(s) again
        onCreate(db);

    }
    public void insertContact(String name,int number,String relationship){

        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        // We use ContentValues object to store the values for
        //  the db operation
        ContentValues values = new ContentValues();
        // Store the column name as key and the description as value
        values.put(COLUMN_name,name);
        values.put(COLUMN_number,number);
        values.put(COLUMN_relationship,relationship);
        // Store the column name as key and the date as value
        // Insert the row into the TABLE_TASK
        db.insert(TABLE_Contacts, null, values);
        // Close the database connection
        db.close();
    }
    public ArrayList<Integer> getSonNumber() {
        // Create an ArrayList that holds String objects
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String selectQuery = "SELECT " + COLUMN_number
                + " FROM " + TABLE_Contacts +  "WHERE"  +
                COLUMN_relationship + "equals" + COLUMN_Son ;
        // Get the instance of database to read'
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                numbers.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return numbers;
    }

    public ArrayList<Integer> getDaughterNumber() {
        // Create an ArrayList that holds String objects
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String selectQuery = "SELECT " + COLUMN_number
                + " FROM " + TABLE_Contacts +  "WHERE"  +
                COLUMN_relationship + "equals" + COLUMN_Daughter ;
        // Get the instance of database to read'
        SQLiteDatabase db = this.getReadableDatabase();
        // Run the SQL query and get back the Cursor object
        Cursor cursor = db.rawQuery(selectQuery, null);

        // moveToFirst() moves to first row, null if no records
        if (cursor.moveToFirst()) {
            // Loop while moveToNext() points to next row
            //  and returns true; moveToNext() returns false
            //  when no more next row to move to
            do {
                // Add the task content to the ArrayList object
                //  getString(0) retrieves first column data
                //  getString(1) return second column data
                //  getInt(0) if data is an integer value
                numbers.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return numbers;
    }
}
