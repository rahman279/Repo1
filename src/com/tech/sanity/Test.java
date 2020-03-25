package com.tech.sanity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Test {

	static Properties props = null;
	static String filePath = "C:/Users/Shakil/wp-sam/TechSanity/WebContent/WEB-INF/classes/Demo.properties";
	public static final int USER_DOES_NOT_EXIST = 1; 
	public static final int USER_DELETED = 2;
	public static final int DELETION_FAILED = 3;
	public static final int PROBLEMS_OCCURED_WHILE_STORING = 4;
	public static final int USER_ALREADY_EXIST = 5;
	public static final int USER_ADDED = 6;
	public static final int INVALID_USER = 7;
	public static final int UPDATION_FAILED = 8;
	

	public static void main(String[] args) {

		// getDataFromPropertiesFile();
		// addUser("sam");
		// addUser1("hasib");
		// addUser2("ishrat");
		updateExistingProperty("ishrat");

	}

	public static void getDataFromPropertiesFile() {

		props = getProperties();

		// retrieves data based on key
		System.out.println(props.getProperty("MR98060"));
		System.out.println(props.getProperty("NV09502"));
		// retrieves all the data in key value pair
		for (Object obj : props.keySet()) {

			String key = (String) obj;
			System.out.println(key + " = " + props.getProperty(key));
		}
		System.out.println("data retrieved");

	}

	public static int addUser(String user) {

		props = getProperties(); // if getting properties obect in this
									// way then data will be appended in
									// file
		int ret = 0;

		try {
			if (user.length() > 0) {
				if (props.containsKey(user)) {
					System.out.println("user already exist");
					ret = USER_ALREADY_EXIST;
				} else {
					props.setProperty(user, "3333333");
					OutputStream os = new FileOutputStream(filePath);
					props.store(os, null);
					System.out.println("user added");
					ret = USER_ADDED;
				}
			} else {
				System.out.println("invalid user");
				ret = INVALID_USER;
			}

		} catch (FileNotFoundException e) {
			System.out.println("update failed");
			ret = UPDATION_FAILED;
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("problems occured while storing into file");
			ret = PROBLEMS_OCCURED_WHILE_STORING;
			e.getMessage();
		}
		return ret;

	}

	public static void addUser1(String user) {

		props = new Properties(); // if getting properties obect in this way
									// then data will bw overwritten in file

		props.setProperty(user, "12345");

		try {
			OutputStream os = new FileOutputStream(filePath);
			props.store(os, null);
		} catch (FileNotFoundException e) {
			System.out.println("update failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("problems occured while storing into file");
			e.getMessage();
		}

	}

	public static void addUser2(String user) {

		// will overwrite the data in the file

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(user + "=" + 123458);
		try {
			OutputStream os = new FileOutputStream(filePath);
			PrintWriter printWriter = new PrintWriter(os);
			printWriter.print(stringBuffer.toString());
			printWriter.flush();

		} catch (FileNotFoundException e) {
			System.out.println("update failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("problems occured while storing into file");
			e.getMessage();
		}

	}

	public static void updateExistingProperty(String user) {

		props = getProperties();

		StringBuffer stringBuffer = new StringBuffer();
		Set set = props.keySet();
		Iterator itr = set.iterator();
		if (itr.hasNext()) {

			String key = (String) itr.next();
			if (key.equals(user)) {
				stringBuffer.append(user + "=" + "shakil123");
			} else {
				stringBuffer.append(key + "=" + props.getProperty(key));
			}
			stringBuffer.append("\n");
		}

		try {
			OutputStream os = new FileOutputStream(filePath);
			PrintWriter printWriter = new PrintWriter(os);
			printWriter.print(stringBuffer.toString());
			printWriter.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int deleteUser(String user) {

		props = getProperties(); // if getting properties obect in this
		// way then data will be appended in
		// file
		
	    int ret = 0;

		try {
			if (!props.containsKey(user)) {
				System.out.println("user doesn't exist");
				ret = USER_DOES_NOT_EXIST;
			} else {
				props.remove(user);
				OutputStream os = new FileOutputStream(filePath);
				props.store(os, null);
				System.out.println("user deleted");
				ret = USER_DELETED;
			}
		} catch (FileNotFoundException e) {
			System.out.println("deletion failed");
			ret = DELETION_FAILED;
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("problems occured while storing into file");
			ret = PROBLEMS_OCCURED_WHILE_STORING;
			e.getMessage();
		}
		return ret;
	}

	public static Properties getProperties() {
		props = new Properties();

		try {
			InputStream is = new FileInputStream(filePath);
			props.load(is);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("problems occured while loading file");
		}

		return props;

	}
}
