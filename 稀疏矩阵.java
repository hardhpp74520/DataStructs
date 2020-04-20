package com.upon.brush;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 稀疏矩阵 {

	public static void main(String[] args) throws IOException {
		// 初始化
		int[][] arr = new int[6][7];
		arr[0][0] = 1;
		arr[1][1] = 1;
		arr[2][2] = 1;
		arr[3][3] = 1;
		arr[4][4] = 1;
		arr[5][5] = 1;

		System.out.println("原数组");
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.printf("%d\t", is2);
			}
			System.out.println();
		}

		// 转换稀疏数组
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					sum++;
				}
			}
		}

		// 构建稀疏矩阵并初始化
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = arr.length;
		sparseArr[0][1] = arr[0].length;
		sparseArr[0][2] = sum;

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = arr[i][j];
				}
			}
		}
		FileWriter writer = new FileWriter(new File("map.data"));

		// 输出稀疏矩阵
		System.out.println("输出稀疏矩阵");

		for (int[] is : sparseArr) {
			for (int is2 : is) {
				System.out.printf("%d\t", is2);
				writer.write(is2 + "\t");
			}
			writer.write("\t\r");
			System.out.println();
		}
		if (writer != null) {
			writer.close();
		}
		
		/**
		 * BufferedReader in = new BufferedReader(new FileReader(file));  //
		 *   String line;  //一行数据   int row=0;   //逐行读取，并将每个数组放入到数组中
		 *   while((line = in.readLine()) != null){
		 *    String[] temp = line.split("\t");     for(int j=0;j<temp.length;j++){
		 *     arr2[row][j] = Double.parseDouble(temp[j]);    }    row++;   }
		 *   in.close();
		 */
		
//		while ((line = bufferedReader.readLine()) != null) {
//			System.out.println(line);
//		}
//		fileReader.close();
//		bufferedReader.close();

		FileReader fileReader = new FileReader(new File("map.data"));
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		// 创建缓存区
		int row = 0;
		String line;
		while((line = bufferedReader.readLine()) != null) {
			String[] temp = line.split("\t");
			for (int i = 0; i < temp.length; i++) {
				String string = temp[i];
				sparseArr[row][i] = Integer.parseInt(string);
			}
			row++;
		}
		
		bufferedReader.close();

		// 稀疏转原数组
		int x = sparseArr[0][0];
		int y = sparseArr[0][1];
		int arr2[][] = new int[x][y];

		for (int i = 1; i < sparseArr.length; i++) {
			for (int j = 1; j < sparseArr[i].length; j++) {
				arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
			}
		}
		
		System.out.println("原数组");
		for (int[] is : arr2) {
			for (int is2 : is) {
				System.out.printf("%d\t", is2);
			}
			System.out.println();
		}
	}
}
