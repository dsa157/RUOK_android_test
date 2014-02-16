/**
 * 
 */
package com.dsa157.ruok.view;

import com.dsa157.ruok.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;

/**
 * @author dsa157
 *
 */
public class ScheduleActivity extends Activity {

	final Context ctx = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_schedule);
			
			addButton("10:00am Mon");
			addButton("09:00am Tue");
			addButton("09:00am Wed");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void addButton(String label) {
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout1);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		RadioButton rb = new RadioButton(ctx);
		rb.setText(label);
		ll.addView(rb, lp);
		
	}
}
