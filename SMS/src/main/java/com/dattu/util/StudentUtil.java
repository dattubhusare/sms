package com.dattu.util;

import com.dattu.model.Student;

public interface StudentUtil {
	
	public static void calculation(Student student)
	{
		var fees=student.getCFee();
		var disc=fees*50/100.0;
		var gst=fees*18/100.0;
		student.setCDisc(disc);
		student.setGst(gst);
		
	}

}
