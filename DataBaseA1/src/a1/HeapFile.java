package a1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class HeapFile {
	
	public HeapFile() {
		
	}
	
	private int pageSize;
	private String file;
	
	public void readFile(int pageSize, String file) {
		BufferedReader reader = null;
		FileWriter writer = null;

		// timer starts
		long startTime = System.currentTimeMillis();

		// variables to keep track of records and pages
		int recordCount = 0;
		int pageCount = 1;

		// create writer
		try {
			writer = new FileWriter(new File("heap." + pageSize));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading
		try {
			String line = "";

			reader = new BufferedReader(new FileReader(file));
			
			// skip the header line
			line = reader.readLine();
			//System.out.print(line);
			
			while ((line = reader.readLine()) != null) {
				
				// testing
				/*
				 * String row[] = line.split(",");
				 * 
				 * for (String index : row) { System.out.printf("%-10s", index); }
				 * System.out.println();
				 */

			
			}
			
			
			//get time by end of operation
			long endTime = System.currentTimeMillis();
			
			System.out.println("Record Count: " + recordCount);
			System.out.println("Page Count: " + pageCount);
			System.out.println("Time taken (milliseconds) = " + (endTime - startTime));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
		
	}

}