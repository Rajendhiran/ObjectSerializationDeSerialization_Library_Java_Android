package com.sample.serialization;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.object.library.Serialize_DeserializeObjectLibrary;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class Serialize extends Activity 
{
	public ArrayList<MyBean> Data;
	public MyBean beanData;
	Button btn;
	JSONObject jobject;
	JSONArray jarray;
	byte dataContent[];
	public ArrayList<MyBean> DataX;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		init();
		process();
	}

	private void process() 
	{
		beanData = new MyBean();
		beanData.setTitle("A Class");
		beanData.setSubTitle("A Sub Class");
		Data.add(beanData);

		beanData = new MyBean();
		beanData.setTitle("B Class");
		beanData.setSubTitle("B Sub Class");
		Data.add(beanData);

		beanData = new MyBean();
		beanData.setTitle("C Class");
		beanData.setSubTitle("C Sub Class");
		Data.add(beanData);

		jobject = new JSONObject();

		try 
		{
			dataContent = Serialize_DeserializeObjectLibrary.serializeObject(Data);			
		} 
		catch (Exception e) 
		{
			Log.d("MyBean", "Jobject MY Bean Class Error"+e);
			e.printStackTrace();
		}

		btn.setOnClickListener(new View.OnClickListener()
		{
			@SuppressWarnings("unchecked")
			public void onClick(View v)  
			{
				try
				{
					DataX = (ArrayList<MyBean>) Serialize_DeserializeObjectLibrary.deserializeObject(dataContent);
					for(int i=0;i<DataX.size();i++)
					{
						beanData = DataX.get(i);
						Log.d("Title: "+i+" :", beanData.getTitle());
						Log.d("SubTitle "+i+" :", beanData.getSubTitle());
					}
					Toast.makeText(Serialize.this, "DataX Size: "+DataX.size(), Toast.LENGTH_LONG).show();
				}
				catch (Exception e) 
				{				
					e.printStackTrace();
				}
			}
		});

	}
	private void init() 
	{
		Data= new ArrayList<MyBean>();
		btn = (Button) findViewById(R.id.btnTest);
		DataX = new ArrayList<MyBean>();
	}
}