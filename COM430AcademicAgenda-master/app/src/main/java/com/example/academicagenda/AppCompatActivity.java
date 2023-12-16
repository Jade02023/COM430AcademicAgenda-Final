package com.example.academicagenda;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public abstract class AppCompatActivity {
    protected int contentView;

    protected void onCreate(Bundle savedInstanceState) {
    }

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public abstract boolean onOptionsItemSelected(MenuItem item);
}
