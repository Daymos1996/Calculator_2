package daymos.lodz.uni.math.pl.calculator_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;




public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private String result;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAdd;
    private Button buttonSubtract;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonEqual;
    private Button buttonIntersection;
    private Button buttonClear;
    private Button buttonHistory;
    private Button buttonBack;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonIntersection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result != "") {
                    result += ".";
                    resultView.setText(result);
                }
            }
        });

       buttonEqual.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(result != "") {

                   try{
                       Expression expression = new ExpressionBuilder(result).build();
                       double calculate = expression.evaluate();
                       resultView.setText(DoubleToString(calculate));

                       result = "";
                   }
                   catch(Exception e){
                       Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });

       buttonBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if (result != null) {
                   if(result.length() > 0){
                       result = result.substring(0, result.length() - 1);
                   }
               }
               resultView.setText(result);
           }
       });
       buttonHistory.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
               startActivity(intent);
           }
       });

       buttonClear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               result="";
               resultView.setText(result);
           }
       });




    }


    private void init() {
        resultView = findViewById(R.id.result);
        result = "";
        button0=(Button) findViewById(R.id.b_0);
        button1=(Button) findViewById(R.id.b_1);
        button2=(Button) findViewById(R.id.b_2);
        button3=(Button) findViewById(R.id.b_3);
        button4=(Button) findViewById(R.id.b_4);
        button5=(Button) findViewById(R.id.b_5);
        button6=(Button) findViewById(R.id.b_6);
        button7=(Button) findViewById(R.id.b_7);
        button8=(Button) findViewById(R.id.b_8);
        button9=(Button) findViewById(R.id.b_9);
        buttonAdd=(Button) findViewById(R.id.b_add);
        buttonSubtract=(Button) findViewById(R.id.b_subtract);
        buttonDivide=(Button) findViewById(R.id.b_divide);
        buttonMultiply=(Button) findViewById(R.id.b_multiply);
        buttonHistory=(Button) findViewById(R.id.b_History);
        buttonClear=(Button) findViewById(R.id.b_Clear);
        buttonBack=(Button) findViewById(R.id.b_Back);
        buttonIntersection=(Button) findViewById(R.id.b_Intersection);
        buttonEqual=(Button) findViewById(R.id.b_Equal);

    }


    private String DoubleToString(double d){
        if(d == (long) d) {
            return String.format("%d", (long) d);
        }
        else {
            return String.format("%s", d);
        }
    }


    public void onClickButton(View view) {
        Button clicked = (Button) view;

        String operator = clicked.getText().toString();

        if(operator.equals("C")) {
            result = "";
        }
        else{
            result += operator;
        }

        resultView.setText(result);
    }


}
