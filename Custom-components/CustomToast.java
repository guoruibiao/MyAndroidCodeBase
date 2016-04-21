package customcomponents;

import android.R;
import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 高度自定义的一些Toast实现
 * 
 * @author 安楚豪
 * 
 */
public class CustomToast {

	private Context mContext;

	public CustomToast(Context context) {
		this.mContext = context;
	}

	/**
	 * 实现自定义toast位置的方法
	 * 
	 * @param gravity
	 *            Gravity的默认值为CENTER，除此之外还有很多，详见源代码
	 */
	public void createToastByCoordinate(int gravity, String text, int duration) {
		Toast toast = Toast.makeText(mContext, text, duration);
		toast.setGravity(gravity, 0, 0);
		toast.show();
	}

	/**
	 * 实现自定义的toast的带图片的方法
	 * 
	 * @param drawableId
	 *            图片的资源ID
	 * @param text
	 *            Toast的文本显示信息
	 * @param gravity
	 *            Toast的显示的位置，使用Gravity来进行确定
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
