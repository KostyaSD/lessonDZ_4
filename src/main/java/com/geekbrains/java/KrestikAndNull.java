package com.geekbrains.java;

import java.util.Random;
import java.util.Scanner;

public class KrestikAndNull {
    private final static int SIZE = 5;
    private final static int DOTS_TO_WIN = 4;
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
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
            }
        }
        System.out.println("Игра окончена");
    }

    private static boolean checkWin(char Admin) {
        int win = 0;
        // проверка диагоналей "/"
        for (int i = 0, j = (SIZE - 1); i < SIZE; i++, j--) {
            if (MAP[i][j] == Admin) {
                win++;
            } else if (MAP[i][j] != Admin) {
                win = 0;
            }
            if (win == DOTS_TO_WIN) return true;
        }
        // проверка диагоналей "\"
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][i] == Admin) {
                win++;
            } else if (MAP[i][i] != Admin) {
                win = 0;
            }
            if (win == DOTS_TO_WIN) return true;
        }
        // проверка горизонтали "-"
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == Admin) {
                    win++;
                } else if (MAP[i][j] != Admin) {
                    win = 0;
                }
                if (win == DOTS_TO_WIN) return true;
            }
        }
        // проверка  вертикали "|"
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[j][i] == Admin) {
                    win++;
                } else if (MAP[j][i] != Admin) {
                    win = 0;
                }
                if (win == DOTS_TO_WIN) return true;
            }
        }
        for (int i = 1, j = 0; i < SIZE; i++, j++) {
            if (MAP[i][j] == Admin) {
                win++;
            } else if (MAP[i][j] != Admin) {
                win = 0;
            }
            if (win == DOTS_TO_WIN) return true;
        }
        // проверка второстепенных диагоналей
        for (int i = 0, j = 1; j < SIZE; i++, j++) {
            if (MAP[i][j] == Admin) {
                win++;
            } else if (MAP[i][j] != Admin) {
                win = 0;
            }
            if (win == DOTS_TO_WIN) return true;
        }

        for (int i = 0, j = (SIZE - 2); i < (SIZE - 1); i++, j--) {
            if (MAP[j][i] == Admin) {
                win++;
            } else if (MAP[j][i] != Admin) {
                win = 0;
            }
            if (win == DOTS_TO_WIN) return true;
        }

        for (int i = 1, j = (SIZE - 1); i < SIZE; i++, j--) {
            if (MAP[i][j] == Admin) {
                win++;
            } else if (MAP[i][j] != Admin) {
                win = 0;
            }
            if (win == DOTS_TO_WIN) return true;
        }

        return false;
    }
    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
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
        MAP[y][x] = DOT_X;
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
