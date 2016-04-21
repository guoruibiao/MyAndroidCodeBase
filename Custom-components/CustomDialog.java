package customcomponents;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/**
 * �Զ�������ں��û������ĶԻ���
 * ���û����ȷ�ϵ�ʱ�򣬻ص���true����֮Ϊfalse
 * @author ������
 *
 */
public class CustomDialog  {

	private Context mContext;
	private AlertDialog.Builder mBuilder;
	
	public CustomDialog(Context context) {
		this.mContext = context;
	}
	
	/**
	 * ����һ������ͼ����Զ����Dialog�����˵�
	 * @param drawableId        ͼ�����ԴֵID
	 * @param PositiveButtonText ȷ����ť���ı�
	 * @param NegativeButonText  ȡ����ť���ı�
	 * @param title              ������Dialog�ı�����Ϣ
	 * @param text               ������Dialog��������Ϣ
	 * @param callBack           һ�����ڽ����û������Ľӿڻص�
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
	 * ����һ��������ͼ����Զ����Dialog�����˵�
	 * @param PositiveButtonText ȷ����ť���ı�
	 * @param NegativeButonText  ȡ����ť���ı�
	 * @param title              ������Dialog�ı�����Ϣ
	 * @param text               ������Dialog��������Ϣ
	 * @param callBack           һ�����ڽ����û������Ľӿڻص�
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
