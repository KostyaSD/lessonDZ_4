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
    }

    private static void initMap() {
        MAP = new char[SIZE][SIZE];
    }


}
