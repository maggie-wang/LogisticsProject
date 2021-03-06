package prjX.GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;

import javax.swing.table.TableColumn;

import prjX.database.DBMethods;
import prjX.tablemodels.EmployeeTable;
import prjX.tablemodels.ShipTable;
import prjX.tablemodels.TruckTable;

import javax.swing.table.AbstractTableModel;


public class TruckHandling extends JInternalFrame{
		TruckHandling() throws SQLException{
			JTable table;
			TruckTable dtm;   		    
   			
   			ResultSet rs;
   			//JPanel pane =  new JPanel(new GridLayout());
   			JPanel pane =  new JPanel();
   			JFrame frame = null;
   			JButton search_btn = null, add_btn = null, delete_btn = null;
   			frame = new JFrame("Truck Management");
   			pane = new JPanel();
   			
   		  add_btn = new JButton("Add a Truck");
   		  add_btn.addActionListener(new ActionListener() {
   		   public void actionPerformed(ActionEvent e) {
   		    //addData();
   		   }
   		  });
   		  delete_btn = new JButton("Delete a Truck");
   		  delete_btn.addActionListener(new ActionListener() {
   		   public void actionPerformed(ActionEvent e) {
   		    //saveData();
   		   }
   		  });
   		  search_btn = new JButton("Search a Truck");
   		  	DBMethods methods = new DBMethods();
   			rs = methods.showAllTrucks();
   			
   			if(rs == null){
   				System.out.println("null is rs");
   			}
   			dtm = new TruckTable(rs);
   			table = new JTable(dtm);
   			
   			table.setBounds(100, 100, 580, 260);
   			pane.add((new JScrollPane(dtm.getWholeTable(rs))), BorderLayout.CENTER);
   			pane.add(add_btn, BorderLayout.WEST);
	   		pane.add(delete_btn, BorderLayout.CENTER);
	   		pane.add(search_btn, BorderLayout.CENTER);
	   		  
	   		//pane.add(clean_btn, BorderLayout.EAST);
	   		
			frame.add(pane);
   			frame.setSize(800,600);
   			frame.pack();
   	        frame.setVisible(true);
   	        rs.close();
   	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		}
}