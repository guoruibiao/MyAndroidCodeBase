package utils;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;

public class WiFiUtils extends Activity{

	private WifiManager wifiManager = null;

	//初始化所需要的一些参数信息
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	}

	public int getWifiStatus() {
		try {
			int status = wifiManager.getWifiState();
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WifiManager.WIFI_STATE_DISABLED;
	}
	
	public void enableWifi(int status) {
		try {
			if(status == WifiManager.WIFI_STATE_DISABLED) {
				wifiManager.setWifiEnabled(true);
			}
			wifiManager.setWifiEnabled(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
