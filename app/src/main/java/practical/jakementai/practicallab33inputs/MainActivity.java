package practical.jakementai.practicallab33inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale, radioButtonBoth;
    private CheckBox checkBoxSmocker;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get all the good stuff
        spinnerAge = findViewById(R.id.ageSpinner);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonGender1);
        radioButtonFemale = findViewById(R.id.radioButtonGender2);
        radioButtonBoth = findViewById(R.id.radioButtonGender3);
        checkBoxSmocker = findViewById(R.id.checkBoxSmoker);
        textViewResult = findViewById(R.id.textViewResult);


        ArrayAdapter<CharSequence> strAdapter =
        ArrayAdapter.createFromResource(
                this, R.array.age_group, android.R.layout.simple_spinner_item);

        strAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(strAdapter);
        spinnerAge.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //Make a toast, mmmm
        Toast.makeText(this,"Position = " + position,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos = spinnerAge.getSelectedItemPosition();
        float premium = 0;
        int gender = radioGroupGender.getCheckedRadioButtonId();


        switch (pos) {
            case 0:
                premium = 50;
                break;
            case 1:
                premium = 55;
                break;
            case 2:
                premium = 60;
                if(radioGroupGender.getCheckedRadioButtonId() == radioButtonMale.getId()){
                    premium += 50;
                }
                break;

            case 3:
                premium = 70;
                if(radioGroupGender.getCheckedRadioButtonId() == radioButtonMale.getId()){
                    premium += 100;
                }

                if(checkBoxSmocker.isChecked()){
                    premium +=100;
                }
                break;
            case 4:
                premium = 120;
                if(radioGroupGender.getCheckedRadioButtonId() == radioButtonMale.getId()){
                    premium += 100;
                }

                if(checkBoxSmocker.isChecked()){
                    premium +=150;
                }
                break;
            case 5:
                premium = 160;
                if(radioGroupGender.getCheckedRadioButtonId() == radioButtonMale.getId()){
                    premium += 50;
                }

                if(checkBoxSmocker.isChecked()){
                    premium +=150;
                }
                break;
            case 6:
                premium = 200;

                if(checkBoxSmocker.isChecked()){
                    premium +=250;
                }
                break;

            case 7:
                premium = 250;

                if(checkBoxSmocker.isChecked()){
                    premium +=250;
                }
                break;
        }


        textViewResult.setText("Your Premium is RM" + String.format("%.2f",premium));
    }

    public void resetButton(View view){
        textViewResult.setText("");
        radioGroupGender.clearCheck();
        checkBoxSmocker.setChecked(false);
        spinnerAge.setSelection(0,true);

        //Make a toast, mmmm
        Toast.makeText(this,"Reset is done!",
                Toast.LENGTH_SHORT).show();

    }
}
