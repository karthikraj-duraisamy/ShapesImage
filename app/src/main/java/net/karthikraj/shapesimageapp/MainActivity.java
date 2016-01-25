package net.karthikraj.shapesimageapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.karthikraj.shapesimage.ShapesImage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.list_all);

        /*
                List all available shapes by looping through an array
        */

        TextView textView = new TextView(MainActivity.this);
        textView.setText("Available Pre-defined Shapes");
        textView.setTextSize(15.0f);
        textView.setGravity(Gravity.CENTER);
        linearLayout.addView(textView);

        for (int i = 1; i <= 47; i++){

            ShapesImage shapesImage = new ShapesImage(MainActivity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
            layoutParams.setMargins(5,5,5,5);
            shapesImage.setLayoutParams(layoutParams);
            shapesImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            shapesImage.setImageResource(R.drawable.cat);
            shapesImage.setShapeDrawable(i);
            linearLayout.addView(shapesImage);
        }

        /*
                Available shape implementation through XML
        */
        textView = new TextView(MainActivity.this);
        textView.setText("Through XML - Pre-defined Shapes");
        textView.setTextSize(15.0f);
        textView.setGravity(Gravity.CENTER);
        linearLayout.addView(textView);


        LayoutInflater layoutInflater =LayoutInflater.from(this);
        ShapesImage shapesImage = (ShapesImage) layoutInflater.inflate(
                R.layout.available_shape, linearLayout, false);
        linearLayout.addView(shapesImage);
        /*
                Available shape implementation through JAVA
        */
        textView = new TextView(MainActivity.this);
        textView.setText("Through JAVA - Pre-defined Shapes");
        textView.setTextSize(15.0f);
        textView.setGravity(Gravity.CENTER);
        linearLayout.addView(textView);

        shapesImage = new ShapesImage(MainActivity.this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(150, 150);
        shapesImage.setLayoutParams(layoutParams);
        shapesImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        shapesImage.setImageResource(R.drawable.cat);
        shapesImage.setShapeDrawable(ShapesImage.ANDROID);
        linearLayout.addView(shapesImage);
        /*
                Custom served shape implementation through XML
        */
        textView = new TextView(MainActivity.this);
        textView.setText("Through XML - Custom served/own drawable Shapes");
        textView.setTextSize(15.0f);
        textView.setGravity(Gravity.CENTER);
        linearLayout.addView(textView);

        shapesImage = (ShapesImage) layoutInflater.inflate(
                R.layout.custom_shape, linearLayout, false);
        linearLayout.addView(shapesImage);
        /*
                Available shape implementation through XML
        */
        textView = new TextView(MainActivity.this);
        textView.setText("Through JAVA - Custom served/own drawable Shapes");
        textView.setTextSize(15.0f);
        textView.setGravity(Gravity.CENTER);
        linearLayout.addView(textView);

        shapesImage = new ShapesImage(MainActivity.this);
        shapesImage.setLayoutParams(layoutParams);
        shapesImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        shapesImage.setImageResource(R.drawable.cat);
        shapesImage.setShapeDrawable(getResources().getDrawable(R.drawable.custom_shape));
        linearLayout.addView(shapesImage);
    }
}
