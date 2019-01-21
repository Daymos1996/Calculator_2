package daymos.lodz.uni.math.pl.calculator_2;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    private TextView result;
    private ArrayList<String> calculateHistoryList;
    private DataBase DataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        init();


        for (int i = 0; i < calculateHistoryList.size(); i++) {
            DataBase.addExpression(calculateHistoryList.get(i));

        }

        Cursor m= DataBase.showAll();
        while (m.moveToNext()){
            int number=m.getInt(0);
            String expression=m.getString(1);
            result.setText(result.getText()+"\n"+ number + ".     " + expression );
        }
        calculateHistoryList.clear();


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        DataBase.close();
    }

    private void init() {

        DataBase = new DataBase(this);
        calculateHistoryList = new ArrayList<String>();
        calculateHistoryList = (ArrayList<String>) getIntent().getSerializableExtra("LIST");
        result = (TextView) findViewById(R.id.result);

    }


}