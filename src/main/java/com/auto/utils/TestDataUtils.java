package com.auto.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is a helper class used for reading test data
 * 
 * @author Geetika
 *
 */
public class TestDataUtils {

	public static final int baseURLIndex = 0;
	public static final int userNameIndex = 1;
	public static final int passwordIndex = 2;
	public static final int searchTermIndex = 3;

	private static String userName;
	private static String password;
	private static String searchTerm;
	private static String baseURL;

	public static void readTestData() {
		String line = "";
		String splitBy = ",";
		try {
			ClassLoader classLoader = TestDataUtils.class.getClassLoader();
			File file = new File(classLoader.getResource("TestData.txt").getFile());

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while ((line = br.readLine()) != null) {
				String[] TestData = line.split(splitBy);
				System.out.println("base URL " + TestData[0] + "User name " + TestData[1] + " password" + TestData[2]
						+ "searchTerm" + TestData[3]);

				baseURL = TestData[baseURLIndex];
				userName = TestData[userNameIndex];
				password = TestData[passwordIndex];
				searchTerm = TestData[searchTermIndex];

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUserName() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}

	public static String getSearchTerm() {
		return searchTerm;
	}

	public static String getBaseURL() {
		return baseURL;
	}

}
