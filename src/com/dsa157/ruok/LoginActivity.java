package com.dsa157.ruok;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class LoginActivity extends Activity {

	protected EditText _idFld;
	protected EditText _pwFld;
	protected Button _loginBtn;
	protected Button _createBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			final Context ctx = this;
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
					Intent i = new Intent(ctx, CreateAccountActivity.class);
					startActivity(i);
				}

			});
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


}
