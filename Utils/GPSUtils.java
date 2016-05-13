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
 * �����GPSģ���һϵ�в��� <br>
 * ���ڣ� 2016��5��13��9:21:52 <br>
 * ˼·�����ȳ�ʼ������Ҫ�Ĳ�����Ϣ����LocationManager,Ȼ���жϵ�ǰ��GPS�Ƿ���ã�����Ǿ��������С�����ǿ�ƴ�
 * 
 * <br>
 * ��ʹ�õ��˹㲥���ƣ���ϵͳ�ں�̨������صĲ���
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
	 * �жϵ�ǰ��GPS״̬
	 * 
	 * @return
	 */
	public boolean isLocationEnabled() {
		return locationManager
				.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER);
	}

	/**
	 * �Ը�����״̬�����ж�
	 * 
	 * @param locationEnabled
	 */
	public void openGPSSettings(boolean locationEnabled) {
		if (locationEnabled) {
			Toast.makeText(getApplicationContext(), "GPSģ�鹤��������", 0).show();
		} else {
			turnGPSOn();
		}
	}

	/**
	 * �Թ㲥�ķ�ʽ������ϵͳ�ں�̨ǿ�ƴ�GPS
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
