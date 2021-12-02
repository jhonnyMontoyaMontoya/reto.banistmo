package test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;
import pom.ToolsBC;

public class TestToolsBC extends BaseTest {

    public ToolsBC objToolsBC = new ToolsBC();

    @Test(priority = 0, description = "Valid Convert Interest Rates scenario success.")
    public void testConvertInterestRatesSuccess() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testConvertInterestRatesSuccess",
                "Valid Convert Interest Rates scenario success.");
        objToolsBC.ConvertInterestRates("1", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 0, description = "Valid Convert Interest Rates scenario Failed.")
    public void testConvertInterestRatesFailed() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testConvertInterestRatesFailed",
                "Valid Convert Interest Rates scenario Failed.");
        objToolsBC.ConvertInterestRates("2", objTestReport);
        ExtentTestManager.endTest();
    }

    @Test(priority = 0, description = "Valid Convert Interest Rates scenario success.")
    public void testConvertInterestRatesSuccess2() throws FilloException, IncorrectDataDrivenValues {
        ExtentTest objTestReport = ExtentTestManager.startTest("testConvertInterestRatesSuccess2",
                "Valid Convert Interest Rates scenario success.");
        objToolsBC.ConvertInterestRates("3", objTestReport);
        ExtentTestManager.endTest();
    }
}
