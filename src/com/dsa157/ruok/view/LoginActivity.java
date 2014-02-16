package com.dsa157.ruok.view;

import java.util.ArrayList;

import com.dsa157.ruok.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class LoginActivity extends Activity {

	protected static final int PICK_CONTACT = 0;
	protected EditText _idFld;
	protected EditText _pwFld;
	protected Button _loginBtn;
	protected Button _createBtn;
	protected ListView _listView;
	final Context ctx = this;
	protected ArrayAdapter<String> _adapter;
	protected ArrayList<String> _listItems=new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_login);

			_idFld = (EditText) findViewById(R.id.userID);
			_pwFld = (EditText) findViewById(R.id.userPW);
			_loginBtn = (Button) findViewById(R.id.loginBtn);
			_loginBtn.setOnClickListener(new OnClickListener() {  
				@Override
				public void onClick(View v) {
					try {
						//updateStatus("login clicked");
						Intent i = new Intent(ctx, OptionsActivity.class);
						startActivity(i);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}

			});

			_createBtn = (Button) findViewById(R.id.createBtn);
			_createBtn.setOnClickListener(new Button.OnClickListener() {  
				@Override
				public void onClick(View v)
				{
					//Intent i = new Intent(ctx, CreateAccountActivity.class);
					//startActivity(i);

					Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI); //ContactsContract.Contacts.CONTENT_URI);
					//ContactsContract.CommonDataKinds.Phone.CONTENT_URI
					startActivityForResult(intent, PICK_CONTACT);
				}

			});
			
			addListItems();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	protected void updateStatus(String s) {
		Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onActivityResult(int reqCode, int resultCode, Intent intent) {
		super.onActivityResult(reqCode, resultCode, intent);

		switch (reqCode) {
		case (PICK_CONTACT):
			if (resultCode == Activity.RESULT_OK) {
				Uri contactData = intent.getData();
				if (contactData != null) {
					String[] columns = {ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
					Cursor c = getContentResolver().query(contactData, columns, null, null, null);
					if (c.moveToFirst()) {
						String name = c.getString(1);
						//String email = c.getString(2);
						String phone = c.getString(2);
						addItem(_listView, name + " " + phone);

					}
					break;
				}
			}
		}
	}

	protected void addListItems() {
		_adapter=new ArrayAdapter<String>(ctx,
				android.R.layout.simple_list_item_1,
				_listItems);
		_listView = (ListView) findViewById(R.id.list);
		_listView.setAdapter(_adapter);
//		addItem(_listView, "aaa");
//		addItem(_listView, "bbb");
//		addItem(_listView, "ccc");
	}

	public void addItem(View v, String s) {
		_listItems.add(s);
		_adapter.notifyDataSetChanged();
	}

}
