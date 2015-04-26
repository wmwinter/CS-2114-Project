package com.main.CGOL;

import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
/**
 *  The screen to create the title screen
 *
 *  @author Bill and Bryan and Parisa
 *  @version Apr 23, 2015
 */
public class TitleScreen
    extends ShapeScreen
{

    public void initialize()
    {
        setContentView(R.layout.activity_title_screen);
    }

    /**
     * Access to the settings screen
     */
    public void settingsClicked()
    {
        this.presentScreen(SettingsScreen.class);
    }
    /**
     * Access to the play screen
     */
    public void startClicked()
    {
        this.presentScreen(PlayScreen.class);
    }
    /**
     * Access to the play screen
     */
    public void savedClicked()
    {
        this.presentScreen(SavedScreen.class);
    }
}
