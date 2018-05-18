package com.testresults;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.datamanager.ConfigManager;
import com.utilities.JDBCConn;
import Exception.FilloException;
import Fillo.Connection;
import Fillo.Recordset;

public class UploadResultsToDB
{
	
	public static void uploadResultsToDB()
	{
		Logger log = Logger.getLogger("UploadResultsToDB");
		ConfigManager sys = new ConfigManager();
		ResultsToLocalExcel resultToExcel = new ResultsToLocalExcel(sys.getProperty("TestResultExcelFile"));
		Connection connection = resultToExcel.connection;
		String tableName = sys.getProperty("TABLENAME");
		String latestSheet = sys.getProperty("TestResult.LATEST.Sheet");
		try
		{
			Recordset recordset =connection.executeQuery("Select * from "+latestSheet);
			ArrayList<String> columns = recordset.getFieldNames();
			HashMap<String, String> columnsAndValues = new HashMap<>();
			while (recordset.next())
			{
				for(int c=0;c<columns.size();c++)
				{
					columnsAndValues.put(recordset.getField(c).name(), recordset.getField(recordset.getField(c).name()));
				}
				String[] colDetails = resultToExcel.generateColumnsString(columnsAndValues);
				JDBCConn.insert("INSERT INTO "+tableName+" ("+colDetails[0]+") VALUES("+colDetails[1]+")");
			}
			log.info("Writing the details is completed");
		}
		catch(FilloException e)
		{
			log.info("Fillo has some issue");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			log.info("some Exception occured while writing the data");
			e.printStackTrace();
		}
		finally
		{
			if(!(connection==null))
			{
				log.info("Connection not closed. Hence retry to close");
				connection.close();
				log.info("Connection closed");
			}
		}
	}

}
