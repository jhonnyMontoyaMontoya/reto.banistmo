package data;

import exceptions.IncorrectDataDrivenValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataDriven  {
    private static Logger logger = LoggerFactory.getLogger(DataDriven.class.getName());
    static final String STRMSG = " no válida.";
    static final String STRMSGERROR = "Error: ";
    static final String STRCONDITION = " WHERE ID = ";
    Fillo objConnection = new Fillo();

    public Connection loadExcel(String strPath) throws IncorrectDataDrivenValues {
        try {            
            return objConnection.getConnection(strPath);
        } catch (Exception e) {
            logger.error(STRMSGERROR, e);
            logger.info("No se pudo establecer la conexión con el archivo de excel.");
            throw new IncorrectDataDrivenValues("No se pudo establecer la conexión con el archivo de excel.");
        }
    }

    public Recordset searchRecords(String strPath, String strQuery) throws IncorrectDataDrivenValues {
        try {
            Recordset objRecordset = loadExcel(strPath).executeQuery(strQuery);

            while (objRecordset.next()) {
                return objRecordset;
            }

            objRecordset.close();
            loadExcel(strPath).close();
        } catch (FilloException e) {
            logger.error(STRMSGERROR, e);
            logger.info("Consulta " + strQuery + STRMSG);
            throw new IncorrectDataDrivenValues("Consulta " + strQuery + STRMSG);
        }
        return null;
    }

    public void updateRecord(String strPath, String strQuery) throws IncorrectDataDrivenValues {
        try {
            loadExcel(strPath).executeUpdate(strQuery);
        } catch (Exception e) {
            logger.error(STRMSGERROR, e);
            logger.info("Update: " + strQuery + STRMSG);
            throw new IncorrectDataDrivenValues("Update: " + strQuery + STRMSG);
        }
    }

    public void insertRecord(String strPath, String strQuery) throws IncorrectDataDrivenValues {
        try {
            loadExcel(strPath).executeUpdate(strQuery);
        } catch (Exception e) {
            logger.error(STRMSGERROR, e);
            logger.info("Insert: " + strQuery + STRMSG);
            throw new IncorrectDataDrivenValues("Insert: " + strQuery + STRMSG);
        }
    }
}