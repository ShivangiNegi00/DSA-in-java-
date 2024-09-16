import java.util.*;

public class BackTrack {

    public boolean isSafe(int row, int col,char[][] board){
         
        //    horizontal check 
        for(int i=0;i<board.length;i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        // vertical check
        for(int i=0;i<board.length;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // diagonally check
        // upper left 
        int r = row;
        for(int c=col; c>=0 && r>=0 ; c-- , r--){
            if(board[c][r] == 'Q'){
                return false;
            }
        }

        // lower left
         r = row;
        for(int c=col; c>=0 && r<board.length; c-- , r++){
            if(board[c][r] == 'Q'){
                return false;
            }
        }

        // lower right
         r = row;
        for(int c=col; c<board.length && r<board.length ; c++ , r++){
            if(board[c][r] == 'Q'){
                return false;
            }
        } 

        // upper right
        r = row;
        for(int c=col; c<board.length && r>=0 ; c++ , r--){
            if(board[c][r] == 'Q'){
                return false;
            }
        } 
        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards){
        String row = "";
        List<String> finBoard = new ArrayList<>();

         for(int i=0; i<board.length; i++){
            row="";
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='Q'){
                    row += 'Q';
                }
                else
                   row += '.';
            }
            finBoard.add(row);
         }

         allBoards.add(finBoard);
    }
    public void helper(char[][] board, List<List<String>> allBoards, int col){
       if (col== board.length){
        saveBoard(board,allBoards);
        return;
       }
        // placing the queens 
        for(int row=0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col+1);
                // removing the queen from the palce if later on we cant find solution hence have to backtrack 
                board[row][col] = '.';
            }

        }
    }

    public List<List<String>> SolveQueens(int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board,allBoards,0);
        return allBoards;
    }


    public static void main(String args[]){
        int n = 4;
        BackTrack backTrack = new BackTrack();
       System.out.println(backTrack.SolveQueens(n)) ;
        
    }
}
