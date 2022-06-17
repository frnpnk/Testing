package com.digitalbooking.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {

    public static ExtentReports getInstance(){

        ExtentReports extent = new ExtentReports();

        extent.flush();
        extent.setSystemInfo("Selenium Version", "4.0.0");
        extent.setSystemInfo("platform", "Windows");
        return extent;
    }
}
