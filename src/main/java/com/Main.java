package com;

import com.model.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Board board = new Board(3);
        //board.printMines();

        Boolean exit = Boolean.FALSE;
        String pos_i = null;
        String pos_j = null;
        String userSelection = null;

        while (!exit) {

            Boolean validRange = Boolean.FALSE;

            while (!validRange) {
                validRange = Boolean.TRUE;
                System.out.println("Select position I");
                pos_i = reader.readLine();
                System.out.println("Select position J");
                pos_j = reader.readLine();
                System.out.println("Position I Selected: " + pos_i);
                System.out.println("Position J Selected: " + pos_j);

                if ((Integer.valueOf(pos_i) < 0) || (Integer.valueOf(pos_i) >= board.getGameBoard().length)) {
                    int boardLength = board.getGameBoard().length;
                    System.out.println("");
                    System.out.println("Position I incorrect, please select a range between 0 and " + --boardLength);
                    validRange = Boolean.FALSE;
                }
                if ((Integer.valueOf(pos_j) < 0) || (Integer.valueOf(pos_j) >= board.getGameBoard().length)) {
                    int boardLength = board.getGameBoard().length;
                    System.out.println("");
                    System.out.println("Position J incorrect, please select a range between 0 and " + --boardLength);
                    validRange = Boolean.FALSE;
                }

            }

            System.out.println("");
            System.out.println("On Position " + pos_i + " " +pos_j) ;
            System.out.println("Select Action");
            System.out.println("1: click");
            System.out.println("2: flag/unflag");
            System.out.println("3: select another position");
            System.out.println("");
            userSelection = reader.readLine();

           if (userSelection.compareToIgnoreCase("1") == 0){
               exit = board.click( Integer.parseInt(pos_i),Integer.parseInt(pos_j));

           }

        }

    }
}



