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
public class OptionsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_options);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
