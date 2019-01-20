package daymos.lodz.uni.math.pl.calculator_2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    private TextView result;
    private ArrayList<String> calculateHistoryList;
    private baza baza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        baza = new baza(this);
        calculateHistoryList = new ArrayList<String>();
        calculateHistoryList = (ArrayList<String>) getIntent().getSerializableExtra("LIST");
        result = (TextView) findViewById(R.id.result);


        for (int i = 0; i < calculateHistoryList.size(); i++) {
            baza.dodajWyrazenie(calculateHistoryList.get(i));

        }

        Cursor m=baza.pokazWszystkie();
        while (m.moveToNext()){
            int numer=m.getInt(0);
            String wynik=m.getString(1);
            result.setText(result.getText()+"\n"+ numer + ".     " + wynik );
        }
        calculateHistoryList.clear();
    }
}