package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class WriteFile {
	public void Write(String s,int fileName) throws UnsupportedEncodingException, FileNotFoundException{   
		FileWriter fw = null;
		
		String filePath = "F:\\Hadoopworkspace\\bs\\WebContent\\person\\"+String.valueOf(fileName)+".json";
		try {
//			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f=new File(filePath);
			fw = new FileWriter(f, false);
			} catch (IOException e) {
			e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"));
			pw.print(s);
			pw.flush();
			try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
	public void Write(String s,String fileName) throws UnsupportedEncodingException, FileNotFoundException{   
		FileWriter fw = null;
		
		String filePath = "F:\\Hadoopworkspace\\bs\\WebContent\\company\\"+fileName+".json";
		try {
//			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File f=new File(filePath);
			fw = new FileWriter(f, false);
			} catch (IOException e) {
			e.printStackTrace();
			}
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath),"UTF-8"));
			pw.print(s);
			pw.flush();
			try {
			fw.flush();
			pw.close();
			fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
}
