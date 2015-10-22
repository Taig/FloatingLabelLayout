package io.taig.android.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.taig.android.floating_label_layout.R;

public class FloatingLabelLayout extends LinearLayout {
    private TextView hint;

    private int padding;

    public FloatingLabelLayout( Context context ) {
        super( context );
    }

    public FloatingLabelLayout( Context context, @Nullable AttributeSet attributes ) {
        super( context, attributes );

        init( context, attributes );
    }

    @TargetApi( 11 )
    public FloatingLabelLayout( Context context, @Nullable AttributeSet attributes, int defStyleAttr ) {
        super( context, attributes, defStyleAttr );

        init( context, attributes );
    }

    @TargetApi( 21 )
    public FloatingLabelLayout( Context context, @Nullable AttributeSet attributes, int defStyleAttr, int defStyleRes ) {
        super( context, attributes, defStyleAttr, defStyleRes );

        init( context, attributes );
    }

    protected void init( Context context, AttributeSet attributes ) {
        setOrientation( VERTICAL );

        hint = (TextView) LayoutInflater
            .from( context )
            .inflate( R.layout.floating_label_layout_hint, this, false );

        addView( hint, 0 );

        TypedArray array = context.obtainStyledAttributes( attributes, R.styleable.TextInputLayout );

        hint.setText( array.getString( R.styleable.TextInputLayout_android_hint ) );

        if( array.hasValue( R.styleable.TextInputLayout_android_textColorHint ) ) {
            hint.setTextColor( array.getColorStateList( R.styleable.TextInputLayout_android_textColorHint ) );
        }

        if( array.getResourceId( R.styleable.TextInputLayout_hintTextAppearance, -1 ) != -1 ) {
            setHintTextAppearance( array.getResourceId( R.styleable.TextInputLayout_hintTextAppearance, 0 ) );
        }

        array.recycle();

        EditText reference = new EditText( getContext() );

        setPadding(
            reference.getLeft() + reference.getCompoundPaddingLeft(),
            0,
            reference.getRight() + reference.getCompoundPaddingRight(),
            0
        );
    }

    public void setHint( @Nullable CharSequence hint ) {
        this.hint.setText( hint );
    }

    @Nullable
    public CharSequence getHint() {
        return hint.getText();
    }

    public void setHintTextAppearance( @StyleRes int resId ) {
        TypedArray array = hint.getContext().obtainStyledAttributes( resId, R.styleable.TextAppearance );

        if( array.hasValue( R.styleable.TextAppearance_android_textColor ) ) {
            hint.setTextColor(
                array.getColor( R.styleable.TextAppearance_android_textColor, hint.getCurrentTextColor() )
            );
        }

        if( array.hasValue( R.styleable.TextAppearance_android_textSize ) ) {
            hint.setTextSize(
                array.getDimension( R.styleable.TextAppearance_android_textSize, hint.getTextSize() )
            );
        }

        array.recycle();
    }

    public void setTypeface( @Nullable Typeface typeface ) {
        hint.setTypeface( typeface );
    }
}