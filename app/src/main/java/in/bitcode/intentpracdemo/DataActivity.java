package in.bitcode.intentpracdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {

    private String title;
    private int type;

    private TextView txtData;
    private EditText edtData;
    private Button btnSetAndFinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);

        Intent intent = getIntent();

        Bundle input = intent.getExtras();
        title = input.getString(Constants.KEY_TITLE, " Not Availabele");
        type = input.getInt(Constants.KEY_TYPE, -1);

        mt(title + " " + type);
        Log.e("tag", title + " " + type);

        btnSetAndFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(Constants.KEY_RESULT, edtData.getText().toString());

                setResult(1, resultIntent);
                finish();

            }
        });
    }

    private void init() {
        txtData = findViewById(R.id.txtData);
        edtData = findViewById(R.id.edtData);
        btnSetAndFinish = findViewById(R.id.btnsetAndFinish);
    }

    private  void mt(String text) {
        Toast.makeText(this, text , Toast.LENGTH_LONG).show();}


    }


