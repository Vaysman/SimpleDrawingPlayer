package tools;


import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public abstract class ShapeTool extends Tool {


	public ShapeTool(DrawingEditor editor, JComponent parent) {
		super(editor, parent);
	}

	// MODIFIES: this
	// EFFECTS:  creates new button and adds to parent
	@Override
	protected void createButton(JComponent parent) {
		button = new JButton(getLabel());
		button = customizeButton(button);
	}


	// EFFECTS:  associate button with new ClickHandler
	@Override
	protected void addListener() {
		button.addActionListener(new ShapeToolClickHandler());
	}


	// EFFECTS:  a shape is instantiate MouseEvent occurs, and played and
	//           added to the editor's drawing
	@Override
	public void mousePressedInDrawingArea(MouseEvent e) { }



	// EFFECTS:  unselects this shape, and sets it to null
	@Override
	public void mouseReleasedInDrawingArea(MouseEvent e) {

	}


	// EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
	@Override
	public void mouseDraggedInDrawingArea(MouseEvent e) { }

	//EFFECTS: Returns the string for the label.
	public String getLabel() {
		return "";
	}

	//EFFECTS: Constructs and returns the new shape
	public void makeShape(MouseEvent e) {
	}

	private class ShapeToolClickHandler implements ActionListener {

		// EFFECTS: sets active tool to the shape tool
		//          called by the framework when the tool is clicked
		@Override
		public void actionPerformed(ActionEvent e) {
			editor.setActiveTool(ShapeTool.this);
		}
	}
}
