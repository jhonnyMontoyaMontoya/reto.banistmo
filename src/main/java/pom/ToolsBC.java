package pom;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import data.DataDriven;
import exceptions.IncorrectDataDrivenValues;
import extentreports.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toolsandutilities.Utilities;

public class ToolsBC {
    private static final By TASA = By.xpath("//a[@id='header-pymes']");
    private static final By HERRAMIENTAS = By.xpath("//*[contains(text(),'Herramientas')]");
    private static final By CONVERSOR = By.xpath("//h3[contains(text(),'Conversor de tasas de interés')]");
    private static final By ICONO_CERRAR = By.xpath("//img[@class='btn-modal']");
    private static final By INTERES = By.xpath("//input[@id='interes']");
    private static final By PERIODICIDAD = By.xpath("//select[@id='periodicidad-deseada']");
    private static final By CAPITALIZACION = By.xpath("//select[@id='capitalizacion']");
    private static final By RESPUESTA = By.xpath("//h3[@id='respuesta']");

    public ToolsBC ConvertInterestRates(String strId, ExtentTest objTestReport) throws IncorrectDataDrivenValues, FilloException {
        String respuesta;
        DataDriven objDataDriven = new DataDriven();
        Recordset objRecordset = objDataDriven.searchRecords
                ("src/test/resources/data/DataDriven.xlsx", "SELECT * FROM TasaNaE WHERE IdTasaNaE = '" + strId + "'");
        Utilities.waitForElement(ICONO_CERRAR, 1000);
        Utilities.click(ICONO_CERRAR);
        Utilities.waitForElement(TASA, 1000);
        Utilities.click(TASA);
        Utilities.waitForElement(HERRAMIENTAS, 1000);
        Utilities.click(HERRAMIENTAS);
        Utilities.waitForElement(CONVERSOR, 3000);
        Utilities.click(CONVERSOR);
        Utilities.waitForElement(INTERES, 3000);
        Utilities.type(INTERES, objRecordset.getField("Tasa"));
        Utilities.selectByVisibleText(PERIODICIDAD, objRecordset.getField("Periodicidad"));
        Utilities.selectByVisibleText(CAPITALIZACION, objRecordset.getField("Capitalizacion"));
        Utilities.waitForElement(RESPUESTA, 1000);
        respuesta = Utilities.getText(RESPUESTA);

        if (objRecordset.getField("RespuestaEsperada").equals(respuesta.trim())){
            objTestReport.log(LogStatus.PASS, "Convert interest rates test passed, Expected result: " +
                    objRecordset.getField("RespuestaEsperada"),
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }else{
            objTestReport.log(LogStatus.FAIL, "Convert interest rates test failed, Expected result: " +
                    objRecordset.getField("RespuestaEsperada"),
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }
        return this;
    }

}