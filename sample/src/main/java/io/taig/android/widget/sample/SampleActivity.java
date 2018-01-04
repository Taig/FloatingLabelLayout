package io.taig.android.widget.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import io.taig.android.floating_label_layout.sample.R;

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        
        setContentView( R.layout.main );
    }
}