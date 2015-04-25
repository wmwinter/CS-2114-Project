package com.main.CGOL;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    private GridOfCells  grid;
    private float        cellSize;
    private Color        live;
    private Color        dead;

    /**
     * The initialize method sets up the grid.
     */
    public void initialize()
    {
        live = Color.white;
        dead = Color.darkGray;
        gridWidth = this.getWidth();
        gridHeight = this.getHeight();
        grid = new GridOfCells(20, 40);
        cellSize = (Math.min(gridWidth, gridHeight) / 20);
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
                this.add(cell);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.title_screen, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        if (grid.getCell(actualX, actualY).getAlive())
        {
            tile.setFillColor(dead);
            grid.getCell(actualX, actualY).setDead();
        }
        else
        {
            tile.setFillColor(live);
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
