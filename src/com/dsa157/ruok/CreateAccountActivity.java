/**
 * 
 */
package com.dsa157.ruok;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author dsa157
 *
 */
public class CreateAccountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_create_account);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
