package io.taig.android.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.widget.ScopeStealing;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.taig.android.floating_label_layout.R;

public class FloatingLabelLayout extends LinearLayout {
    private TextView hint;

    private TextView error;

    public FloatingLabelLayout( Context context ) {
        super( context );
    }

    public FloatingLabelLayout( Context context, @Nullable AttributeSet attributes ) {
        super( context, attributes );

        init( context, attributes, 0 );
    }

    @TargetApi( 11 )
    public FloatingLabelLayout( Context context, @Nullable AttributeSet attributes, int defStyleAttr ) {
        super( context, attributes, defStyleAttr );

        init( context, attributes, 0 );
    }

    @TargetApi( 21 )
    public FloatingLabelLayout( Context context, @Nullable AttributeSet attributes, int defStyleAttr, int defStyleRes ) {
        super( context, attributes, defStyleAttr, defStyleRes );

        init( context, attributes, defStyleAttr );
    }

    @SuppressWarnings( "deprecation" )
    protected void init( Context context, AttributeSet attributes, int defStyleAttr ) {
        EditText reference = new EditText( getContext() );

        setOrientation( VERTICAL );
        setPadding(
            reference.getLeft() + reference.getCompoundPaddingLeft(),
            0,
            reference.getRight() + reference.getCompoundPaddingRight(),
            0
        );

        hint = (TextView) LayoutInflater
            .from( context )
            .inflate( R.layout.floating_label_layout_hint, this, false );

        error = (TextView) LayoutInflater
            .from( context )
            .inflate( R.layout.floating_label_layout_error, this, false );

        TypedArray array = context.obtainStyledAttributes(
            attributes,
            R.styleable.TextInputLayout,
            defStyleAttr,
            R.style.Widget_Design_TextInputLayout
        );

        hint.setText( array.getString( R.styleable.TextInputLayout_android_hint ) );

        if( array.hasValue( R.styleable.TextInputLayout_android_textColorHint ) ) {
            hint.setTextColor( array.getColorStateList( R.styleable.TextInputLayout_android_textColorHint ) );
        }

        if( array.getResourceId( R.styleable.TextInputLayout_hintTextAppearance, -1 ) != -1 ) {
            setHintTextAppearance( array.getResourceId( R.styleable.TextInputLayout_hintTextAppearance, 0 ) );
        }

        final int errorAppearance = array.getResourceId( R.styleable.TextInputLayout_errorTextAppearance, 0 );

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {
            error.setTextAppearance( errorAppearance );
        } else {
            error.setTextAppearance( getContext(), errorAppearance );
        }

        error.setVisibility(
            array.getBoolean( R.styleable.TextInputLayout_errorEnabled, false ) ? VISIBLE : GONE
        );

        array.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        addView( hint, 0 );
        addView( error, getChildCount() );
    }

    public void setHint( @Nullable CharSequence hint ) {
        this.hint.setText( hint );
    }

    @Nullable
    public CharSequence getHint() {
        return hint.getText();
    }

    public void setHintTextAppearance( @StyleRes int resId ) {
        // TypedArray array = hint.getContext().obtainStyledAttributes( resId, R.styleable.TextAppearance );

        hint.setTextSize( TypedValue.COMPLEX_UNIT_SP, 12 );

        // array.recycle();
    }

    public void setTypeface( @Nullable Typeface typeface ) {
        hint.setTypeface( typeface );
    }

    public void setErrorEnabled( boolean enabled ) {
        error.setVisibility( enabled ? VISIBLE : INVISIBLE );
    }

    public boolean isErrorEnabled() {
        return error.getVisibility() == VISIBLE;
    }

    public void setError( @Nullable CharSequence error ) {
        if( !isErrorEnabled() && TextUtils.isEmpty( error ) ) {
            return;
        }

        if( !TextUtils.isEmpty( error ) ) {
            ViewCompat.setAlpha( this.error, 0f );
            setErrorEnabled( true );
            this.error.setText( error );

            ViewCompat
                .animate( this.error )
                .alpha( 1f )
                .setDuration( 200 )
                .setInterpolator( ScopeStealing.INTERPOLATOR )
                .start();
        }
        else {
            if( isErrorEnabled() ) {
                ViewCompat
                    .animate( this.error )
                    .alpha( 1f )
                    .setDuration( 200 )
                    .setInterpolator( ScopeStealing.INTERPOLATOR )
                    .setListener( new ViewPropertyAnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd( View view ) {
                            setErrorEnabled( false );
                        }
                    } )
                    .start();
            }
        }
    }

    @Nullable
    public CharSequence getError() {
        return isErrorEnabled() ? error.getText() : null;
    }
}