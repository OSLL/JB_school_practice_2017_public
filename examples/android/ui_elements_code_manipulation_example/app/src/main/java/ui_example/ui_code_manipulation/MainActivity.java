package ui_example.ui_code_manipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final String tag = "ui_elements";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edittext = (EditText)findViewById(R.id.editText);
        Log.d(tag, "EditText = " + edittext.getText());

        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);
        Log.d(tag, "checkbox = " + checkbox.isChecked());


        Button button = (Button)findViewById(R.id.button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) findViewById(R.id.button);
                button.setText("1111111");
            }
        };

        button.setOnClickListener(listener);



    }


}
