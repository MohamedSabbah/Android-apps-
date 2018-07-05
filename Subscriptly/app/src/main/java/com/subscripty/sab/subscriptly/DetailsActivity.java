package com.subscripty.sab.subscriptly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        view1 = findViewById(R.id.veiw);
        view1.setText(getIntent().getStringExtra("name"));
    }
}
