package dev.asif.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class UserController {
	
	public static void main(String[] args) {
		
//		Connection conn = DBUtil.getConnection();
		
		try {
			
			File file = new File("D:\\amdocs\\Photograph.jpg");
			InputStream fis = new FileInputStream(file);
			
			byte[] pic = new byte[(int) file.length()];
			
			System.out.println(file.length());
			
			fis.read(pic);
			
			fis.close();
			
//			PreparedStatement ps;
//			
//			ps.setBinaryStream(1, fis, (int) file.length());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
