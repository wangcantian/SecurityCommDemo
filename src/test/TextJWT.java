package test;

import com.paul.sertest.TokenMgr;

public class TextJWT {

	public static void main(String[] args) {
		try {
			System.out.println(TokenMgr.createJWT("78sawdff5", "xiaotiantian", 20 * 60 * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI3OHNhd2RmZjUiLCJzdWIiOiJ4aWFvdGlhbnRpYW4iLCJpYXQiOjE0OTgwMzE0NDIsImlzcyI6IjEyMi4xMTQuMjE0LjE0NyIsImV4cCI6MTQ5ODAzMjY0Mn0.0h_kDhyZLhnt8TRgbLsOnVT8eOUAqgFTEZP-XgIGuA";
		try {
			System.out.println(TokenMgr.parseJWT(jwt));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
