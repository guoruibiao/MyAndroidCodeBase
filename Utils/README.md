### The tutorial of this simple util 

---

You can easily use this to parse the date to string or string to date. Here is the sample.

```
      System.out.println(DateUtil.parseToDate("2016-4-22").toLocaleString());
  		
  	  System.out.println(DateUtil.parseCurrentTimeMillions(System.currentTimeMillis()));
  		
  	  System.out.println(DateUtil.parseCurrentTimeMillionsToChinese(System.currentTimeMillis()));

```

then you can get the result.

```
    2016-5-22 11:58:17
    2016-04-22
    2016年  04月  22日  
```
