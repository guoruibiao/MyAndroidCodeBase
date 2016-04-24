#Here is the tutorial of those custom components
---
### For Toast

I only do one custom Toast, which have icons or not.You can also decide where to show in your activity. You can get this in the source.

### For Dialog

Like Toast, My Dialog also can carry icons or not. all the style can be decide by yourself. I think you will like it. :-)

### TimePicker

remember to use support library if your api older then 3.0. And the LayoutParent must be extends from FragmentActivity. So you can use the method of getSupportFragmentManager() and complete that.
my step:
   1: create a class named TimePickerFragment extends DialogFragment;
   2: implements the method in the interface onTimeSetListener and Define the onCreateDialog() method to return an instance of TimePickerDialog
   3：Once you've defined a DialogFragment like the one shown above, you can display the time picker by creating an instance of the DialogFragment and calling show(). The first parameter is "getSupportFragmentManager()",the second is a tag casual.


### DatePicker 

Likes the TimePicker , the principle is the same . you can just use the Dialog to show(). That's fine.

···
