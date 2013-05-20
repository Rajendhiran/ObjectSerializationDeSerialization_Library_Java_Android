package com.sample.serialization;

import java.io.Serializable;

public class MyBean implements Serializable
{
	public String Title,SubTitle;
	
	public MyBean()
	{
	   Title="";
	   SubTitle="";
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSubTitle() {
		return SubTitle;
	}

	public void setSubTitle(String subTitle) {
		SubTitle = subTitle;
	}

}
