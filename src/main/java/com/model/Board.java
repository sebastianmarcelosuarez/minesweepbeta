package com.model;


import javax.validation.constraints.Size;

public class Board {
    Object gameBoard[][];
    int mines = 0;

    @Size(min = 2, max = 6)
    public Board(int size) {
        super();
        gameBoard = new Object[size][size];
        initializeBoard(gameBoard);
    }

    /**
     * Initializes the board, adding all needed settings to use it
     *
     * @param gameBoard
     */
    private void initializeBoard(Object[][] gameBoard) {
        System.out.println("Initializing board with length " + gameBoard.length);

        // add boxes
        // int maxMines = (gameBoard.length * 2) % 3;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                System.out.println("position: " + i + j);
                Box box = new Box();

                //count number of mines on board
                if (box.getMine() == Boolean.TRUE) {
                    this.mines++;
                }
                //setting no mine when mines on board surpass calculation
                if ((this.mines) > ((gameBoard.length * 2) / 3) + 1) box.setMine(Boolean.FALSE);

                gameBoard[i][j] = box;

                System.out.println("Position " + i + " " + j + " with mine; " + (box.getMine().toString()));
                System.out.println("");
            }
        }

        // set mines number around each box
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                ((Box) gameBoard[i][j]).setMinesAround(calculateMinesAround(i, j, gameBoard.length));

            }
        }
    }

    /**
     * calculates mines around a box
     *
     * @param i
     * @param j
     * @return
     */
    private int calculateMinesAround(int i, int j, int length) {

        int count = 0;
        // look for valid positions --
        if ((i - 1 >= 0) && (j-1 >= 0 )){
            if (((Box) gameBoard[i-1][j-1]).getMine().booleanValue()) count ++;
        }
        // look for valid positions = -
        if ((i >= 0) && (j-1 >= 0 )){
            if (((Box) gameBoard[i][j-1]).getMine().booleanValue()) count ++;
        }
        // look for valid positions + -
        if ((i +1 < length) && (j-1 >= 0 )){
            if (((Box) gameBoard[i+1][j-1]).getMine().booleanValue()) count ++;
        }
        // look for valid positions - =
        if ((i - 1 >= 0) && (j >= 0 )){
            if (((Box) gameBoard[i-1][j]).getMine().booleanValue()) count ++;
        }
        // look for valid positions + =
        if ((i + 1 < length) && (j >= 0 )){
            if (((Box) gameBoard[i+1][j]).getMine().booleanValue()) count ++;
        }
        // look for valid positions - +
        if ((i - 1 >= 0) && (j + 1 < length )){
            if (((Box) gameBoard[i-1][j+1]).getMine().booleanValue()) count ++;
        }
        // look for valid positions = +
        if ((i >= 0) && (j + 1 < length)){
            System.out.println("posi "+i+" posj "+j);
            if (((Box) gameBoard[i][j+1]).getMine().booleanValue()) count ++;
        }
        // look for valid positions + +
        if ((i + 1 < length) && (j + 1 < length )){
            if (((Box) gameBoard[i+1][j+1]).getMine().booleanValue()) count ++;
        }
            return count;
    }



    /**
     * Prints mines on board
     */
    public void printMines (){
        System.out.println("Printing mines on Board");
        System.out.println("");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                String result ;
                if ( ((Box) (this.gameBoard[i][j])).getMine().booleanValue() == Boolean.TRUE)  result ="x"; else result = " ";
                System.out.print("[" +result+"]");
            }
            System.out.println();
        }
        System.out.println();
        printAroundMines();
    }

    /**
     * Prints the number of mines around the box
     */
    public void printAroundMines (){
        System.out.println("Printing number of mines around the box");
        System.out.println("");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                int result =  ( (Box) (this.gameBoard[i][j])).getMinesAround();

                System.out.print("[" +result+"]");
            }
            System.out.println();
        }
        System.out.println();
    }


    public Object[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Object[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}

