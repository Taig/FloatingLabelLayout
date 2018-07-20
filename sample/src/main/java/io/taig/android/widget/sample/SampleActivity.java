package io.taig.android.widget.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import io.taig.android.floating_label_layout.sample.R;
import io.taig.android.widget.FloatingLabelLayout;

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        
        setContentView( R.layout.main );

        final FloatingLabelLayout wrapper = findViewById( R.id.wrapper );
        View action1 = findViewById( R.id.action1 );
        action1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                wrapper.setError( "Something went wrong" );
            }
        } );
        View action2 = findViewById( R.id.action2 );
        action2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                wrapper.setError( null );
            }
        } );
    }
}