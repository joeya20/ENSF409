/**
 * @author  Joey Ah-kiow 
 * <a href="joey.ah-kiow@ucalgary.ca">joey.ah-kiow@ucalgary.ca</a>
 * @since 1.0
 * @version 1.0
 */

public class EightQueens implements Cloneable {
    
    private final int boardDimension = 8;
    private final int maxNumberOfQueens = 8;
    private char[][] chessboard;
    private int currentNumberOfQueens;

    public Object clone() throws
        CloneNotSupportedException
    {
        EightQueens copy = (EightQueens)super.clone();

        copy.chessboard = new char[this.chessboard.length][this.chessboard.length];

        for (int i = 0; i < this.chessboard.length; i++) 
        {
            copy.chessboard[i] = this.chessboard[i].clone();
        }

        return copy;
    }

    public EightQueens()
    {
        chessboard = new char[boardDimension][boardDimension];

        for(int i = 0; i < chessboard.length; i++)
        {
            for(int j = 0; j < chessboard[i].length; j++)
            {
                chessboard[i][j] = 'o';
            }
        }
        currentNumberOfQueens = 0;
    }

    public char[][] getBoard()
    {
        return this.chessboard;
    }

    public void emptySquare(int row, int column) 
    {
        if(chessboard[row][column] == 'Q')
        {
            chessboard[row][column] = 'o';
            currentNumberOfQueens--;
        }
    }
    
    public void setQueen(int row, int column)
    {
        if(currentNumberOfQueens < maxNumberOfQueens)
        {
            if(chessboard[row][column] == 'o')
            {
                chessboard[row][column] = 'Q';
                currentNumberOfQueens++;
            }
        }
    }

    public boolean setQueens(int queensRemaining)
    {
        if(queensRemaining > maxNumberOfQueens)
        {
            throw new IllegalArgumentException();
        }
        else if(queensRemaining >
            maxNumberOfQueens - currentNumberOfQueens)
        {
            return false;
        }
        else if(checkCurrentBoard() == false)
        {
            return false;
        }
        else if(recursiveSetQueens(queensRemaining) == false)
        {
            return false;
        }
        else
        {
            currentNumberOfQueens += queensRemaining;
            return true;
        }
    }

    private boolean recursiveSetQueens(int numOfQueensToPlace)
    {
        if(numOfQueensToPlace == 0)
        {
            return true;
        }

        for(int i = 0; i < boardDimension; i++)
        {
            for (int j = 0; j < boardDimension; j++) 
            {
                if(isPositionPossible(i, j))
                {
                    chessboard[i][j] = 'Q';

                    if (recursiveSetQueens(numOfQueensToPlace-1) == true)
                    {
                        return true; 
                    }

                    chessboard[i][j] = 'o';
                }
            }
        }
        return false;
    }

    private boolean checkCurrentBoard()
    {
        for(int i = 0; i < boardDimension; i++)
        {
            for (int j = 0; j < boardDimension; j++) 
            {
                if(chessboard[i][j] == 'Q')
                {
                    chessboard[i][j] = 'o';

                    if(isPositionPossible(i, j) == false)
                    {
                        chessboard[i][j] = 'Q';
                        return false;
                    }

                    chessboard[i][j] = 'Q';
                }
            }
        }
        return true;
    }

    private boolean isPositionPossible(int row, int column){

        for(int i = 0; i < boardDimension; i++)
        {
            if(chessboard[i][column] == 'Q')
            {
                return false;
            }
            if(chessboard[row][i] == 'Q')
            {
                return false;
            }
            if(row - i >= 0)
            {
                if(column - i >= 0)
                {
                    if(chessboard[row-i][column-i] == 'Q')
                    {
                        return false;
                    }
                }
                if(column + i < boardDimension)
                {
                    if(chessboard[row-i][column+i] == 'Q')
                    {
                        return false;
                    }
                }
            }
            if(row + i < boardDimension)
            {
                if(column - i >= 0)
                {
                    if(chessboard[row+i][column-i] == 'Q')
                    {
                        return false;
                    }
                }
                if(column + i < boardDimension)
                {
                    if(chessboard[row+i][column+i] == 'Q')
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}