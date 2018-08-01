package HomePanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HomePanels.OptionsPanels.*;
import Commands.Commands;
import Vars.Vars;

public class Appetizers {
	public static JPanel panel = new JPanel();
	
	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		JLabel label = new JLabel("Appetizers");
		label.setBounds(5, 20, 200, 80);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(Vars.fontDefault);
		panel.add(label);
		
		CustomColorButton buttonItem1 = Commands.createMenuItemButton("Breadsticks", 5, 100, Color.green, Color.black);
		buttonItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options.switchPanel(Breadsticks.panel);
			}
		});
		panel.add(buttonItem1);
		CustomColorButton buttonItem2 = Commands.createMenuItemButton("Mozarella Sticks", 215, 100, Color.green, Color.black);
		panel.add(buttonItem2);
		CustomColorButton buttonItem3 = Commands.createMenuItemButton("Nachos", 425, 100, Color.green, Color.black);
		panel.add(buttonItem3);
		CustomColorButton buttonItem4 = Commands.createMenuItemButton("Wings", 635, 100, Color.green, Color.black);
		panel.add(buttonItem4);
		CustomColorButton buttonItem5 = Commands.createMenuItemButton("Jalapeno Poppers", 5, 210, Color.green, Color.black);
		panel.add(buttonItem5);
		CustomColorButton buttonItem6 = Commands.createMenuItemButton("Fried Pickles", 215, 210, Color.green, Color.black);
		panel.add(buttonItem6);
		
		panel.setBounds(0, 80, (Vars.dimensionFullScreen.width * 2/3), Vars.dimensionFullScreen.height);
	}	
}


