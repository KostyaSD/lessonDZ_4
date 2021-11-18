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
        while (true) {
            humanTurn();
            aiTurn();
        }
    }

    private static void aiTurn() {
        int x;
        int y;

        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        MAP[y][x] = DOT_O;
    }

    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты в формате Х и У");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        MAP[x][y] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }

        if (MAP[y][x] == DOT_EMPTY) {
            return true;
        }

        return false;
    }


    private static void initMap() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

}
