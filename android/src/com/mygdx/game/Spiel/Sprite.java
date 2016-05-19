package com.mygdx.game.Spiel;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Moers on 13.05.16.
 */
public class Sprite {
    // private int x = 0;
    //private int y = 0;
    private int sprung;
    private int x;
    private int y;
    private int a;
    private int b;
    private boolean kante;
    private int movex;
    private int diffx;
    private int diffy;
    private boolean links;
    private boolean rechts;
    private boolean rauf = false;
    public boolean runter = false;


    private int xSpeed;
    private int ySpeed;
    private int width;
    private int height;
    private Bitmap bmp;
    private GameView theGameView;

    public Sprite(GameView theGameView, Bitmap bmp) {

        this.theGameView = theGameView;
        this.bmp = bmp;
        this.width = bmp.getWidth();
        this.height = bmp.getHeight();

        //Random rnd = new Random();
        //x = rnd.nextInt(theGameView.getWidth() - width);
        //y = rnd.nextInt(theGameView.getHeight() - height);
        x = 00;
       y = theGameView.getHeight() - height - 80;


        //ySpeed = rnd.nextInt(10) - 4;
        //(xSpeed = rnd.nextInt(10) - 4;

        ySpeed = 0;
        xSpeed = 0;


    }

    public void setxSpeed(int Speed) {

        xSpeed = Speed;
    }

    public void setySpeed(int Speed) {

        ySpeed = Speed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }


    public void setx(int koordinatex) {

        x = koordinatex;
    }

    public void sety(int koordinatey) {

        y = koordinatey;
    }
    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }



    private void bounceOff() {


//leiter 8 auf 26
    /*   if((y == theGameView.getHeight()-height-60- ) && (x==10)) {


            y = y - ySpeed * 7 - 10;
            x = 110;
            //y = y - ySpeed*10+80;
            //  x=60;
        }
*/
        //leiter 21 auf 82
      /*  if((y == theGameView.getHeight()-height-60*-ySpeed ) && (x==110)) {


            y = y - ySpeed*6-10;
            x = 210;
            //y = y - ySpeed*10+80;
            //  x=60;
        }*/
//leiter 43 auf 77
      /*  if((y == theGameView.getHeight()-height-60 ) && (x==710)) {


            y = y - ySpeed*2-10;
            x = 510;
            //y = y - ySpeed*10+80;
            //  x=60;
        }*/
        //leiter 50 auf 91
     /*   if((y == theGameView.getHeight()-height-60 ) && (x==710)) {


            y = y - ySpeed*2-10;
            x = 510;
            //y = y - ySpeed*10+80;
            //  x=60;
        }*/
//leiter 54 auf 93
    /*    if((y == theGameView.getHeight()-height-60 ) && (x==710)) {


            y = y - ySpeed*2-10;
            x = 510;
            //y = y - ySpeed*10+80;
            //  x=60;
        }*/
//leiter 66 auf 87

/*
        if((y == theGameView.getHeight()-height-60 ) && (x==710)) {


            y = y - ySpeed*2-10;
            x = 510;
            //y = y - ySpeed*10+80;
            //  x=60;
        } */
        // leiter 62 auf 96
  /*      if((y == theGameView.getHeight()-height-60 ) && (x==710)) {


            y = y - ySpeed*2-10;
            x = 510;
            //y = y - ySpeed*10+80;
            //  x=60;
        }
     */   //leiter 80 auf 100
     /*   if((y == theGameView.getHeight()-height-60 ) && (x==710)) {


            y = y - ySpeed*2-10;
            x = 510;
            //y = y - ySpeed*10+80;
            //  x=60;
        }

*/
        //   if((y == theGameView.getHeight()-height- ySpeed*10+80 ) && (x==60)) {


        //   }
        if (x < 1) {
            links = false;
            rechts = true;
            a = 0;

        }
// links rauf

        if ((x > theGameView.getWidth() - width - xSpeed) && (xSpeed >= theGameView.getWidth() / 11) && links == false) {
            links = true;
            rechts = false;


            diffx = (theGameView.getWidth() - width - xSpeed) - x;

            // y=y-ySpeed;

           // x = x + diffx + xSpeed;
            a = 0;
            x=theGameView.getWidth()-width;


            if (diffx < 0) {
                y = y - ySpeed;
                ySpeed = 0;

                //   x=x-diffx-xSpeed;

                x = x + diffx + theGameView.getWidth() / 11;
                xSpeed = 0;


            }


        }
        // links rauf

        //  x=x+diffx -(xSpeed+diffx);

       /* if ((x > theGameView.getWidth() - width - xSpeed) && (xSpeed == theGameView.getWidth() / 10) && links == false) {
            links = true;
            rechts = false;
            y = y - ySpeed;
            ySpeed = 0;
            a = 1;
            x=theGameView.getWidth()-width;

        }*/


/*if (links == true)
    x=x-xSpeed;     || x + xSpeed < 0)
*/


        if (links == true && a == 0)

        {
            x = x - xSpeed ;
            xSpeed = 0;

        }

        if (a == 1)

        {
            a = 0;

        } else if (links == false)

        {
            x = x + xSpeed;

            xSpeed = 0;
        }






/*if (links == true)
    x=x-xSpeed;     || x + xSpeed < 0)
*/


       if (x - xSpeed < 0 && rechts == false) {
            rechts = true;
            links = false;

            diffx = (0 - width - xSpeed) - x;


           // x=x+xSpeed+diffx;
x=0;

            xSpeed = 0;

           if (diffx >-200) {
                y = y - ySpeed;
                ySpeed = 0;

                //   x=x-diffx-xSpeed;

                x = 30+x + diffx + theGameView.getWidth() / 11;
                xSpeed = 0;


            }


        }


    }
    public void onDraw(Canvas canvas) {
        bounceOff();
        canvas.drawBitmap(bmp, x, y, null);
    }

    public boolean isTouched(float x2, float y2) {
        return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
    }


}

