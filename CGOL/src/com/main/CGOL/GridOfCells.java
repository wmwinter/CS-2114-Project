package com.main.CGOL;

import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;

/**
 * // -------------------------------------------------------------------------
 * /** Our class for the main game screen.
 * We still intend to implement multiple activity functionality to support
 * a title screen, settings screen and gameplay screen.
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 * @version April 10, 2015
 */
public class GridOfCells
    extends ShapeScreen
{
    private CellLocation[][] grid;
    private float            cellSize;
    private int gridWidth;
    private int gridHeight;


    /**
     * The initialize method sets up the grid.
     * @param x     horizontal dimension of play area
     * @param y     vertical dimension of play area
     */
    public GridOfCells(int x, int y)
    {

    }

    /**
     * Returns the height of the total grid.
     * @return height field value.
     */
    public int getHeight()
    {
        return gridHeight;
    }

    /**
     * Returns the width of the total grid.
     * @return width field value.
     */
    public int getWidth()
    {
        return gridWidth;
    }


    /**
     * Gets the status of the cell's neighbors
     *
     * @param x coordinate of the cell
     * @param y coordinate of the cell
     * @return the number of neighbors
     */
    public int getNeighbors(int x, int y)
    {
        int neighs = 0;
        for (int i = x - 1; i < x + 2; i++)
        {
            for (int j = y - 1; j < y + 2; j++)
            {
                if (this.getCell(i, j).getAlive())
                {
                    neighs++;
                }
            }
        }
        return neighs;
        // Method to get the current amount of live cells out of the
        // 8 neighboring cells.
    }


    /**
     * Returns the specified cell
     *
     * @return cell the cell we want
     * @param x the coordinate for the cell we want
     * @param y the coordinate for the cell we want
     */
    public CellLocation getCell(int x, int y)
    {
        return grid[x][y];
    }


    /**
     * Processes the user's touch
     *
     * @param x the x coord
     * @param y the y coord
     */
    public void processTouch(float x, float y)
    {
        //not finished
        RectangleShape tile =
            getShapes().locatedAt(x, y).withClass(RectangleShape.class).front();
        tile.setFillColor(Color.black);
        int actualX = (int)(x / cellSize);
        int actualY = (int)(y / cellSize);
        this.getCell(actualX, actualY).setAlive();
    }


    /**
     * Toggles the cell state when a cell is touched.
     *
     * @param x the x-coordinate for the picture
     * @param y the y-coordinate for the picture
     */
    public void onTouchDown(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Toggles the cell state with the swipe of a finger.
     *
     * @param x the x-coordinate for the picture
     * @param y the y-coordinate for the picture
     */
    public void onTouchMove(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Runs the program
     *
     * @param x coordinate of the cell
     * @param y coordinate of the cell
     */
    public void isAlive(int x, int y)
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (this.getNeighbors(x, y) == 2
                    || this.getNeighbors(x, y) == 3)
                {
                    this.processTouch(i * cellSize, y * cellSize);
                }
            }
        }
    }

}

