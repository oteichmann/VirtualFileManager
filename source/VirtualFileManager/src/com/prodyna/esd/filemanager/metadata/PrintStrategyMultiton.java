package com.prodyna.esd.filemanager.metadata;

import java.util.HashMap;
import java.util.Map;

public class PrintStrategyMultiton {
	
	private static Map<FileType, PrintStrategy> instances = new HashMap<FileType, PrintStrategy>();
	
	private PrintStrategyMultiton() {}
	
    public static PrintStrategy getInstance(FileType fileType) {
        synchronized (instances) {

            // Our "per key" singleton
        	PrintStrategy instance = instances.get(fileType);

            if (instance == null) {

                instance = createTypeInstance(fileType);

                // Add it to map   
                instances.put(fileType, instance);
            }

            return instance;
        }
    }

	private static PrintStrategy createTypeInstance(FileType fileType) {
		
		PrintStrategy strategy = null;
		switch (fileType) {
		case TXT:
			strategy = new TextFilePrintStrategy();
			break;
		case PNG:
			strategy = new ImageFilePrintStrategy();
			break;
		case AVI:
			strategy = new VideoFilePrintStrategy();
			break;

		case UNKNOWN:
		default:
			strategy = new DefaultPrintStrategy();
			break;
		}
		 
		return strategy;
	}
    
    

}
