package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.*;
import toolsandutilities.Utilities;
import extentreports.ExtentTestManager;

public class BaseTest {

    @BeforeMethod
    public void methodLevelSetup() {
        Utilities.openUrl("https://www.bancolombia.com/personas");
    }

    @AfterMethod
    public void teardown() {
        Utilities.closeExplorer();
        Utilities.closeProcess();
        ExtentTestManager.endTest();
    }
}