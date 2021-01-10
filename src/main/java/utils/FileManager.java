package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
	private static FileWriter fw = null;
	private static BufferedWriter bw = null;
	private static PrintWriter pw = null;

	private static void createFile(String fileName) {
		try {
			File file = new File(fileName);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void appendToFile(String fileName, String data) {
		writeOnFile(fileName, data, true);
	}

	private static void writeOnFile(String fileName, String data, boolean append) {
		createFile(fileName);

		try {
			try {
				fw = new FileWriter(fileName, append);
			} catch (IOException e) {
				e.printStackTrace();
			}
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			pw.println(data);
			pw.flush();

		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException io) {// can't do anything }
			}
		}
	}

	public static void eraseDataFromFile(String fileName) {
		writeOnFile(fileName, "", false);
	}

}
