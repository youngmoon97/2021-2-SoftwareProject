package recommend_menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class RecommendUI extends JFrame{	
	String[] midvalue=null;
	
	JButton recommend_btn = new JButton("�޴���õ");
	JButton menusearch_btn = new JButton("�޴��˻�");
	JButton favorite_btn = new JButton("���ã��");
	JButton board_btn = new JButton("�Խ���");
	JButton randomdice_btn=new JButton("������õ");
	JTextField resultfield = new JTextField(30);
	JComboBox cbb_main;
	JComboBox cbb_mid;
	
	
	public RecommendUI() throws SQLException {
		setTitle("�޴���õ���α׷�");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 400);
		
		MenuList ml=new MenuList();
		Menu[] menu=ml.getmenulist();
		List<String> mainvalue = new ArrayList<String>();
		mainvalue.add("");
		for(int i=0; i<menu.length; i++) {
			if(!mainvalue.contains(menu[i].get_maincategory()))	// list�� ���ԵǾ��ִ��� �ƴ��� üũ
				mainvalue.add(menu[i].get_maincategory());		// �ش� ���� ������ �ֱ�
		}
		Collections.sort(mainvalue);		
		cbb_main = new JComboBox(mainvalue.toArray());
		
		List<String> midvalue=new ArrayList<String>();
		midvalue.add("");
		for(int i=0; i<menu.length; i++) {
			if(menu[i].get_maincategory().equals(cbb_main.getSelectedItem().toString()) && !midvalue.contains(menu[i].get_subcategory()))
				midvalue.add(menu[i].get_subcategory());
		}
		Collections.sort(midvalue);
		cbb_mid = new JComboBox(midvalue.toArray());
		
		JLabel lb1=new JLabel("��з�  :");
		JLabel lb2=new JLabel("�Һз�  :");
		
		//��� ��ġ����
		recommend_btn.setBounds(15,0,140,50);
		menusearch_btn.setBounds(155,0,140,50);
		favorite_btn.setBounds(295,0,140,50);
		board_btn.setBounds(435,0,140,50);
		cbb_main.setBounds(150,120,150,50);
		cbb_mid.setBounds(150,220,150,50);
		randomdice_btn.setBounds(380, 120,100,50);
		resultfield.setBounds(380,220,100,50);
		resultfield.setEnabled(false);
		lb1.setBounds(80,130,70,30);
		lb2.setBounds(80,230,70,30);

		
		//��ư�̺�Ʈ�ޱ�
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		randomdice_btn.addActionListener(new ButtonAction());
		cbb_main.addItemListener(new ItemAction());
		
		//��� �߰�
		c.add(recommend_btn);
		c.add(menusearch_btn);
		c.add(favorite_btn);
		c.add(board_btn);
		c.add(randomdice_btn);
		c.add(cbb_main);
		c.add(cbb_mid);
		c.add(resultfield);
		c.add(lb1);
		c.add(lb2);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//��з�,�ߺз�����Ʈ�ޱ��޺��ڽ�
	
	private class ItemAction implements ItemListener{
		int kk=0;
		
		public void itemStateChanged(ItemEvent arg0) {
			kk++;
			if(kk%2==0) {
				cbb_mid.removeAllItems();
				try {
					MenuList ml=new MenuList();
					Menu[] menu=ml.getmenulist();					
					List<String> midvalue=new ArrayList<String>();
					midvalue.add("");
					for(int i=0; i<menu.length; i++) {
						if(menu[i].get_maincategory().equals(cbb_main.getSelectedItem().toString()) && !midvalue.contains(menu[i].get_subcategory()))
							midvalue.add(menu[i].get_subcategory());
					}
					for(int i=0; i<midvalue.toArray().length; i++) {
						cbb_mid.addItem(midvalue.toArray()[i]);
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
			//������ư Ŭ��
			if(e.getSource()==randomdice_btn) {
				//control Ŭ���� ����
				String maincatagory = cbb_main.getSelectedItem().toString();
				String middleclass = cbb_mid.getSelectedItem().toString();
				RecommendSystem rs=new RecommendSystem();
				try {
					String finalresult = rs.recommend(maincatagory, middleclass);
					resultfield.setText(finalresult);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			
			////////////////��ܹ�ư//////////////////////
			//��� �޴���õ��ư Ŭ��
			else if(e.getSource()==recommend_btn) {
				try {
					RecommendUI RUI = new RecommendUI();
					dispose();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			//��� �޴��˻���ư Ŭ��
			else if(e.getSource()==menusearch_btn) {
				try {
					MenuSearchUI MUI = new MenuSearchUI();
					dispose();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			//��� ���ã���ư Ŭ��
			else if(e.getSource()==favorite_btn) {
				
			}
			//��� �Խ��ǹ�ư Ŭ��
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
		// TODO Auto-generated method stub
		RecommendUI RUI = new RecommendUI();
	}
}