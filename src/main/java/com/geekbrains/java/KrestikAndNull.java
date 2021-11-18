package com.geekbrains.java;

import java.util.Random;
import java.util.Scanner;

public class KrestikAndNull {
    private final static int SIZE = 3;
    private final static int DOTS_TO_WIN = 3;
    private final static char DOT_EMPTY = '.';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private static char[][] MAP;
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
    }



    private static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++){
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++){
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

}
