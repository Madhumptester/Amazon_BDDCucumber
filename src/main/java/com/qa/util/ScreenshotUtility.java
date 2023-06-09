package com.qa.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.factory.Driver_Factory;

public class ScreenshotUtility extends Driver_Factory{

	
	private Logger logg;

	public ScreenshotUtility(Logger logg) {
		this.logg = logg;
	}
	
public  void captureScreenshot(String classname,String screenshotName) throws Exception {
	String fileLocation=null;
	String recentCreatedFile=null;
	
	String exeTime = new SimpleDateFormat("hh:mm").format(new Date());
	
	TakesScreenshot ts = (TakesScreenshot)getDriver();
	File source=ts.getScreenshotAs(OutputType.FILE);
	
	 fileLocation=System.getProperty("user.dir")+"\\"+"test-output\\"; 
	 recentCreatedFile=ElementUtil.getfolder(fileLocation);
	 
	File f = new File(recentCreatedFile);
	if(f.exists()) { 
		FileUtils.copyFile(source, new File(recentCreatedFile+"\\"+"Screenshot"+"\\"+classname,screenshotName+".png"));	
	}	
	else {
		FileUtils.copyFile(source, new File(fileLocation+"\\"+"Screenshot"+"\\"+classname+exeTime,screenshotName+".png"));
	}
}

}
