package com.dsa157.ruok.model;

import com.dsa157.ruok.database.RuokSqliteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Recipient extends RuokSqliteOpenHelper {
	
	private String _name = "";
	private String _phone = "";
	private String _relationship = "";

    private static final String TABLE_NAME = "recipient";
	protected static final String COLUMN_ID = "recipientID";

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_RELATIONSHIP = "relationship";
    private static final String TABLE_CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " integer primary key autoincrement, " + 
                COLUMN_NAME + " text, " + 
                COLUMN_PHONE + " text, " + 
                COLUMN_RELATIONSHIP + " text " + 
                ");";

    private static final String TABLE_INSERT =
            "insert into " + TABLE_NAME + " (" +
            COLUMN_NAME + ", " + 
            COLUMN_PHONE + ", " + 
            COLUMN_RELATIONSHIP + ") values (%s,%s,%s);"; 
   
    private static final String TABLE_UPDATE =
            "update " + TABLE_NAME + " set " +
            COLUMN_NAME + "=%s," + 
            COLUMN_PHONE + "=%s" + 
            COLUMN_RELATIONSHIP + "=%s where " +
            COLUMN_NAME + "=%s;"; 

    Recipient(Context context) {
        super(context, RuokDatabase.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      Log.w(Recipient.class.getName(),
          "Upgrading " + TABLE_NAME + " from version " + oldVersion + " to "
              + newVersion + ", which will destroy all old data");
      db.execSQL(TABLE_DROP);
      onCreate(db);
    }
	/**
	 * @return the _name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @param _name the _name to set
	 */
	public void setName(String _name) {
		this._name = _name;
	}

	/**
	 * @return the _phone
	 */
	public String getPhone() {
		return _phone;
	}

	/**
	 * @param _phone the _phone to set
	 */
	public void setPhone(String _phone) {
		this._phone = _phone;
	}

	/**
	 * @return the _relationship
	 */
	public String getRelationship() {
		return _relationship;
	}

	/**
	 * @param _relationship the _relationship to set
	 */
	public void setRelationship(String _relationship) {
		this._relationship = _relationship;
	}
}

