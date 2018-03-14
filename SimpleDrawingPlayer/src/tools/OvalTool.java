package tools;

import model.Oval;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OvalTool extends ShapeTool {
    Oval oval;


    public OvalTool(DrawingEditor editor, JComponent parent){
        super(editor, parent);

    }
    @Override
    public String getLabel() {
        return "Oval";
    }
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    public void makeShape(MouseEvent e) {
        oval = new Oval(e.getPoint(), editor.getMidiSynth());
    }
    @Override
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeShape(e);
        oval.selectAndPlay();
        oval.setBounds(e.getPoint());
        editor.addToDrawing(oval);
    }

    @Override
    public void mouseReleasedInDrawingArea(MouseEvent e) {
        oval.unselectAndStopPlaying();
        oval = null;
    }
    @Override
    public void mouseDraggedInDrawingArea(MouseEvent e) {
        oval.setBounds(e.getPoint());
    }
}
