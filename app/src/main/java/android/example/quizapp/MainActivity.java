package android.example.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String Q3_ANSWER = "yearly";
    final String Q4_ANSWER = "persian";
    final int Q5_ANSWER = R.id.question_5_first_radio;
    final int Q6_ANSWER = R.id.question_6_first_radio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void checkQuiz(View v) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();

        int numberOfQuestionsCorrect = 0;

        if (checkQuestion1()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 1" );
        }

        if (checkQuestion2()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 2" );
        }

        if (checkQuestion3()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 3" );
        }

        if (checkQuestion4()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 4" );
        }

        if (checkQuestion5()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 5" );
        }

        if (checkQuestion6()) {
            numberOfQuestionsCorrect++;
        } else {
            incorrectAnswersList.add( "Question 6" );
        }
        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append( s );
            sb.append( "\n" );
        }
        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfQuestionsCorrect + "/6 answers right.\n\nRecheck the following:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( context, text, duration );
        toast.show();
    }

    private boolean checkQuestion1() {
        CheckBox c1 = (CheckBox) findViewById( R.id.question_1_first_checkbox );
        CheckBox c2 = (CheckBox) findViewById( R.id.question_1_second_checkbox );
        CheckBox c3 = (CheckBox) findViewById( R.id.question_1_third_checkbox );
        CheckBox c4 = (CheckBox) findViewById( R.id.question_1_fourth_checkbox );

        if (c1.isChecked() && c2.isChecked() && c3.isChecked() && c4.isChecked()) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion2() {
        CheckBox c1 = (CheckBox) findViewById( R.id.question_2_first_checkbox );
        CheckBox c2 = (CheckBox) findViewById( R.id.question_2_second_checkbox );
        CheckBox c3 = (CheckBox) findViewById( R.id.question_2_third_checkbox );
        CheckBox c4 = (CheckBox) findViewById( R.id.question_2_fourth_checkbox );

        if (c1.isChecked() && c3.isChecked() && c4.isChecked() && !c2.isChecked()) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion3() {
        EditText et = findViewById( R.id.question_3_edit_text );

        return et.getText().toString().equalsIgnoreCase( Q3_ANSWER );
    }

    private boolean checkQuestion4() {
        EditText et = findViewById( R.id.question_4_edit_text );

        return et.getText().toString().equalsIgnoreCase( Q4_ANSWER );
    }

    private boolean checkQuestion5() {
        RadioGroup rg = findViewById( R.id.question_5_radio_group );

        return rg.getCheckedRadioButtonId() == Q5_ANSWER;

    }

    private boolean checkQuestion6() {
        RadioGroup rg = findViewById( R.id.question_6_radio_group );

        return rg.getCheckedRadioButtonId() == Q6_ANSWER;

    }



}





