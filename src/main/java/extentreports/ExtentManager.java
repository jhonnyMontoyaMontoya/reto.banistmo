package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import toolsandutilities.Utilities;
import java.io.File;

public class ExtentManager {

    public static ExtentReports extent;

    public static synchronized ExtentReports getReporter() {

        if (extent == null) {
            String strWorkingDir = System.getProperty("user.dir");
            extent = new ExtentReports(strWorkingDir + "/ExtentReports/ReportResults" +
                    Utilities.getDateYYYYMMDDHHMMSS() + ".html", true);
            extent.loadConfig(new File(strWorkingDir + "/extent-config.xml"));
        }

        return extent;
    }
}