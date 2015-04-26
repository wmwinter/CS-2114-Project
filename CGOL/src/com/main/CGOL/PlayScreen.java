package com.main.CGOL;
import android.widget.RelativeLayout;
import android.widget.Button;
import sofia.graphics.ShapeView;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;
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
    private GridOfCells  theGrid;
    private float        cellSize;
    private Color        live;
    private Color        dead;
    private ShapeView     grid;
    private Button settings;
    private Button playPause;
    private Button step;

    public void initialize()
    {
        live = Color.white;
        dead = Color.darkGray;
        gridWidth = this.getWidth();
        gridHeight = this.getHeight();
        theGrid = new GridOfCells(20, 25);
        cellSize = (Math.min(gridWidth, gridHeight) / 20);
        RelativeLayout layout = new RelativeLayout(this);
//        RelativeLayout relative = (RelativeLayout) findViewById(R.layout.activity_play_screen);
        grid.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
            (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                RectangleShape cell =
                    new RectangleShape(
                        i * cellSize,
                        j * cellSize,
                        (i + 1) * cellSize,
                        (j + 1) * cellSize);
                cell.setColor(Color.black);
                cell.setFillColor(dead);
                this.addContentView(grid, params);
            }
        }
        layout.addView(grid);
        layout.addView(playPause);
        layout.addView(step);
        layout.addView(settings);

//        screenSize = new ViewGroup.LayoutParams(R.layout.activity_play_screen, R.layout.activity_play_screen);
    }

    /**
     * Sets the live cell color
     *
     * @param userColor The color the user wants the live cells to be
     */
    public void setLiveColor(Color userColor)
    {
        live = userColor;
    }

    /**
     * Sets the dead cell color
     *
     * @param userColor The color the user wants the dead cells to be
     */
    public void setDeadColor(Color userColor)
    {
        dead = userColor;
    }

    /**
     * Method for when the user wants to go to the settings page
     */
    public void settingsPlayClicked()
    {
        this.presentScreen(SettingsScreen.class);
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
        if (theGrid.getCell(actualX, actualY).getAlive())
        {
            tile.setFillColor(dead);
            theGrid.getCell(actualX, actualY).setDead();
        }
        else
        {
            tile.setFillColor(live);
            theGrid.getCell(actualX, actualY).setAlive();
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
