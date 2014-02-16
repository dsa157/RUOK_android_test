/**
 * 
 */
package com.dsa157.ruok.view;

import com.dsa157.ruok.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author dsa157
 *
 */
public class ReportsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_reports);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}}
