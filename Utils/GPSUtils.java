package utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

/**
 * <p>
 * 针对于GPS模块的一系列操作 <br>
 * 日期： 2016年5月13日9:21:52 <br>
 * 思路：首先初始化所需要的参数信息，即LocationManager,然后判断当前的GPS是否可用，如果是就正常运行。否则强制打开
 * 
 * <br>
 * 打开使用到了广播机制，让系统在后台进行相关的操作
 * 
 * @author Administrator
 *         </p>
 */
public class GPSUtils extends Activity {

	private LocationManager locationManager = null;

	public LocationManager getLocationManager() {
		return this.locationManager;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		boolean isEnabled = isLocationEnabled();
		openGPSSettings(isEnabled);
	}

	/**
	 * 判断当前的GPS状态
	 * 
	 * @return
	 */
	public boolean isLocationEnabled() {
		return locationManager
				.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER);
	}

	/**
	 * 对给定的状态进行判断
	 * 
	 * @param locationEnabled
	 */
	public void openGPSSettings(boolean locationEnabled) {
		if (locationEnabled) {
			Toast.makeText(getApplicationContext(), "GPS模块工作正常！", 0).show();
		} else {
			turnGPSOn();
		}
	}

	/**
	 * 以广播的方式，利用系统在后台强制打开GPS
	 */
	private void turnGPSOn() {
		Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
		intent.putExtra("enabled", true);
		this.sendBroadcast(intent);

		String provider = Settings.Secure.getString(this.getContentResolver(),
				Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
		if (!provider.contains("gps")) { // if gps is disabled
			final Intent poke = new Intent();
			poke.setClassName("com.android.settings",
					"com.android.settings.widget.SettingsAppWidgetProvider");
			poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
			poke.setData(Uri.parse("3"));
			this.sendBroadcast(poke);
		}

	}

}
