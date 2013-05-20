package com.object.library;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import android.util.Log;

public class Serialize_DeserializeObjectLibrary  
{
	public static byte[] serializeObject(Object o) 
	{ 
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 

		try { 
			ObjectOutput out = new ObjectOutputStream(bos); 
			out.writeObject(o); 
			out.close(); 

			// Get the bytes of the serialized object 
			byte[] buf = bos.toByteArray(); 

			return buf; 
		} catch(Exception e) { 
			Log.e("serializeObject", "error", e); 
			return null;
		} 
	}

	public static Object deserializeObject(byte[] b) { 
		try { 
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(b)); 
			Object object = in.readObject(); 
			in.close(); 

			return object; 
		} catch(ClassNotFoundException cnfe) { 
			Log.e("deserializeObject", "class not found error", cnfe); 

			return null; 
		} catch(Exception e) { 
			Log.e("deserializeObject", "io error", e); 

			return null;
		} 
	}
}
