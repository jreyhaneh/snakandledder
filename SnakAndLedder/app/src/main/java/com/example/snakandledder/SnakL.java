package com.example.snakandledder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class SnakL extends AppCompatActivity {

    TextView Viewer;
    boolean Redturn = true, Blueturn = true, Activation;
    int PositionValue;
    int RedPosition = -1, BluePosition = -1;

    ImageButton button[][] = new ImageButton[10][10];
    List<ImageButton> Position = new ArrayList<ImageButton>();
    Button Tass1, Tass2;

    private static final int PosButtonId[][] = {
            {(R.id.position00), (R.id.position01), (R.id.position02), (R.id.position03), (R.id.position04), (R.id.position05), (R.id.position06), (R.id.position07), (R.id.position08), (R.id.position09)},
            {(R.id.position10), (R.id.position11), (R.id.position12), (R.id.position13), (R.id.position14), (R.id.position15), (R.id.position16), (R.id.position17), (R.id.position18), (R.id.position19)},
            {(R.id.position20), (R.id.position21), (R.id.position22), (R.id.position23), (R.id.position34), (R.id.position25), (R.id.position26), (R.id.position27), (R.id.position28), (R.id.position29)},
            {(R.id.position30), (R.id.position31), (R.id.position32), (R.id.position33), (R.id.position34), (R.id.position35), (R.id.position36), (R.id.position37), (R.id.position38), (R.id.position39)},
            {(R.id.position40), (R.id.position41), (R.id.position42), (R.id.position43), (R.id.position44), (R.id.position45), (R.id.position46), (R.id.position47), (R.id.position48), (R.id.position49)},
            {(R.id.position50), (R.id.position51), (R.id.position52), (R.id.position53), (R.id.position54), (R.id.position55), (R.id.position56), (R.id.position57), (R.id.position58), (R.id.position59)},
            {(R.id.position60), (R.id.position61), (R.id.position62), (R.id.position63), (R.id.position64), (R.id.position65), (R.id.position66), (R.id.position67), (R.id.position68), (R.id.position69)},
            {(R.id.position70), (R.id.position71), (R.id.position72), (R.id.position73), (R.id.position74), (R.id.position75), (R.id.position76), (R.id.position77), (R.id.position78), (R.id.position79)},
            {(R.id.position80), (R.id.position81), (R.id.position82), (R.id.position83), (R.id.position84), (R.id.position85), (R.id.position86), (R.id.position87), (R.id.position88), (R.id.position89)},
            {(R.id.position90), (R.id.position91), (R.id.position92), (R.id.position93), (R.id.position94), (R.id.position95), (R.id.position96), (R.id.position97), (R.id.position98), (R.id.position99)}};
// mar={16,23,45,50,59,65,82,88,94,96};
// narde={3,7,11,20,25,44,51,56,62,69,78};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snak_l);
        Tass1 = (Button) findViewById(R.id.tass1);
        Tass2 = (Button) findViewById(R.id.tass2);
        Viewer = (TextView) findViewById(R.id.view);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {

                button[y][x] = (ImageButton) findViewById(PosButtonId[y][x]);

            }
        }


        Tass2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Redturn) {
                    Activation = false;
                    int r = RandomNumber();

                    if (RedPosition == -1) { //baresi inke tas vorod  bazi ast ya na
                        if ( r == 6) {// age dafe aval 6 biyad
                            RedPosition++;
                            PlaceButton(Activation, 0, RedPosition);
                            Blueturn = false;
                        } else {//  age dafe aval 6 nyad
                            Redturn = false;
                            Blueturn = true;
                        }
                    }

                    else if (RedPosition >= 0 && r <= 6) { // age dafe aval nbod
                        if (RedPosition + r == 100) { // baresi barande shodan blue
                            gameOver(false);
                            PlaceButton(Activation, r, RedPosition);//jaygah red
                        }
                        else if (BluePosition + r < 100) { // age blue be akhar nresad
                            PlaceButton(Activation, r, RedPosition);//jaygah red
                            Redturn = false;
                            Blueturn = true;
                            if (r == 6) { // jayeze
                                Redturn = true;
                                Blueturn = false;
                            }
                        } else if (BluePosition + r > 100) {
                            Redturn = true;
                            Blueturn = false;
                        }
                    }

                    Viewer.setText(r + "");
                }
            }
        });
        Tass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (Blueturn) {
                    Activation = true;
                    int r = RandomNumber();

                    if (BluePosition == -1) {
                        if ( r == 6) {
                            BluePosition++;
                            PlaceButton(Activation, 0, BluePosition);
                            Redturn = false;
                        } else {
                            Blueturn = false;
                            Redturn = true;
                        }
                    }
                    else if (BluePosition >= 0 && r <= 6) {
                        if (BluePosition + r == 100) {
                           gameOver(false);
                            PlaceButton(Activation, r, BluePosition);
                        }
                        else if (RedPosition + r < 100) {
                            PlaceButton(Activation, r, BluePosition);
                            Blueturn = false;
                            Redturn = true;
                            if (r == 6) {
                                Blueturn = true;
                                Redturn = false;
                            }
                        } else if (RedPosition + r > 100) {
                            Blueturn = true;
                            Redturn = false;
                        }
                    }
                    Viewer.setText(r + "");
                }
            }
        });
    }



    int RandomNumber() {
     return ((int)(Math.random()*10)%6)+1;
    }

    void PlaceButton(boolean action,int size,int initialposition){
        int newposition=initialposition+size;
        char positionchar[]=new char[2];
        char resetpositionchar[]=new char[2];

        positionchar=String.valueOf(newposition).toCharArray();
        resetpositionchar=String.valueOf(initialposition).toCharArray();

        int posy = 0,resy = 0;
        int posx = 0,resx = 0;

        if((newposition)<10){ //shart radif aval
            posy=0;
            posx=newposition;
        }
        else {//shart radif do de bad
            posy=Integer.parseInt(positionchar[0]+""); // jaygah bazikon
            posx=Integer.parseInt(positionchar[1]+"");
        }

        if((initialposition-1)<0){ //bazikon kharej ast
            resx=0;
            resy=0;
        }else if((initialposition)<10){//bazikon dakhel bazi va radif aval
            resx=initialposition;
            resy=0;
        }
        else {//radif haye dovom be bad
            resy=Integer.parseInt(resetpositionchar[0]+"");
            resx=Integer.parseInt(resetpositionchar[1]+"");
        }
        if (action && newposition<100){
            button[resy][resx].setBackground(getResources().getDrawable(R.color.transparent));
            button[posy][posx].setBackground(getResources().getDrawable(R.drawable.blue));
            BluePosition=newposition;
  ////////////////////////mar ha
            if(posy==1 && posx==5){
                button[1][5].setBackground(getResources().getDrawable(R.color.transparent));
                button[0][6].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=7;
            }
            if(posy==2 && posx==2){
                button[2][2].setBackground(getResources().getDrawable(R.color.transparent));
                button[0][1].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=2;
            }
            if(posy==4 && posx==4){
                button[4][4].setBackground(getResources().getDrawable(R.color.transparent));
                button[2][3].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=24;
            }
            if(posy==4 && posx==9){
                button[4][9].setBackground(getResources().getDrawable(R.color.transparent));
                button[2][7].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=28;
            }
            if(posy==5 && posx==8){
                button[5][8].setBackground(getResources().getDrawable(R.color.transparent));
                button[3][7].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=38;
            }
            if(posy==6 && posx==4){
                button[6][4].setBackground(getResources().getDrawable(R.color.transparent));
                button[5][3].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=54;
            }
            if(posy==8 && posx==1){
                button[8][1].setBackground(getResources().getDrawable(R.color.transparent));
                button[6][0].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=61;
            }
            if(posy==8 && posx==7){
                button[8][7].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][6].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=47;
            }
            if(posy==9 && posx==3){
                button[9][3].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][5].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=76;
            }
            if(posy==9 && posx==5){
                button[9][5].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][6].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=77;
            }
  ///////////////////////////narde ha
            if(posy==0 && posx==2){
                button[0][2].setBackground(getResources().getDrawable(R.color.transparent));
                button[3][8].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=39;
            }
            if(posy==0 && posx==6){
                button[0][6].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][7].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=48;
            }
            if(posy==1 && posx==0){
                button[1][0].setBackground(getResources().getDrawable(R.color.transparent));
                button[3][1].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=32;
            }
            if(posy==1 && posx==9){
                button[1][9].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][0].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=41;
            }
            if(posy==2 && posx==4){
                button[2][4].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][5].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=46;
            }
            if(posy==4 && posx==3){
                button[4][3].setBackground(getResources().getDrawable(R.color.transparent));
                button[5][7].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=58;
            }
            if(posy==5 && posx==0){
                button[5][1].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][1].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=71;
            }
            if(posy==5 && posx==5){
                button[5][5].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][6].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=77;
            }
            if(posy==6 && posx==1){
                button[6][1].setBackground(getResources().getDrawable(R.color.transparent));
                button[8][0].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=81;
            }
            if(posy==6 && posx==8){
                button[6][8].setBackground(getResources().getDrawable(R.color.transparent));
                button[9][0].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=91;
            }
            if(posy==7 && posx==7){
                button[7][7].setBackground(getResources().getDrawable(R.color.transparent));
                button[9][6].setBackground(getResources().getDrawable(R.drawable.blue));
                BluePosition=97;
            }

        }
        else if(!action && newposition<100){
            button[resy][resx].setBackground(getResources().getDrawable(R.color.transparent));
            button[posy][posx].setBackground(getResources().getDrawable(R.drawable.red));
            RedPosition=newposition;

            if(posy==1 && posx==5){
                button[1][5].setBackground(getResources().getDrawable(R.color.transparent));
                button[0][5].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=6;
            }
            if(posy==2 && posx==2){
                button[2][2].setBackground(getResources().getDrawable(R.color.transparent));
                button[0][1].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=2;
            }
            if(posy==4 && posx==4){
                button[4][4].setBackground(getResources().getDrawable(R.color.transparent));
                button[2][3].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=24;
            }
            if(posy==4 && posx==9){
                button[4][9].setBackground(getResources().getDrawable(R.color.transparent));
                button[2][7].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=28;
            }
            if(posy==5 && posx==8){
                button[5][8].setBackground(getResources().getDrawable(R.color.transparent));
                button[3][7].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=38;
            }
            if(posy==6 && posx==4){
                button[6][4].setBackground(getResources().getDrawable(R.color.transparent));
                button[5][3].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=54;
            }
            if(posy==8 && posx==1){
                button[8][1].setBackground(getResources().getDrawable(R.color.transparent));
                button[6][0].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=61;
            }
            if(posy==8 && posx==7){
                button[8][7].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][6].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=47;
            }
            if(posy==9 && posx==3){
                button[9][3].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][5].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=76;
            }
            if(posy==9 && posx==5){
                button[9][5].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][6].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=77;
            }
            ///////////////////////////narde ha
            if(posy==0 && posx==2){
                button[0][2].setBackground(getResources().getDrawable(R.color.transparent));
                button[3][8].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=39;
            }
            if(posy==0 && posx==6){
                button[0][6].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][7].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=48;
            }
            if(posy==1 && posx==0){
                button[1][0].setBackground(getResources().getDrawable(R.color.transparent));
                button[3][1].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=32;
            }
            if(posy==1 && posx==9){
                button[1][9].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][0].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=41;
            }
            if(posy==2 && posx==4){
                button[2][4].setBackground(getResources().getDrawable(R.color.transparent));
                button[4][5].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=46;
            }
            if(posy==4 && posx==3){
                button[4][3].setBackground(getResources().getDrawable(R.color.transparent));
                button[5][7].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=58;
            }
            if(posy==5 && posx==0){
                button[5][0].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][0].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=71;
            }
            if(posy==5 && posx==5){
                button[5][5].setBackground(getResources().getDrawable(R.color.transparent));
                button[7][6].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=77;
            }
            if(posy==6 && posx==1){
                button[6][1].setBackground(getResources().getDrawable(R.color.transparent));
                button[8][0].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=81;
            }
            if(posy==6 && posx==8){
                button[6][8].setBackground(getResources().getDrawable(R.color.transparent));
                button[9][0].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=91;
            }
            if(posy==7 && posx==7){
                button[7][7].setBackground(getResources().getDrawable(R.color.transparent));
                button[9][6].setBackground(getResources().getDrawable(R.drawable.red));
                RedPosition=97;
            }
        }
        else  if(newposition==100){
            if(action){
                button[9][9].setBackground(getResources().getDrawable(R.drawable.blue));
            }
            else{
                button[9][9].setBackground(getResources().getDrawable(R.drawable.red));
            }
       }
        Tass2.setText(posy+""+posx);
    }

    void gameOver(boolean activation){
        if(activation){
            Tass1.setText("blue win");
        }else {
            Tass1.setText("red win");
        }
        Redturn=false;
        Blueturn=false;
    }
}