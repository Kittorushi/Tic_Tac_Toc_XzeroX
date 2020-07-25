package com.example.xzerox;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // 0 = gold , 1 = red---poki;

    int activeplayer = 0;
    ImageView gold1, gold2, gold3, gold4, gold5, gold6, gold7, gold8, gold9;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winpos = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    TextView textView;
    Button button;
    boolean whoIswinning = true;
    LinearLayout linearLayout;

        public void touch1( ImageView imageView) {
            System.out.println(imageView.getTag().toString());
            int tapcounter = Integer.parseInt(imageView.getTag().toString());
            if (gamestate[tapcounter] == 2 && whoIswinning == true) {
                gamestate[tapcounter] = activeplayer;
                System.out.println("This is the game state  = ="+gamestate[tapcounter]);
                imageView.setTranslationY(-1000f);
                if (activeplayer == 0) {
                    imageView.setImageResource(R.drawable.gold);
                    activeplayer = 1;
                } else {
                    imageView.setImageResource(R.drawable.poki);
                    activeplayer = 0;
                }
                imageView.animate().translationYBy(1000f).setDuration(1000);

//              This is so important we are going through the for loop by chainging all is winpos position
//              FOR LOOP PAHA and variable == position paha to loop hot zanr upto 8 ka? karn winpost madhe 8 item save ahet
                for (int[] positon: winpos)
                {
                   if(gamestate[positon[0]] == gamestate[positon[1]] &&
                           gamestate[positon[1]] == gamestate[positon[2]] &&
                           gamestate[positon[0]] != 2)
                   {
                       String winner = "POKI";
                       if(gamestate[positon[0]] == 0) winner = "GOLD";
                            System.out.println("Winner = =");
                            whoIswinning = false;
                    //        linearLayout.animate().translationYBy(1000f);
                    //        button.animate().translationYBy(1000f);
                            textView.setText("WELL PLAYED :- " + String.format(winner));
                            linearLayout.setVisibility(View.VISIBLE);



                    }else {
                       boolean gameOver= false ;
                       for (int gettie : gamestate){
                               if (gettie == 3) {
                                   textView.setText("It's a draw");
                                   linearLayout.setVisibility(View.VISIBLE);
                               }else {

                                   }
                               }
                           }

                       }
                   }

                }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt1);
        button = findViewById(R.id.btn1);
        linearLayout = findViewById(R.id.linearlay1);

      //  linearLayout.setTranslationY(-1000f);
      //  button.setTranslationY(-1000f);

        gold1 = findViewById(R.id.img1);
        gold2 = findViewById(R.id.img2);
        gold3 = findViewById(R.id.img3);
        gold4 = findViewById(R.id.img4);
        gold5 = findViewById(R.id.img5);
        gold6 = findViewById(R.id.img6);
        gold7 = findViewById(R.id.img7);
        gold8 = findViewById(R.id.img8);
        gold9 = findViewById(R.id.img9);

        gold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold1);
            }
        });

        gold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold2);
            }
        });

        gold3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold3);
            }
        });

        gold4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold4);
            }
        });

        gold5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold5);
            }
        });

        gold6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold6);
            }
        });

        gold7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold7);
            }
        });

        gold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold1);
            }
        });

        gold8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold8);
            }
        });

        gold9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch1(gold9);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   linearLayout.setTranslationY(-1000f);
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            //    button.setTranslationY(-1000f);
                whoIswinning = true;
                finish();


            }
        });

    }
}
