package com.example.taruc.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //key for saving the state of Textview
    private static final String TEXT_STATE = "currentText";

    // the TextView where we will show results
    private TextView mTextView;

    /**
     * initializes the activity
     * @param savedInstanceState the current state data
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize mTextView
        mTextView = findViewById(R.id.textView1);

        // Restore TextView if there is a savedInstanceState
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    /**
     * handles the onClick for the "Start Task" button. Launches the Async Task
     * which performs work off of the UI thread
     *
     * @param view The view (Button) that was clicked
     */

    public void startTask(View view) {
        // put a message in the text view
        mTextView.setText(R.string.napping);

        // start the AsyncTask
        // the AsyncTask has a callback that will update the text view.
        new SimpleAsyncTask(mTextView).execute();
    }


    /**
     * saves the contents of the TextView to restore on configuration change.
     * @param outState The bundle in which the state of the activity is saved
     * when it is spontaneously destroyed
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE,
                mTextView.getText().toString());


    }
}

