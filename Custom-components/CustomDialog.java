package customcomponents;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/**
 * 自定义的用于和用户交互的对话框
 * 当用户点击确认的时候，回调是true，反之为false
 * @author 安楚豪
 *
 */
public class CustomDialog  {

	private Context mContext;
	private AlertDialog.Builder mBuilder;
	
	public CustomDialog(Context context) {
		this.mContext = context;
	}
	
	/**
	 * 设置一个带有图标的自定义的Dialog弹出菜单
	 * @param drawableId        图标的资源值ID
	 * @param PositiveButtonText 确定按钮的文本
	 * @param NegativeButonText  取消按钮的文本
	 * @param title              弹出的Dialog的标题信息
	 * @param text               弹出的Dialog的内容信息
	 * @param callBack           一个用于接收用户操作的接口回调
	 */
	public void withIcon(int drawableId, String PositiveButtonText ,
			String NegativeButonText , String title,
			String text, final CallBack callBack) {
		mBuilder = new AlertDialog.Builder(mContext);
		mBuilder.setIcon(drawableId);
		mBuilder.setTitle(title);
		mBuilder.setMessage(text);
		mBuilder.setPositiveButton(PositiveButtonText, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				callBack.isConfirm(true);
			}
		});
		mBuilder.setNegativeButton(NegativeButonText, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				callBack.isConfirm(false);
			}
		});
		mBuilder.create().show();
		
	}
	
	/**
	 * 设置一个不带有图标的自定义的Dialog弹出菜单
	 * @param PositiveButtonText 确定按钮的文本
	 * @param NegativeButonText  取消按钮的文本
	 * @param title              弹出的Dialog的标题信息
	 * @param text               弹出的Dialog的内容信息
	 * @param callBack           一个用于接收用户操作的接口回调
	 */
	public void withoutIcon(String PositiveButtonText ,
			String NegativeButonText , String title,
			String text, final CallBack callBack) {
		mBuilder = new AlertDialog.Builder(mContext);
		mBuilder.setTitle(title);
		mBuilder.setMessage(text);
		mBuilder.setPositiveButton(PositiveButtonText, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				callBack.isConfirm(true);
			}
		});
		mBuilder.setNegativeButton(NegativeButonText, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				callBack.isConfirm(false);
			}
		});
		mBuilder.create().show();
		
	}

}
