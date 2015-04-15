package com.main.CGOL;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
/**
 * // -------------------------------------------------------------------------
/**
 *  Supports the characteristics and functionality of each individual cell
 *  location.
 *
 * @author Parisa Samareh
 * @author Bryan Kaperick
 * @author William Winter
 *  @version April 10, 2015
 */
public class CellLocation extends RectangleShape
{
    private boolean alive;
    /**
     * The constructor for the covertile
     *
     * @param left    the left of the tile
     * @param top    the top of the tile
     * @param right    the right of the tile
     * @param bottom    the bottom of the tile
     */
    public CellLocation(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        this.setFillColor(Color.white);
        alive = false;
    }

    /**
     * Makes this cell alive
     */
    public void setAlive()
    {
        this.alive = true;
    }

    /**
     * Returns whether or not this cell is alive
     *
     * @return boolean if the cell is alive
     */
    public boolean getAlive()
    {
        return this.alive;
    }
}
