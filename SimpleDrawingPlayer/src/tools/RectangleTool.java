package tools;

import model.Rectangle;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class RectangleTool extends ShapeTool {
    Rectangle rectangle;


public RectangleTool(DrawingEditor editor, JComponent parent){
    super(editor, parent);

}
@Override
public String getLabel() {
    return "Rectangle";
}
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton(getLabel());
        button = customizeButton(button);
    }

    public void makeShape(MouseEvent e) {
        rectangle = new Rectangle(e.getPoint(), editor.getMidiSynth());
    }
@Override
	public void mousePressedInDrawingArea(MouseEvent e) {
		makeShape(e);
		rectangle.selectAndPlay();
		rectangle.setBounds(e.getPoint());
		editor.addToDrawing(rectangle);
	}

    @Override
    public void mouseReleasedInDrawingArea(MouseEvent e) {
        rectangle.unselectAndStopPlaying();
        rectangle = null;
    }
    @Override
    public void mouseDraggedInDrawingArea(MouseEvent e) {
        rectangle.setBounds(e.getPoint());
    }
}
