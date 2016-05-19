package com.mygdx.game.Spiel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.mygdx.game.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Moers on 12.05.16.
 */



public class GameView extends SurfaceView {
    Random rnd = new Random();
    //x = rnd.nextInt(theGameView.getWidth() - width);
    //y = rnd.nextInt(theGameView.getHeight() - height);

    private List<Sprite> spriteList = new ArrayList<Sprite>();
    private List<Integer> spriteListNum = new ArrayList<Integer>();
    private SurfaceHolder surfaceHolder;
    private Bitmap bmp;
    private Bitmap bmp2;
    private Bitmap bmp3;
    private Bitmap bmp4;
    private int gameoverx;
    private int gameovery;
    private Bitmap background;
    private GameLoopThread theGameLoopThread;
    private final RectF rectF = new RectF();
    private GameActivity theGameActivity = new GameActivity();
    /*private int y = 0;
    private int ySpeed;     werden jetzt in der Klasse Sprite angelegt
    private Sprite theSprite, theSprite2,theSprite3,theSprite4;*/
    private boolean createSprites= true;
    private long lastClick;


    @SuppressLint("WrongCall") public GameView(Context context) {
        super(context);


        theGameLoopThread = new GameLoopThread(this);
        surfaceHolder = getHolder();
        theGameActivity = (GameActivity) context;

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {

            public void surfaceDestroyed(SurfaceHolder holder) {
                boolean retry = true;
                theGameLoopThread.setRunning(false);
                while(retry){
                    try {
                        theGameLoopThread.join();
                        retry=false;
                    }catch(InterruptedException e){

                    }
                }

            }

            public void surfaceCreated(SurfaceHolder holder) {
                theGameLoopThread.setRunning(true);
                theGameLoopThread.start();

            }

            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
                // TODO Auto-generated method stub

            }
        });
        background = BitmapFactory.decodeResource(getResources(),
                R.drawable.brett);

       /* bmp = BitmapFactory.decodeResource(getResources(), R.drawable.kegel_blau);
        bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.kegel_gelb);
        bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.kegel_gruen);
        bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.kegel_rot);

        theSprite = new Sprite(this, bmp);
        theSprite2 = new Sprite(this, bmp2);
        theSprite3 = new Sprite(this, bmp3);
        theSprite4 = new Sprite(this, bmp4);*/

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.DKGRAY);
        drawBackground(canvas);


        if(createSprites==true){


            initialSprites();
        }
      /*  theSprite.onDraw(canvas);
        theSprite2.onDraw(canvas);
        theSprite3.onDraw(canvas);
        theSprite4.onDraw(canvas);*/


        for (Sprite sprite : spriteList) {
            sprite.onDraw(canvas);
        }
    }

    private void createSprite(int index) {
        Bitmap bmp = null;
        switch (index) {
            case 0:
                bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.kegel_blau);
                break;
            case 1:
                bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.kegel_rot);
                break;
            case 2:
                bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.kegel_schwarz);
                break;
            case 3:
                bmp = BitmapFactory.decodeResource(getResources(),
                        R.drawable.kegel_lila);
                break;
        }
        Sprite sprite = new Sprite(this, bmp);

        spriteList.add(sprite);
        spriteListNum.add(index);
    }

    private void initialSprites() {
        for (int i = 0; i <1 ; i++) {

            for (int j = 0; j < 1; j++)

            createSprite(i);


        }
        createSprites = false;
    }




    private void rndCreateSprite() {
        Random rnd = new Random(System.currentTimeMillis());
        int i = rnd.nextInt(4);
        createSprite(i);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (System.currentTimeMillis() - lastClick > 300) {
            lastClick = System.currentTimeMillis();
            synchronized (getHolder()) {
                for (int i = spriteList.size() - 1; i >= 0; i--) {
                    Sprite sprite = spriteList.get(i);
                    if (sprite.isTouched(event.getX(), event.getY())) {




                       int wuerfel = rnd.nextInt((6 - 1) + 1) + 1;
                     /*   switch (wuerfel) {
                            case 1:
                                wuerfel = 1;
                                break;
                            case 2:
                                wuerfel = 2;
                                break;
                            case 3:
                                wuerfel = 3;
                                break;
                            case 4:
                                wuerfel = 4;
                                break;
                            case 5:
                                wuerfel = 5;
                                break;
                            case 6:
                                wuerfel = 6;
                                break;
                            default:}
*/

                        sprite.setxSpeed((getWidth()/11)*wuerfel);
                        //sprite.setxSpeed(getWidth()/11*4);
                        sprite.setySpeed(getHeight()/11);
                        break;
                    }

                        if ( sprite.getx() > -400 && sprite.gety() < 100) {
                            theGameActivity.onGameOver();
                        }

                    }


                }
            }


        return true;
    }






    private void removeSprite(int index) {
        spriteList.remove(index);
        spriteListNum.remove(index);
    }


    public void drawBackground(Canvas canvas){
        rectF.set(0, 0, getMeasuredWidth(), getMeasuredHeight());

            canvas.drawBitmap(background, null, rectF, null);



        }

    }



