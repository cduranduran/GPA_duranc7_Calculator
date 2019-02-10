package com.example.home.gpa_duranc7_calculator;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    public TextView GPA_View;
    public EditText Text1, Text2, Text3,Text4,Text5;
    Button ComputeButton;
    ConstraintLayout Background;
    Boolean buttontext = Boolean.FALSE;

    public Double grade1, grade2, grade3, grade4, grade5;
    public Double Final_GPA;

//make sure text is not blank;
    public Boolean Validate(EditText Text){
        Boolean Valid=Boolean.FALSE;

        if(Text.getText().toString().trim().length()==0){
            Valid = Boolean.TRUE;
            Text.setError("Text Not Valid");
        }
        return Valid;
    }

    //convert letter grade to GPA
    private double TexttoGPA(EditText Text){
         Double grade=0.0;
    String StringGrade = Text.getText().toString();
        switch (StringGrade){
            case "A+":
                grade = 4.00;
                break;
            case "A":
                grade = 3.75;
                break;
            case "B+":
                grade = 3.50;
                break;
            case "B":
                grade = 3.50;
                break;
            case "C+":
                grade = 2.50;
                break;
            case "C":
                grade = 2.00;
                break;
            case "D+":
                grade = 1.50;
                break;
            case "D":
                grade = 1.00;
                break;
            case "F":
                grade = 0.0;
                break;
        }

       return grade;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GPA_View = findViewById(R.id.GPA_View);
        Text1 = findViewById(R.id.editText1);
        Text2 = findViewById(R.id.editText2);
        Text3 = findViewById(R.id.editText3);
        Text4 = findViewById(R.id.editText4);
        Text5 = findViewById(R.id.editText5);
        ComputeButton = findViewById(R.id.Compute_Button);
        Background = findViewById(R.id.Background_layout);

        ComputeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Validate text entered

            /*if(Validate(Text1)){
               grade1 = TexttoGPA(Text1);

            }else if(Validate(Text2)){
                grade2 = TexttoGPA(Text2);
            }else if(Validate(Text3)){
                grade3 = TexttoGPA(Text3);
            }else if(Validate(Text4)){
                grade4 = TexttoGPA(Text4);
            }else if(Validate(Text5)){
                grade5 = TexttoGPA(Text5);
            }else{
                Text5.setError("Text Not Valid");
            }*/

            /*if (Validate(Text1)==Boolean.FALSE || Validate(Text2)==Boolean.FALSE || Validate(Text3)==Boolean.FALSE
                    || Validate(Text4)==Boolean.FALSE ||Validate(Text5)==Boolean.FALSE){
                Text1.setError("Please enter a Letter Grade");
            }else{*/
                //compute GPA and set view
                grade1= TexttoGPA(Text1);
                grade2= TexttoGPA(Text2);
                grade3= TexttoGPA(Text3);
                grade4= TexttoGPA(Text4);
                grade5= TexttoGPA(Text5);
                Final_GPA = (grade1 + grade2 + grade3 + grade4 + grade5)/5;
                GPA_View.setText(String.valueOf(Final_GPA));
          /*  }*/




                    //set background color

                if(Final_GPA >= 3){
                    Background.setBackgroundColor(Color.GREEN);
                }else if(Final_GPA <=2.9 && Final_GPA >1){
                    Background.setBackgroundColor(Color.YELLOW);
                }else if (Final_GPA > 0 && Final_GPA <= 1){
                    Background.setBackgroundColor(Color.RED);
                }else{
                    Background.setBackgroundColor(Color.WHITE);
                }
                ComputeButton.setText("ClearForm");
               ComputeButton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                    String blank = "0.0";
                       Text1.setText("");
                       Text2.setText("");
                       Text3.setText("");
                       Text4.setText("");
                       Text5.setText("");
                       GPA_View.setText(blank);

                   }
               });




            }
        });



    }



}
