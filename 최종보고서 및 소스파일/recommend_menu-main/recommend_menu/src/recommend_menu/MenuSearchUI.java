package recommend_menu;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuSearchUI extends JFrame {
	String[] mainvalue = null;
	String[] midvalue = null;

	JButton recommend_btn = new JButton("�޴���õ");
	JButton menusearch_btn = new JButton("�޴��˻�");
	JButton favorite_btn = new JButton("���ã��");
	JButton board_btn = new JButton("�Խ���");
	JButton m_search_btn = new JButton("�˻�");
	JComboBox m1_combo;
	JComboBox m2_combo;
	JTable result_TB;
	JScrollPane pane;
	
	
	public MenuSearchUI() throws SQLException {
		setTitle("�޴� ��õ ���α׷�");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		MenuList ml=new MenuList();
		Menu[] menu=ml.getmenulist();
		List<String> mainvalue = new ArrayList<String>();
		mainvalue.add("");
		for(int i=0; i<menu.length; i++) {
			if(!mainvalue.contains(menu[i].get_maincategory()))	// list�� ���ԵǾ��ִ��� �ƴ��� üũ
				mainvalue.add(menu[i].get_maincategory());		// �ش� ���� ������ �ֱ�
		}
		Collections.sort(mainvalue);
		m1_combo = new JComboBox(mainvalue.toArray());
		
		List<String> midvalue=new ArrayList<String>();
		midvalue.add("");
		for(int i=0; i<menu.length; i++) {
			if(menu[i].get_maincategory().equals(m1_combo.getSelectedItem().toString()) && !midvalue.contains(menu[i].get_subcategory()))
				midvalue.add(menu[i].get_subcategory());
		}
		Collections.sort(midvalue);
		m2_combo = new JComboBox(midvalue.toArray());
		
		c.add(recommend_btn);
		c.add(menusearch_btn);
		c.add(favorite_btn);
		c.add(board_btn);
		c.add(m_search_btn);
		c.add(m1_combo);
		c.add(m2_combo);
		String header[]= {"�޴�", "��з�", "�Һз�"};
		String contents[][]= {};
		result_TB=new JTable(contents, header);
		pane=new JScrollPane(result_TB);
		c.add(pane);
		
		JLabel lb1=new JLabel("��з�");
		JLabel lb2=new JLabel("�Һз�");
		JLabel lb3=new JLabel("�˻����");
		c.add(lb1);
		c.add(lb2);
		c.add(lb3);
		
		//��ġ
		recommend_btn.setBounds(15,0,140,50);
		menusearch_btn.setBounds(155,0,140,50);
		favorite_btn.setBounds(295,0,140,50);
		board_btn.setBounds(435,0,140,50);
		m_search_btn.setBounds(470,120,90,50);
		m1_combo.setBounds(20,120,200,50);
		m2_combo.setBounds(230,120,200,50);
		pane.setBounds(150,230,300,100);
		lb1.setBounds(100,80,60,30);
		lb2.setBounds(300,80,60,30);
		lb3.setBounds(275,195,70,30);
		
		//button�׼�
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		m_search_btn.addActionListener(new ButtonAction());
		m1_combo.addItemListener(new ItemAction());
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class ItemAction implements ItemListener{
		int kk=0;
		public void itemStateChanged(ItemEvent arg0) {
			kk++;
			if(kk%2==0) {
				m2_combo.removeAllItems();
				try {
					MenuList ml=new MenuList();
					Menu[] menu=ml.getmenulist();					
					List<String> midvalue=new ArrayList<String>();
					midvalue.add("");
					for(int i=0; i<menu.length; i++) {
						if(menu[i].get_maincategory().equals(m1_combo.getSelectedItem().toString()) && !midvalue.contains(menu[i].get_subcategory()))
							midvalue.add(menu[i].get_subcategory());
					}
					for(int i=0; i<midvalue.toArray().length; i++) {
						m2_combo.addItem(midvalue.toArray()[i]);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//�˻���ư Ŭ��
			if(e.getSource()==m_search_btn){
				String maincategory=m1_combo.getSelectedItem().toString();
				String subcategory=m2_combo.getSelectedItem().toString();
				try {
					MenuSearchSystem MSS=new MenuSearchSystem();
					Menu[] mm=MSS.SearchMenu(maincategory, subcategory);
					String contents[][]=new String[mm.length][3];
					for(int i=0; i<mm.length; i++) {
						contents[i][0]=mm[i].getname();
						contents[i][1]=mm[i].get_maincategory();
						contents[i][2]=mm[i].get_subcategory();
					}
					String header[]= {"�޴�", "��з�", "�Һз�"};
					result_TB=new JTable(contents, header);
					pane.setViewportView(result_TB);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//�޴���õ��ư Ŭ��
			else if(e.getSource()==recommend_btn) {
				try {
					RecommendUI RUI = new RecommendUI();
					dispose();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			//�޴��˻���ư Ŭ��
			else if(e.getSource()==menusearch_btn) {
				try {
					MenuSearchUI MUI = new MenuSearchUI();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			//���ã���ư Ŭ��
			else if(e.getSource()==favorite_btn) {
				
			}
			
			//�Խ��ǹ�ư Ŭ��
			else if(e.getSource()==board_btn) {
				try {
					BoardUI BUI = new BoardUI();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		MenuSearchUI MUI = new MenuSearchUI();
	}
}