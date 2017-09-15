package com.allfinish.app;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;

public class AppApplication extends Application {
	private static AppApplication mAppApplication;
	/** ��ǰ�򿪵�activity�б� */
	public ArrayList<Activity> activityList;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mAppApplication = this;
	}

	/** ��ȡApplication */
	public static AppApplication getApp() {
		if (mAppApplication == null) {
			mAppApplication = new AppApplication();
		}
		return mAppApplication;
	}

	/** ��ӵ�ǰActivity ���б��� */
	public void addActivity(Activity acitivity) {
		if(activityList == null){
			activityList = new ArrayList<Activity>();
		}
		activityList.add(acitivity);
	}
	
	/** ����б�ȡ������*/
	public void clearActivity(){
		activityList.clear();
	}

	/** �����˳�����Activity */
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		clearActivity();//ǧ��ǵ����ȡ�����á�
		System.exit(0);
	}
}
