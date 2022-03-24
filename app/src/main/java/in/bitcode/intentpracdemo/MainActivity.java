package in.bitcode.intentpracdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView txtInfo;
    private EditText edtInfo;
    private Button btnNext;

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnNext.setOnClickListener(new BtnNextClickListener());
    }

    private class  BtnNextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, DataActivity.class);

            intent.putExtra(Constants.KEY_TITLE, edtInfo.getText().toString()) ;
            intent.putExtra(Constants.KEY_TYPE, 1);

            startActivityForResult(intent, 1);
        }
    }

    private void init(){
        txtInfo = findViewById(R.id.txtinfo);
        edtInfo = findViewById(R.id.edtinfo);
        btnNext = findViewById(R.id.btnNext);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }
        Bundle resultBundle = data.getExtras();
        result = resultBundle.getString(Constants.KEY_RESULT);
        txtInfo.setText(result + "req: " + requestCode + "res: " + resultCode);

    }
}