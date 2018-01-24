package net.androidbootcamp.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static net.androidbootcamp.healthcareapp.R.drawable.healthcare;

/**
 * Created by Zachary on 4/15/2017.
 */

public abstract class HealthClinic extends SQLiteOpenHelper {


    private SQLiteDatabase db;
    private SQLiteOpenHelper helper;
    private String[] data;


    private static final String DATABASE_NAME="healthcare.db";
    private static final int DATABASE_VERSION=1;

    public static final String TABLE_HEALTHCARE="healthcare";
    public static final String COLUMN_ID="healthcareid";
    public static final String COLUMN_CLINIC="clinic";
    public static final String COLUMN_ADDRESS="address";
    public static final String COLUMN_CITY="city";
    public static final String COLUMN_STATE="state";
    public static final String COLUMN_ZIP_CODE="zip_code";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_DESCRIPTION="description";



    private static final String TABLE_CREATE="CREATE TABLE"+ TABLE_HEALTHCARE + "("+
            COLUMN_ID +"INTEGER PRIMARY KEY AUTOINCREMENT"+
            COLUMN_CLINIC+"TEXT"+
            COLUMN_ADDRESS+"TEXT"+
            COLUMN_CITY+"TEXT"+
            COLUMN_STATE+"TEXT"+
            COLUMN_ZIP_CODE+"INTEGER"+
            COLUMN_PHONE+"INTEGER"+
            COLUMN_DESCRIPTION+"TEXT"+")";

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public HealthClinic(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);

        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(1,'Cedars Sinai','8700 Beverly Blvd', 'Los Angeles', 'CA', '90048','1-800-233-2771')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(2,'Angeles Medical Clinic' ,'204 E Pico Blvd', 'Los Angeles', 'CA', '90015','1-213-457-4000')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(3,'Shriners Hospitals for Children','3160 Geneva St', 'Los Angeles', 'CA', '90020','1-213-388-3151')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(4,'Swedish','3400 California Ave SW', 'Seattle', 'WA', '98116','1-206-320-3399')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(5,'Polyclinic','2902 Beacon Ave S', 'Seattle', 'WA', '98144','1-206-322-1211')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(6,'Harborview','325 9th Ave', 'Seattle', 'WA', '98104','1-206-744-3000')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(7,'City MD','37 W 23rd St', 'New York', 'NY', '10010','1-646-596-9267')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(8,'Bethany Medical Clinic','222 E 31st #1r', 'New York', 'NY', '10016','1-607-353-6772')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(9,'Lenox Hill','100 E 77th St', 'New York', 'NY', '10075','1-212-434-2000')");
        db.execSQL("insert into"+ TABLE_HEALTHCARE+"("+COLUMN_ID+","+COLUMN_CLINIC+","+COLUMN_ADDRESS+","+COLUMN_CITY+","+COLUMN_STATE+","+COLUMN_ZIP_CODE+","+COLUMN_PHONE+","+COLUMN_DESCRIPTION+") values(10,'Calvary','1740 Eastchester Rd', 'New York', 'NY', '10461','1-718-518-2000')");



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_HEALTHCARE);
        onCreate(db);
    }
    public HealthClinic open() throws SQLException{
        db=helper.getWritableDatabase();
        return this;
            }
            public void close(){
                helper.close();
        }
        public void getData(){
            helper.getReadableDatabase();

    }






}





