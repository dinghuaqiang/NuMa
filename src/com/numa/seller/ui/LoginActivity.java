package com.numa.seller.ui;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class LoginActivity extends Activity {

	EditText accountEd;
	EditText pwdEd;
	Button loginBtn;

	Handler mHandler = new Handler();
	Runnable mRunnable = new Runnable() {

		@Override
		public void run() {
			accountEd.setText("");
			pwdEd.setText("");
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 去掉标题栏
		setContentView(R.layout.login_act);
		accountEd = (EditText) findViewById(R.id.login_account_edit);
		accountEd.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				System.out.println("---------------start--------------");
				mHandler.post(mRunnable);
				return false;
			}
		});
		pwdEd = (EditText) findViewById(R.id.login_pwd_edit);
		accountEd.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				mHandler.post(mRunnable);
				return false;
			}
		});
		loginBtn = (Button)findViewById(R.id.login_btn);
		loginBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, HomePageActivity.class);
				startActivity(intent);
			}
		});
	}

}
