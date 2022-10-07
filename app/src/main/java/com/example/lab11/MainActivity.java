package com.example.lab11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText InputTextName;
    private TextView Hint,NameView,Winner,Myturn,COMturn;
    private RadioButton scissors,rock,paper;
    private Button RPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputTextName = findViewById(R.id.InputTextName);
        Hint = findViewById(R.id.Hint);
//    RadioGroup RGroup = findViewById(R.id.RGroup);
        scissors = findViewById(R.id.scissors);
        rock = findViewById(R.id.rock);
        paper = findViewById(R.id.paper);
        NameView = findViewById(R.id.NameView);
        Winner = findViewById(R.id.Winner);
        Myturn = findViewById(R.id.Myturn);
        COMturn = findViewById(R.id.COMturn);
        RPS = findViewById(R.id.RPS);
        RPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InputTextName.length()<1)
                    Hint.setText("請輸入玩家姓名");
                else{
                    NameView.setText(String.format("名字\n%S",InputTextName.getText().toString()));

                    if(scissors.isChecked()){
                        Myturn.setText("我方出拳\n剪刀");
                    }
                    else if(rock.isChecked()) {
                        Myturn.setText("我方出拳\n石頭");
                    }
                    else {
                        Myturn.setText("我方出拳\n布");
                    }

                    int computer = (int)(Math.random()*3);
                    if(computer == 0){
                        COMturn.setText("電腦出拳\n剪刀");
                    }
                    else if(computer == 1) {
                        COMturn.setText("電腦出拳\n石頭");
                    }
                    else {
                        COMturn.setText("電腦出拳\n布");
                    }

                    if((scissors.isChecked() && computer == 2) ||
                        (rock.isChecked()&& computer == 0) ||
                                (paper.isChecked() && computer ==1)){
                        Winner.setText("勝利者\n" + InputTextName.getText().toString());
                        Hint.setText("恭喜你獲勝了");
                    }
                    else if((scissors.isChecked() && computer == 1) ||
                            (rock.isChecked()&& computer == 2) ||
                            (paper.isChecked() && computer ==0)){
                        Winner.setText("勝利者\n電腦");
                        Hint.setText("可惜，電腦獲勝了!");
                    }
                    else {
                        Winner.setText("勝利者\n平手");
                        Hint.setText("平局，請再試一次");
                    }
                }
            }
        });
    }
}