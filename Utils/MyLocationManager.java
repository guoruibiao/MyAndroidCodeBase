package utils;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class MyLocationManager {

	private LocationManager locationManager = null;
	private Location location;

	public MyLocationManager() {
		this.locationManager = new GPSUtils().getLocationManager();
	}

	public Double[] getLocation() {

		try {

			//����һЩ������Ϣ������������ڲ��Ҿ���ʲô����Ϣ
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);
			criteria.setAltitudeRequired(false);
			criteria.setBearingRequired(true);
			criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
			
			String provider = locationManager.getBestProvider(criteria, true);
			location = locationManager.getLastKnownLocation(provider);
			final Double[] position = new Double[2];
			
			locationManager.requestLocationUpdates(provider, 100*1000, 500, new LocationListener(){

				@Override
				public void onLocationChanged(Location location_) {
					position[0] = location.getLatitude();//ά��
					position[1] = location.getLongitude();//����
				}

				@Override
				public void onStatusChanged(String provider_, int status,
						Bundle extras) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onProviderEnabled(String provider_) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onProviderDisabled(String provider_) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			return position;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
