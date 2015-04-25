package com.main.CGOL;

//import android.appwidget.AppWidgetManager;
import sofia.graphics.Color;
import android.app.Activity;
import sofia.app.ShapeScreen;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;


/**
 * Extra imports for popup window
 */
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.view.ViewGroup.LayoutParams;

// -------------------------------------------------------------------------
/**
 *  Screen that gives the user options with respect to view and game style.
 *
 *  @author Bryan Kaperick (bryanjk)
 *  @author Parisa Samareh (psamareh)
 *  @author William Winter (wwinter)
 *  @version Apr 25, 2015
 */
public class SettingsScreen
    extends ShapeScreen
{

    private Button Dead;
    private Button liveColor;
    private Button returnToPrevious;

    private TextView settingsTitle;
    private TextView gridWidthLabel;
    private TextView gridHeightLabel;
    private TextView speedLabel;

    private EditText gridWidth;
    private EditText gridHeight;
    private EditText speed;

    public void initialize()
    {
        setBackgroundColor(Color.getRandomColor());
        int widgetIDs[] = AppWidgetManager.getInstance(getApplication());
    }

    public void DeadClicked(View view)
    {

    }

    public void liveColorClicked(View view)
    {
    }

    public void returnToPreviousClicked(View view)
    {
        finish();
    }

    public void gridWidthCompleted()
    {
        String newWidth = gridWidth.getText().toString();
    }

    public void gridHeightLabelCompleted()
    {
        String newHeight = gridHeight.getText().toString();
    }

    public void speedCompleted()
    {
        String newSpeed = speed.getText().toString();
    }

    private class ShowPopUp extends Activity
    {
        private PopupWindow popup;
        private LinearLayout layout;
        private LinearLayout mainLayout;
        private LayoutParams params;

        private TextView chooseColor;
        private Button red;
        private Button blue;
        private Button purple;
        private Button yellow;
        private Button white;
        private Button black;
        private Button grey;

        private boolean click = true;

        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            this.setContentView(activity_popup_screen.xml);
            popup = new PopupWindow(this);
            layout = new LinearLayout(this);
            mainLayout = new LinearLayout(this);
            chooseColor = new TextView(this);
            red.setBackgroundColor(Color.red);
            blue.setBackgroundColor(Color.blue);
            purple.setBackgroundColor(Color.purple);
            yellow.setBackgroundColor(Color.yellow);
            white.setBackgroundColor(Color.white);
            black.setBackgroundColor(Color.black);
            grey.setBackgroundColor(Color.grey);
        }
        
        public void greyClicked()
        {
            
        }


    }

}
