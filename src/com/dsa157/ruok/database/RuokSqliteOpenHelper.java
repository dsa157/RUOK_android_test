/**
 * 
 */
package com.dsa157.ruok.database;

import com.dsa157.ruok.model.Recipient;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author dsa157
 *
 */
public abstract class RuokSqliteOpenHelper extends SQLiteOpenHelper {

	protected static final int DATABASE_VERSION = 1;

	public RuokSqliteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}



	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      Log.w(Recipient.class.getName(),
          "Upgrading " + getTableName() + " from version " + oldVersion + " to "
              + newVersion + ", which will destroy all old data");
      db.execSQL(TABLE_DROP);
      onCreate(db);
    }
	
    protected final String TABLE_DELETE =
            "delete from " + getTableName() + " where " + getColumnID() + "=%s;"; 

    protected final String TABLE_DROP =
            "drop table if exists " + getTableName() +";"; 

    public static String getTableName() {return ""; };
    
    public static String getColumnID() {return ""; };
    
    
}
