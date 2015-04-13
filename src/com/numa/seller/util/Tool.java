package com.numa.seller.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Tool {
	
	// 检测网络是否连接
	public boolean checkNetWork(Activity activity){
		Context context = activity;
		// 实例化ConnectivityManager
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 获取当前网络信息
		NetworkInfo info = manager.getActiveNetworkInfo();
		// 判断是否连接
		if (info == null || info.isConnected()) {
			return false;
		}
		return true;
	}
}
