package model;


import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
        super.PLAYING_COLOR = new Color(230, 34, 68);

    }
    // EFFECTS: starts playing this Shape, where sound is dependent on the area/coordinates of the Shape
    public void play(){
        int volume = (int)areaToVelocity(width* height);
        midiSynth.play(instrument, coordToNote(y), volume);
    }
    @Override
    public double areaToVelocity(double area) {
        return Math.max(60, Math.min(127, area / 30));
    }

    @Override
    //EFFECTS: draws the shape
    public void drawGraphics(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    //EFFECTS: fills the shape
    public void fillGraphics(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}
