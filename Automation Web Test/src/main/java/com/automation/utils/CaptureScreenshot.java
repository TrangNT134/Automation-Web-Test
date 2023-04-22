package com.automation.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {
	public static void takeScreenshot(WebDriver driver, String name) {
		String filePath = "";
	    try {
	    	File theDir = new File("./Screenshots/");
	    	if (!theDir.exists()) {
	    		theDir.mkdirs();
	    	}
	    	String imageName = name + ".png";
	    	BufferedImage image = new Robot().createScreenCapture
	    			(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

	    	filePath = "./Screenshots/" + imageName;
	    	File desFile = new File(filePath);
	    	ImageIO.write(image, "png", desFile);

	    } catch (Exception e) {
	        System.out.println("Đã xảy ra lỗi khi chụp màn hình!");
	    }
	     attachScreenshot(filePath);
	}
	
	public static void attachScreenshot(String filePath) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			File file = new File(filePath);
			Reporter.log("<br> <a title= \"Screenshot\" href=\"" + file.getAbsolutePath() + "\">");
			Reporter.log("<img alt='" + file.getName() +"' src='" + file + "'height='240 width='418'/><br>");
		} catch (Exception e) {
		}
		
	}
	
	}
