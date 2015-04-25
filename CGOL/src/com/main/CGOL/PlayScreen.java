package com.main.CGOL;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import android.view.Display;
import sofia.graphics.RectangleShape;

/**
 * // -------------------------------------------------------------------------
/**
 *  The GUI screen where the game is played
 *
 *  @author Parisa
 *  @version Apr 18, 2015
 */
public class PlayScreen
    extends ShapeScreen
{
    private float        gridWidth;
    private float        gridHeight;
    private GridOfCells  grid;
    private float        cellSize;

    /**
     * The initialize method sets up the grid.
     * @param x     horizontal dimension of play area
     * @param y     vertical dimension of play area
     */
    public void initialize(int x, int y)
    {
        gridWidth = this.getWidth();
        gridHeight = this.getHeight();
        grid = new GridOfCells(x, y);
        cellSize = (Math.min(gridWidth, gridHeight) / Math.max(x, y));
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                RectangleShape cell =
                    new RectangleShape(
                        i * cellSize,
                        j * cellSize,
                        (i + 1) * cellSize,
                        (j + 1) * cellSize);
                this.add(cell);
            }
        }
    }

    /**
     * Method for when the user wants to go to the settings page
     */
    public void settingsClicked()
    {
        Intent intent = new Intent(this, SettingsScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    /**
     * Processes the user's touch
     *
     * @param x the x coord
     * @param y the y coord
     */
    public void processTouch(float x, float y)
    {
        int actualX = (int)(x / cellSize);
        int actualY = (int)(y / cellSize);
        RectangleShape tile =
            getShapes().locatedAt(x, y).withClass(RectangleShape.class).front();
        tile.setFillColor(Color.black);
        if (grid.getCell(actualX, actualY).getAlive())
        {
            tile.setFillColor(Color.white);
            grid.getCell(actualX, actualY).setDead();
        }
        else
        {
            tile.setFillColor(Color.black);
            grid.getCell(actualX, actualY).setAlive();
        }
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

}
