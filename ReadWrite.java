package exer2;


import java.util.*;
import java.io.*;

class ReadWrite {
	
	static ArrayList<String> readFile(String fileName, int row, int column) throws IOException {
		Scanner scanner = new Scanner(new File(fileName));
		ArrayList<String> list = new ArrayList<>();
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
			String[] lineContent = line.split("\t");
			int i = 0;
			while(i < lineContent.length) {
				list.add(lineContent[i]);
				i++;
			}
			while(i < column) {
				list.add(null + "\u00BD" + null);
				i++;
			}
		}
		return list;
	}

	static void writeToFile(List<String> rowList, List<String> columnList, int row, int column) throws IOException {
		int rowCtr = 0, columnCtr = 0, counter = 0;
		String fileName = Main.fileName;
		BufferedWriter bw =  new BufferedWriter(new FileWriter(fileName));
		try {
			while(rowCtr < row) {
				columnCtr = 0;
				while(columnCtr < column) {
					bw.write(rowList.get(counter) + "\u00BD" + columnList.get(counter) + "\t"); 
					columnCtr++;
					counter++;
				}
				bw.newLine();
				rowCtr++;
			}
			bw.flush();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch(Exception e) {

			}
		}


	}



	



}