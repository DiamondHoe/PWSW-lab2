package com.lab2;

import java.util.Random;

public class Excercise3 extends Helpers implements IExcercise{
    public void Start(){
        String prompt = "Podaj wymiar macierzy kwadratowej";
        String inputMessage = "Podaj liczbę całkowitą";

        int size = GetInt(prompt, inputMessage);

        int[][] matrix1 = generateMatrix(size);
        int[][] matrix2 = generateMatrix(size);

        System.out.println("Macierz 1:");
        printMatrix(matrix1);

        System.out.println("Macierz 2:");
        printMatrix(matrix2);

        int[][] sumMatrix = addMatrices(matrix1, matrix2);
        System.out.println("Suma macierzy:");
        printMatrix(sumMatrix);

        int[][] diffMatrix = subtractMatrices(matrix1, matrix2);
        System.out.println("Różnica macierzy:");
        printMatrix(diffMatrix);

        int[][] productMatrix = multiplyMatrices(matrix1, matrix2);
        System.out.println("Iloczyn macierzy:");
        printMatrix(productMatrix);
    }

    private int[][] generateMatrix(int size) {
        Random random = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(21) - 10;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] sumMatrix = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    private static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] diffMatrix = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                diffMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return diffMatrix;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] productMatrix = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                for (int k = 0; k < matrix1.length; k++) {
                    productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return productMatrix;
    }
}
