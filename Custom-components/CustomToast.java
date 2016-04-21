package customcomponents;

import android.R;
import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * �߶��Զ����һЩToastʵ��
 * 
 * @author ������
 * 
 */
public class CustomToast {

	private Context mContext;

	public CustomToast(Context context) {
		this.mContext = context;
	}

	/**
	 * ʵ���Զ���toastλ�õķ���
	 * 
	 * @param gravity
	 *            Gravity��Ĭ��ֵΪCENTER������֮�⻹�кܶ࣬���Դ����
	 */
	public void createToastByCoordinate(int gravity, String text, int duration) {
		Toast toast = Toast.makeText(mContext, text, duration);
		toast.setGravity(gravity, 0, 0);
		toast.show();
	}

	/**
	 * ʵ���Զ����toast�Ĵ�ͼƬ�ķ���
	 * 
	 * @param drawableId
	 *            ͼƬ����ԴID
	 * @param text
	 *            Toast���ı���ʾ��Ϣ
	 * @param gravity
	 *            Toast����ʾ��λ�ã�ʹ��Gravity������ȷ��
	 */
	public void createToastWithIcon(int gravity, int drawableId, String text,
			int duration) {
		Toast toast = Toast.makeText(mContext, text, duration);
		toast.setGravity(gravity, 0, 0);
		LinearLayout toastView = (LinearLayout) toast.getView();
		ImageView imageCodeProject = new ImageView(mContext);
		imageCodeProject.setImageResource(drawableId);
		toastView.addView(imageCodeProject, 0);
		toast.show();
	}

}
