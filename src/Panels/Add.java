package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Commands.Commands;
import Commands.SQL;
import HomePanels.Ticket;
import Main.Main;
import Main.MenuItemButton;
import Vars.Vars;

public class Add{

	public static JPanel panel = new JPanel();
	public static String table = "Opt_ALL";
	public static ArrayList<String> items;
	public static ArrayList<String> tables;
	public static MenuItemButton buttonFinished;

	public static void createView(Graphics g) {
		panel.setLayout(null);
		panel.setBackground(Vars.colorMainBG);
		
		
		buttonFinished = new MenuItemButton(Vars.colorDefaultButton, Vars.colorDefaultFont);
		buttonFinished.setText("Finished");
		buttonFinished.setFont(Commands.changeFontSize(15));
		buttonFinished.setBounds(Vars.dimensionFullScreen.width - 125, Vars.dimensionFullScreen.height - 90, 100, 50);
		panel.add(buttonFinished);
		
		panel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				Commands.switchPanels(Main.panelAdd, Main.panelHome);
				Home.panel.add(Ticket.panel);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tables = SQL.returnAllContents();

		if (tables.contains(table)) {
			items = SQL.returnTableContents(table, "Options");
		} else {
			items = new ArrayList<String>();
		}

		ArrayList<MenuItemButton> itemButtons = new ArrayList<MenuItemButton>();
		for (int i = 0; i < (items.size() / 9) + 1; i++) {
			for (int j = 0; j < 9; j++) {
				int currentIndex = (i * 9) + j;
				if (!(currentIndex >= items.size())) {
					itemButtons.add(Commands.createOptionItemButton(items.get(currentIndex), 5 + (j * 100), 5 + (i * 105)));

					String nameOfOption = items.get(currentIndex);
					itemButtons.get(currentIndex).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Commands.addToTicket(Commands.ticketSpacing(nameOfOption, Double.parseDouble(SQL.returnPriceOfOption(table, nameOfOption)), true),Double.parseDouble(SQL.returnPriceOfOption(table, nameOfOption)));
						}
					});
					panel.add(itemButtons.get(currentIndex));
				}
			}
		}
		panel.setBounds(0, 0, Vars.dimensionFullScreen.width, Vars.dimensionFullScreen.height);
	}

}
