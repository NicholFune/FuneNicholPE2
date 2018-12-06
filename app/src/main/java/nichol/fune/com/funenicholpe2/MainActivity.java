package nichol.fune.com.funenicholpe2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText fullname, age, gender;
    TextView fname, years, sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fullname = findViewById(R.id.editText);
        age = findViewById(R.id.editText2);
        gender = findViewById(R.id.editText3);
        fname = findViewById(R.id.textView);
        years = findViewById(R.id.textView2);
        sex = findViewById(R.id.textView3);
    }

    public void save(View v) {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "External.txt");
        String name = fullname.getText().toString();
        String agenum = age.getText().toString();
        String gender1 = gender.getText().toString();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(name.getBytes());
            fos.write(agenum.getBytes());
            fos.write(gender1.getBytes());
            Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error saving, try again.", Toast.LENGTH_LONG).show();
        }
    }

    public void display(View v) {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "External.txt");
        String name = fullname.getText().toString();
        String agenum = age.getText().toString();
        String gender1 = gender.getText().toString();

        FileInputStream fis = null;
        int c;
        StringBuffer buffer = new StringBuffer();
        try {
            fis = new FileInputStream(file);
            while ((c = fis.read()) != -1) {
                buffer.append((char) c);
            }
            fname.setText(name);
            years.setText(agenum);
            sex.setText(gender1);
        } catch (Exception e) {
            Toast.makeText(this, "Error processing data, try again.", Toast.LENGTH_LONG).show();
        }
    }
}
