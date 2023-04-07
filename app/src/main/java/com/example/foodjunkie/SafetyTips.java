package com.example.foodjunkie;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class SafetyTips extends AppCompatActivity {
    //private Button home3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_tips);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        }

//home3 = findViewById(R.id.btn_home3);
/* home3.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {
Intent intent = new Intent(SafetyTips.this,

TandTFragment.class);

startActivity(intent);
}
});*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // navigate back to the previous fragment
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}