package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	private String fileUserName = "users.txt";
	private String fileAccsName = "accs.txt";
	
	private UserManager um = UserManager.instance;
	private AccountManager am = AccountManager.instance;
	
	public static FileManager instance = new FileManager();
	
	
	public String putData() {
		String data = "";
		for (int i = 0; i < this.am.ac.size(); i++) {
			data += um.users.get(i).getId()+" / ";
			data += um.users.get(i).getPw()+" / ";
			data += um.users.get(i).getName()+" / ";
			data += um.users.get(i).getAccCnt()+"\n";
		}
		return data;
	}//putData
	
	public void save() {
		//id/pw/name/code/accCnt
		try {
			String data = putData();
			this.file = new File(this.fileUserName);
			this.fw = new FileWriter(file);
			this.fw.write(data);
			
			this.file = new File(this.fileAccsName);
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//save

	public void load() {
		
	}//load
	
}//FileManager
