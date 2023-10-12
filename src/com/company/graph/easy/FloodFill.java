package com.company.graph.easy;
/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 *
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 *
 * Example 2:
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
 * Output: [[0,0,0],[0,0,0]]
 *
 * */
public class FloodFill {

    public static int[][] floodfill(int[][] image, int sr, int sc, int newColor){
        int oldColor = image[sr][sc];
        if(oldColor != newColor)
            dfs(image,sr,sc,oldColor,newColor);

        return image;
    }

    public static void dfs(int[][] image, int r, int c, int color, int newColor){
        if(image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }

    public static void main(String[] args){
        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1,sc = 1, color = 2;
        int[][] newImage =floodfill(image,sr,sc,color);
        System.out.println("The output is  :");
        for(int i =0; i< newImage.length;i++){
            for(int j = 0; j<newImage[i].length;j++){
                System.out.print(newImage[i][j]+" | ");
            }
            System.out.println();
        }
    }
}
