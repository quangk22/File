package quang.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import quang.dev.model.Circle;
import quang.dev.model.Rect;
import quang.dev.model.Shape;
import quang.dev.model.Triangle;

public class MainApp {
	static final String FILE = "input.txt";
	static final long NUMBER_SHAPE = 1000;

	static final int CIRCLE = 0;
	static final int RECT = 1;
	static final int TRIANGLE = 2;

	public static void main(String[] args) throws IOException {
		IManager manager = new Manager();
		randomFileData(FILE);
		readFromFile(FILE, manager);
		print(manager);

//		System.out.println("Danh sách các đối tượng sau khi sắp xếp:");
//		manager.sort();
//		print(manager);
//
//		System.out.println("Hinh co chu vi lon nhat");
//		Shape max = manager.findMaxChuVi();
//		System.out.println(max);
	}

	private static void readFromFile(String file, IManager manager) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fstream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				String s[] = strLine.split(":");
				switch (s[0]) {
					case "Circle":
						manager.add(readCircle(s[1]));
						break;
					case "Triangle":
						manager.add(readTriangle(s[1]));
						break;
					case "Rect":
						manager.add(readRect(s[1]));
						break;
					default:
						break;
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void randomFileData(String fileName) throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer = new FileWriter(fileName);
		Random rand = new Random();
		String line = "";
		
		for (long i = 0; i < NUMBER_SHAPE; i++) {
			int randomNumber = rand.nextInt(3);
			switch (randomNumber) {
				case CIRCLE:
					int r = rand.nextInt(100);
					line = String.format("%s:%d\n", "Circle", r);
					break;
				case RECT:
					int r1 = rand.nextInt(100);
					int r2 = rand.nextInt(100);
					line = String.format("%s:%d,%d\n", "Rect", r1, r2);
					break;
				case TRIANGLE:
					int rd1 = rand.nextInt(100);
					int rd2 = rand.nextInt(100);
					int rd3 = rand.nextInt(100);
					line = String.format("%s:%d,%d,%d\n", "Triangle", rd1, rd2, rd3);
					break;
	
				default:
					break;
			}
			writer.write(line);
		}
		writer.close();

	}

	private static void print(IManager manager) {
		// TODO Auto-generated method stub
		for (Shape shape : manager.all()) {
			System.out.println(shape);
		}
//		
//		for (int i = 0; i < manager.all().size(); i++) {
//			System.out.println(manager.all().get(i));
//		}
//		
//		Iterator<Shape> it = manager.all().iterator();
//		
//		for (;it.hasNext();) {
//			System.out.println(it);
//		}
//		
//		it = manager.all().iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it);
//		}
	}

	private static Shape readTriangle(String s) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String arr[] = s.split(",");
		double a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[1]);
		double c = Double.parseDouble(arr[2]);
		return new Triangle(a, b, c);
	}

	private static Shape readRect(String s) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String arr[] = s.split(",");
		double a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[1]);
		return new Rect(a, b);
	}

	private static Shape readCircle(String s) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		double r = Double.parseDouble(s);
		return new Circle(r);
	}

}
