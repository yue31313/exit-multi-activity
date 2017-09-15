package com.allfinish.tools;

import java.util.Stack;
import android.app.Activity;

/**
 * @ Activityջ�����ߡ�ͨ��ջʵ��
 * @author RA
 * 
 */
public class StackManager {
	/**
	 * Stack �ж�Ӧ��Activity�б�  ��Ҳ����д�� Stack<Activity>��
	 */
	private static Stack mActivityStack;
	private static StackManager mInstance;

	/**
	 * @���� ��ȡջ������
	 * @return ActivityManager
	 */
	public static StackManager getStackManager() {
		if (mInstance == null) {
			mInstance = new StackManager();
		}
		return mInstance;
	}

	/**
	 * �Ƴ�ջ��Activity
	 */
	public void popActivity(Activity activity) {
		if (activity != null) {
			activity.finish();
			mActivityStack.remove(activity);
			activity = null;
		}
	}

	/**
	 * ��õ�ǰջ��Activity
	 */
	public Activity currentActivity() {
		//lastElement()��ȡ������Ԫ�أ�������ջ����Activity
		if(mActivityStack == null || mActivityStack.size() ==0){
			return null;
		}
		Activity activity = (Activity) mActivityStack.lastElement();
		return activity;
	}

	/**
	 * ����ǰActivity����ջ��
	 */
	public void pushActivity(Activity activity) {
		if (mActivityStack == null) {
			mActivityStack = new Stack();
		}
		mActivityStack.add(activity);
	}

	/**
	 * ����ָ����clsss����ջ������������Activity
	 * @clsss : ָ������ 
	 */
	public void popTopActivitys(Class clsss) {
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			if (activity.getClass().equals(clsss)) {
				break;
			}
			popActivity(activity);
		}
	}
	
	/**
	 * ����ջ������Activity
	 */
	public void popAllActivitys() {
		while (true) {
			Activity activity = currentActivity();
			if (activity == null) {
				break;
			}
			popActivity(activity);
		}
	}
}
