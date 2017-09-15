package com.allfinish.method.third;

import com.allfinish.R;
import com.allfinish.app.AppApplication;
import com.allfinish.base.BaseActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondStep extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_step);
		initView();
		AppApplication.getApp().addActivity(this);
	}

	private void initView() {
		Button btn_next_step = (Button) findViewById(R.id.btn_next_step);
		btn_next_step.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), ThirdStep.class));
			}
		});
	}
}