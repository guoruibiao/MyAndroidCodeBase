package utils;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


/**
 * ���������жϵ�ǰ�ֻ��Ƿ���ȷ�����ӵ�������
 * @author ������
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
	 * ���ڼ�⵱ǰ�����Ƿ��ܹ���ȷ�����ӵ����磬��������ϸ�ڵ���Ϣ
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
