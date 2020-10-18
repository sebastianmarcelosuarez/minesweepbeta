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

    private void initializeBoard(Object[][] gameBoard) {



    }


    public Object[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Object[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}

