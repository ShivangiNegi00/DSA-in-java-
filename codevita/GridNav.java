// package codevita;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GridNav {
    public static int[][] getnextCell(int moveX, int moveY){
        return new int[][]{
            {moveX,moveY},
            {moveY,-moveX}, // right 90 clockwise
            {-moveY,moveX}, // left 90 anticlockwise
            {-moveX,-moveY}  //back 180
        };
    }

    public static boolean isValidMove(int x, int y, int[][] grid, boolean[][] vis){
        int rows = grid.length;
        int cols = grid[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 0 && !vis[x][y];

    }
    public static int findMinCells(int[][] grid, int startX , int startY,int endX ,int endY, int moveX, int moveY){
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0}); // (x, y, steps)
        visited[startX][startY] = true;

        // Get the movement directions based on the move rule
        int[][] directions = getnextCell(moveX, moveY);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            System.out.println("x: "+x+" y: "+y+" steps: "+steps);
            // If we reach the destination, return the number of steps
            if (x == endX && y == endY) {
                return steps;
            }

            // Explore all four possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                 System.out.println("newX: "+newX+" newY: "+newY);
                if (isValidMove(newX, newY, grid, visited)) {
                    queue.add(new int[] {newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        // If the destination is unreachable, return -1
        return -1;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("gridTestcase.txt"));
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        //read the grid
        int[][] grid = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N;j++){
                grid[i][j]= scanner.nextInt();
            }
        }

        // Read source and destination coordinates
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();

        //Read  movement rule
        int moveX = scanner.nextInt();
        int moveY = scanner.nextInt();

        int result  =  findMinCells(grid, startX,startY,endX,endY,moveX,moveY);
        System.out.println(result);
    }
}
