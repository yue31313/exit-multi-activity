package com.allfinish.base;


import com.allfinish.tools.StackManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class BaseActivity extends Activity {
	/** ����1��Ӧ��ע����� */
	public final static String INTENT_METHOD_FIRST_SINGUP = "com.allfinish.method.first.signupactivity";
	/** ����2��Ӧ��ע����� */
	public final static String INTENT_METHOD_SECOND_SINGUP = "com.allfinish.method.second.signupactivity";
	/** ����3��Ӧ��ע����� */
	public final static String INTENT_METHOD_THIRD_SINGUP = "com.allfinish.method.third.signupactivity";
	/** ����4��Ӧ��ע����� */
	public final static String INTENT_METHOD_FOURTH_SINGUP = "com.allfinish.method.fourth.signupactivity";
	/** ����5��Ӧ��ע����� */
	public final static String INTENT_METHOD_FIFTH_SINGUP = "com.allfinish.method.fifth.signupactivity";
	/** �˳��㲥��Ӧ��ACTION*/
	public final static String INIENT_FINISH = "com.allfinish.method.finish";
	
	public StackManager mStackManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	/**
	 * ��ʼ���˳��㲥
	 */
	public void initFinishReceiver() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(INIENT_FINISH);
		registerReceiver(mFinishReceiver, filter);
	}
	
	/**
	 * �����Ƿ��˳��Ĺ㲥
	 */
	public BroadcastReceiver mFinishReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (INIENT_FINISH.equals(intent.getAction())) {
				finish();
			}
		}
	};
	
	/** �ر�ʱ���requestCode������ */
	public final static int FINISH_REQUESTCODE = 1;
	/** �ر�ʱ���resultCode������ */
	public final static int FINISH_RESULTCODE = 1;
	/**
	 * ����5ͨ���ص��رյ�ʱ���õ�
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode == FINISH_REQUESTCODE ){
			if(resultCode == FINISH_RESULTCODE){
				setResult(FINISH_RESULTCODE);
				finish();
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
