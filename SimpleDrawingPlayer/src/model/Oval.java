package model;

import sound.MidiSynth;

import java.awt.*;

public class Oval extends Shape {

    public Oval(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
        super.PLAYING_COLOR = new Color(44, 215, 230);

    }
    public Oval(int x, int y, int w, int h) {
        super(x,y,w,h);
    }
    // EFFECTS: starts playing this Shape, where sound is dependent on the area/coordinates of the Shape
    public void play(){
       int volume = (int)areaToVelocity(width*height*Math.PI);
        midiSynth.play(instrument, coordToNote(y), volume);
    }

    public double areaToVelocity(double area) {
        return Math.max(60.0, Math.min(127.0, area / 30.0));
    }

@Override
    public void drawGraphics(Graphics g) {
        g.drawOval(x, y, width, height);
    }

@Override
    public void fillGraphics(Graphics g) {
        g.fillOval(x, y, width, height);
    }



    @Override
    public boolean contains(Point p) {
        final double TOL = 1.0e-6;
        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;
        double diff = 0.0;

        if (halfWidth > 0.0) {
            diff = diff + sqrDiff(x + halfWidth, p.x) / (halfWidth * halfWidth);
        } else {
            diff = diff + sqrDiff(x + halfWidth, p.x);
        }
        if (halfHeight > 0.0) {
            diff = diff + sqrDiff(y + halfHeight, p.y) / (halfHeight * halfHeight);
        } else {
            diff = diff + sqrDiff(y + halfHeight, p.y);
        }
        return  diff <= 1.0 + TOL;
    }

    // Compute square of difference
// EFFECTS: returns the square of the difference of num1 and num2
    private double sqrDiff(double num1, double num2) {
        return (num1 - num2) * (num1 - num2);
    }
}

