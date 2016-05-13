package utils;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


/**
 * 此类用于判断当前手机是否正确的连接到了网络
 * @author 安楚豪
 *
 */
public class WifiUtils extends Activity{
	
	private ConnectivityManager connManager = null;
	private NetworkInfo info = null;
	
	public static final int UNACLIVE = 10001;
	public static final int UNCONNECTED = 10002;
	public static final int OK = 10003;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		connManager = (ConnectivityManager) getSystemService("Context.CONNECTIVITY_SERVICE");
		info = connManager.getActiveNetworkInfo();
	}
	
	/**
	 * 用于检测当前网络是否能够正确的连接到网络，及反馈的细节的信息
	 * @return
	 */
	public int getNetworkInfo() {
		
		if(info == null ){
			return UNACLIVE;
		}else{
			boolean isAlive = info.isAvailable();
			if(isAlive){
				return OK;
			}else{
				return UNCONNECTED;
			}
		}
		
	}
	
	

}
