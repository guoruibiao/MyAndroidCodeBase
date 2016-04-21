## Here I will tell you how to use it in your projects.

---
### For views 

such as Button ImageView and so on, you can attach some animations in them.

```
    final Button fg1_btn = (Button) view.findViewById(R.id.fg1_button);
		fg1_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Just like this, the first is the view you want to add animations,the second depend wether to finish the parent activity
				//the last is the side animations,totally 8 types.
				SwitchLayout.get3DRotateFromLeft(fg1_btn, false, BaseEffects.getMoreSlowEffect());
			}
		});
```


### For activity

truely, for activity is can do like views, because view is the parent for all visual componemt.
So try it yourself for all of them .

### Hope you get a good time by using this framework.
