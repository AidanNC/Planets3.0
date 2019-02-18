package General;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Canvas to display lines, circles, squares, images, text...
 */



public class Canvas extends JPanel
{

    ArrayList<ArrayList<Point>> trail;
    ArrayList<Color> colorTrails;
    ArrayList<PointColorPair> pointAndColor;
    //ArrayList<Canonball>
    SolarSystem sS;
    int trailWidth;
    int trailCount;
    //constructor
    public Canvas(){
        trailCount = 0;
        pointAndColor = new ArrayList<>();
        trailWidth = 2;
        setPreferredSize(new Dimension(1400,800));
        sS = new SolarSystem();


        //sS.sS.add(new Planet(600,100, -18.36,0,10,100,true,newColor() ));
        //sS.sS.add(new Planet(600,150, 30.36,0,10,100,true,newColor() ));
        //sS.sS.add(new Planet(600,500, -35.36,0,10,100,true,newColor() ));
        //sS.sS.add(new Planet(600,250, 25.7034,0,25,1000,true,newColor() ));


        //sS.sS.add(new Planet(500, 400, 0,0,20,5.972e24, false, Color.red));
        //sS.sS.add(new Planet(500, 560, 1025, 0, 10, 7.347e22, true, Color.darkGray));
        //1.32588e10


        //sS.sS.add(new Planet(300,300,0,0,10,100,true,newColor()));
        //sS.sS.add(new Planet(600, 300, 0, 0,40,2000,true, newColor()));
       // sS.sS.add(new Planet(300, 450, 0, 0,20,1000,true, newColor()));

        sS.sS.add(new Planet(300,370,0,0,30,1000,true,newColor()));
        sS.sS.add(new Planet(300, 320, 5.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(300, 420, -5.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(350, 370, 0, 5.47,15,10,true, newColor()));
        sS.sS.add(new Planet(250, 370, 0, -5.47,15,10,true, newColor()));

        sS.sS.add(new Planet(1000, 220, 0, 0,50,1000,true, newColor()));
/*
        sS.sS.add(new Planet(300, 320, 4.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(300,370,0,0,30,1000,true,newColor()));
        sS.sS.add(new Planet(300, 420, -4.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(350, 370, 0, 4.47,15,10,true, newColor()));
        sS.sS.add(new Planet(250, 370, 0, -4.47,15,10,true, newColor()));
/*
        sS.sS.add(new Planet(700, 520, 4.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(700,570,0,0,30,1000,true,newColor()));
        sS.sS.add(new Planet(700, 620, -4.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(750, 570, 0, 4.47,15,10,true, newColor()));
        sS.sS.add(new Planet(650, 570, 0, -4.47,15,10,true, newColor()));

        sS.sS.add(new Planet(100, 520, 4.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(100,570,0,0,30,1000,true,newColor()));
        sS.sS.add(new Planet(100, 620, -4.47, 0,15,10,true, newColor()));
        sS.sS.add(new Planet(150, 570, 0, 4.47,15,10,true, newColor()));
        sS.sS.add(new Planet(50, 570, 0, -4.47,15,10,true, newColor()));

*/
       // sS.sS.add(new Planet(1000,170,0,0,50,20000,true, newColor()));
        //sS.sS.add(new Planet(900,370,0,0,30,5000,true,newColor()));
        //sS.sS.add(new Planet(1200,370,0,0,50,5000,true, newColor()));
        //sS.sS.add(new Planet(10,600,0,0,50,50000,true, newColor()));

/*
        for(int i = 0; i< 10; i ++){
            double tempX = (Math.random()*1400);
            double tempY = (Math.random()*800);
            double tempVX = (Math.random()) -0.5;
            double tempVY = (Math.random()) -0.5;
            int tempRadius = (int)(Math.random()*30)+5;
            double tempMass = tempRadius * 30;
            sS.addPlanet(tempX, tempY, 0, 0, tempRadius, tempMass, true);
        }

*/

        trail = new ArrayList<>();
        colorTrails = new ArrayList<>();

        for(Planet p: sS.sS){
            trail.add(new ArrayList<Point>());
            colorTrails.add(newColor());
        }
    }

    public void update(){
        trailCount ++;
        sS.updateSolarSystem();
        if(trailCount % 10 == 0) {
            for (Planet p : sS.sS) {
                trail.get(sS.sS.indexOf(p)).add(new Point((int) (p.xLoc) - trailWidth / 2 - p.radius / 2, (int) (p.yLoc) - trailWidth / 2 - p.radius / 2));
                pointAndColor.add(new PointColorPair((int) (p.xLoc), (int) (p.yLoc), p.color));
            }
        }
        //System.out.println(sS.sS.size());
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);



        for(Planet p: sS.sS){
            g.setColor(p.color);
            g.drawOval((int)p.xLoc - p.radius,(int)p.yLoc - p.radius,p.radius *2,p.radius *2);
            g.drawString("xloc" + p.xLoc + " yloc: " + p.yLoc,10, 10 + sS.sS.indexOf(p)*20);
            //g.setColor(Color.RED);
            //g.fillOval((int)p.xLoc,(int)p.yLoc, 4,4);
        }
        for(PointColorPair pCP: pointAndColor){
            g.setColor(pCP.color);
            g.drawOval(pCP.x, pCP.y, trailWidth, trailWidth);
        }
        /*
        for(ArrayList<Point> a: trail){
            g.setColor(colorTrails.get(trail.indexOf(a)));
            for(Point p: a){
                g.drawOval(p.x, p.y, trailWidth, trailWidth);

            }

        }
        */

    }

    public Color newColor(){

        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        return new Color(r,g,b);
    }



}
