package pe.edu.cibertec.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btYes, btNo , btNext , btPrevious;
    TextView tvQuestion;
    ArrayList<Question> question;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btYes = findViewById(R.id.BtYes);
        btNo = findViewById(R.id.btNo);
        btNext = findViewById(R.id.btNext);
        btPrevious = findViewById(R.id.btPrevious);



        tvQuestion= findViewById(R.id.tvQuestion);
        position = 0;
        question = new ArrayList<>();
        loadQuestion();
        showActualQuestions();
        tvQuestion.setText(question.get(position).getName());


        btYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyResponse(true);

            }
        });

        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifyResponse(false);

            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position < (question.size()-1)){
               position +=1;
                showActualQuestions();}
                else{

                   position=0;
                   showActualQuestions();

                }
            }
        });

        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position >0){
                    position -=1;
                showActualQuestions();}
                else{

                    position=(question.size()-1);
                    showActualQuestions();
                }

            }
        });

    }

    private void verifyResponse(boolean b) {
        Question actualQuestion = question.get(position);
        if (b == actualQuestion.isResponse()) {

            Toast.makeText(MainActivity.this, getString(R.string.Correct),
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, getString(R.string.Incorrect), Toast.LENGTH_SHORT).show();


        }

    }

    private void showActualQuestions() {


        tvQuestion.setText(question.get(position).getName());


    }


    private void loadQuestion() {

        Question questionPeru = new Question(getString(R.string.Peru_question), true);
        question.add(questionPeru);

        Question questionChile = new Question(getString(R.string.Chile_quetion),false);
        question.add(questionChile);

        Question questionColombia = new Question(getString(R.string.Colombia_quetion),false);
        question.add(questionColombia);

    }


}
