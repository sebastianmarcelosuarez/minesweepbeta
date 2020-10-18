package com.model;


import javax.validation.constraints.Size;

public class Board {
    Object gameBoard [][];

    @Size(min=2, max=6)
    public Board (int size){
        super();
        gameBoard = new Object [size][size];
        initializeBoard (gameBoard);
    }

    /**
     * Initializes the board, adding all needed settings to use it
     * @param gameBoard
     */
    private void initializeBoard(Object[][] gameBoard) {
        System.out.println("Initializing board with lenght " +gameBoard.length);

        // add boxes
        int maxMines = (gameBoard.length * 2) % 3;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                System.out.println("position: " +i+j);


                Box box = new Box();

                //reduce number of mines on board
                if (box.getMine() == Boolean.TRUE) maxMines--;
                //setting no mine when max mine number is zero
                if (maxMines <= 0) box.setMine(Boolean.FALSE);

                gameBoard[i][j] = box;

                System.out.println( "Position "+i+" "+j+" with mine; " + ((Box)(gameBoard[i][j])).getMine().toString());
            }
        }


    }


    public Object[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Object[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}

