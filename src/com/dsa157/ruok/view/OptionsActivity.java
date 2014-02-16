/**
 * 
 */
package com.dsa157.ruok.view;

import com.dsa157.ruok.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author dsa157
 *
 */
public class OptionsActivity extends Activity {

	protected Button _scheduleBtn;
	protected Button _recipientsBtn;
	protected Button _reportsBtn;
	final Context ctx = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_options);
		addScheduleBtn();
		addRecipientsBtn();
		addReportsBtn();
	}

	protected void addScheduleBtn() {
		_scheduleBtn = (Button) findViewById(R.id.scheduleBtn);
		_scheduleBtn.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				try {
					Intent i = new Intent(ctx, ScheduleActivity.class);
					startActivity(i);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void addRecipientsBtn() {
		_recipientsBtn = (Button) findViewById(R.id.recipientsBtn);
		_recipientsBtn.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				try {
					Intent i = new Intent(ctx, RecipientsActivity.class);
					startActivity(i);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void addReportsBtn() {
		_reportsBtn = (Button) findViewById(R.id.reportsBtn);
		_reportsBtn.setOnClickListener(new OnClickListener() {  
			@Override
			public void onClick(View v) {
				try {
					Intent i = new Intent(ctx, ReportsActivity.class);
					startActivity(i);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
