package csc2a.desc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import csc2a.desc.model.Crisis;
import csc2a.desc.model.Event;
import csc2a.desc.model.ReportEntity;
import csc2a.desc.file.CrisisFileHandler;

public class BinaryReportFileHandler {
	private ReportEntity[] entity;


	//reading the binary Crisis Report file and the associated Crisistextfile
	public ReportEntity[] readCrisisReports(File file) {
        Crisis crisis = null;
        File fileCrisisID = null;
        String[] FileContent = null;//array that will contain the data from the binary file
        
        String str = "";
        String CrID = "";
        int i = 0;
 
        try (
            InputStream inputStream = new FileInputStream(file);
        ) {
 
            int byteRead;
            //reading Report file and getting the Crisis ID
            while ((byteRead = inputStream.read()) != -1 && i <= 7) {
            	if (i > 1) {
            		CrID  += (char)byteRead;
            	}
            	i++;
            }
            
            //reading file contnt and saving the data to string
            while ((byteRead = inputStream.read()) != -1) {
        		CrID  += (char)byteRead;
        		if (((char)byteRead >= 'A' && (char)byteRead <= 'Z') || ((char)byteRead >= '0' && (char)byteRead <= '9')) {
        			str +=  (char)byteRead;
        		}else {
        			str += " ";
        		}
            }
            int x = 0;
            int y = 0;
            //the element at index '0' is the crisis ID
            FileContent = str.trim().split("\\s+");//splitting the content by n amount of spaces 
            
            //Creating an instance of the Crisis class
            fileCrisisID = new File(FileContent[0] + ".txt");
            new CrisisFileHandler();
            
            //reading Crisis from the filename created by getting the Crisis ID
			crisis = CrisisFileHandler.readCrisis(fileCrisisID);
			
			//creating instances of type ReportEntity
			i = 0;
			
			//creating the instace of the report entity using the Crisis
			while (FileContent[i] != null) {
				entity[i] = new ReportEntity(x, y, crisis.getEvent(i));
				i++;
			}
			
			inputStream.close();//closing the input styream
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return (entity);
	}
	
}
