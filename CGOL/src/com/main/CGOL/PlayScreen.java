package com.main.CGOL;

import android.view.Display;
import sofia.graphics.RectangleShape;
import android.app.Activity;

public class PlayScreen
    extends Activity
{
    private int          gridXnum;
    private int          gridYnum;
    private int          gridWidth;
    private int          gridHeight;
    private CellLocation[][] grid;
    private int          cellSize;
    private Display display;
    int metrics;

    /**
     * The initialize method sets up the grid.
     * @param x     horizontal dimension of play area
     * @param y     vertical dimension of play area
     */
    public void initialize(int x, int y)
    {
        gridWidth = this.getResources().getDisplayMetrics().widthPixels;
        gridHeight = this.getResources().getDisplayMetrics().heightPixels;
        gridXnum = x;
        gridYnum = y;
        grid = new CellLocation[x][y];
        cellSize = (Math.min(gridWidth, gridHeight) / Math.max(x, y));
        float cellWidth = (this.getWidth() / x);
        float height = (this.getHeight() / y);
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                RectangleShape cell =
                    new RectangleShape(
                        i * width,
                        j * height,
                        (i + 1) * width,
                        (j + 1) * height);
                this.add(cell);
            }
        }
        dim = size;
        cell = new MazeCell[size][size];
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                cell[x][y] = MazeCell.UNEXPLORED;
            }
        }
        ILocation initialStart = new Location(0, 0);
        setStartLocation(initialStart);
        ILocation initialGoal = new Location(size - 1, size - 1);
        setGoalLocation(initialGoal);
    }

}
