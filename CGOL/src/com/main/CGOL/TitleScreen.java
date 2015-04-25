package com.main.CGOL;

import sofia.app.ShapeScreen;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.title_screen, menu);
        return true;
    }
    @Override
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
