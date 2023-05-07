package recommend_menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class WritePostUI extends JFrame {
	Member mm=null;
	Post pp=null;
	JButton recommend_btn = new JButton("�޴���õ");
	JButton menusearch_btn = new JButton("�޴��˻�");
	JButton favorite_btn = new JButton("���ã��");
	JButton board_btn = new JButton("�Խ���");
	JLabel title_LB = new JLabel("����   : ");
	JTextField title_TF = new JTextField(30);
	JLabel contents_LB = new JLabel("����   : ");	
	TextArea contents_TA = new TextArea();
	JButton CANCEL_btn = new JButton("�ۼ� ���");
	JButton OK_btn = new JButton("�� �ۼ�");
	
	
	public WritePostUI(Member mm) {
		//�α����� ȸ�� ������ �ۼ� ȭ�鿡 �Ѱ���
		this.mm=mm;
		setTitle("�޴���õ���α׷�");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		//��� ��ġ����
		recommend_btn.setBounds(0,0,150,50);
		menusearch_btn.setBounds(150,0,150,50);
		favorite_btn.setBounds(300,0,150,50);
		board_btn.setBounds(450,0,150,50);
		title_LB.setBounds(40,75,50,30);
		title_TF.setBounds(90,75,450,30);
		contents_LB.setBounds(40,123,50,30);
		contents_TA.setBounds(90,123,450,230);
		CANCEL_btn.setBounds(350,375,90,30);
		OK_btn.setBounds(470,375,90,30);
		
		//��ư�̺�Ʈ�ޱ�
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		CANCEL_btn.addActionListener(new ButtonAction());
		OK_btn.addActionListener(new ButtonAction());
		
		//��� �߰�
		c.add(recommend_btn);
		c.add(menusearch_btn);
		c.add(favorite_btn);
		c.add(board_btn);
		c.add(title_LB);
		c.add(title_TF);
		c.add(contents_LB);
		c.add(contents_TA);
		c.add(CANCEL_btn);
		c.add(OK_btn);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//�Խù� ������ �ۼ� ȭ��
	public WritePostUI(Member mm, Post post) {
		//�α����� ȸ�� ������ �ۼ� ȭ�鿡 �Ѱ���
		this.mm=mm;
		this.pp=post;
		setTitle("�޴���õ���α׷�");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		CANCEL_btn.setText("���� ���");
		OK_btn.setText("�� ����");
		
		//��� ��ġ����
		recommend_btn.setBounds(0,0,150,50);
		menusearch_btn.setBounds(150,0,150,50);
		favorite_btn.setBounds(300,0,150,50);
		board_btn.setBounds(450,0,150,50);
		title_LB.setBounds(40,75,50,30);
		title_TF.setBounds(90,75,450,30);
		title_TF.setText(pp.get_title());
		contents_LB.setBounds(40,123,50,30);
		contents_TA.setBounds(90,123,450,230);
		contents_TA.append(pp.get_contents());
		CANCEL_btn.setBounds(350,375,90,30);
		OK_btn.setBounds(470,375,90,30);
		
		//��ư�̺�Ʈ�ޱ�
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		CANCEL_btn.addActionListener(new ButtonAction());
		OK_btn.addActionListener(new ButtonAction());
		
		//��� �߰�
		c.add(recommend_btn);
		c.add(menusearch_btn);
		c.add(favorite_btn);
		c.add(board_btn);
		c.add(title_LB);
		c.add(title_TF);
		c.add(contents_LB);
		c.add(contents_TA);
		c.add(CANCEL_btn);
		c.add(OK_btn);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// �ۼ� ��� ��ư Ŭ��
			if(e.getSource()==CANCEL_btn) {
				if(CANCEL_btn.getText().equals("�ۼ� ���")) {
				int result = JOptionPane.showConfirmDialog(null, "�� �ۼ��� ����Ͻðڽ��ϱ�?", "�Խù� �ۼ�", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					// Ȯ��, ��Ұ� �ƴ� X�� ���� ��� (��� �ۼ�)
				} else if (result == JOptionPane.YES_OPTION) { 
					// Ȯ���� �������(�ۼ� ���)
					try {
						BoardUI BUI=new BoardUI();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					// ��Ҹ� ���� ���(��� �ۼ�)
				}	
				}
				else if(CANCEL_btn.getText().equals("���� ���")) {
					int result = JOptionPane.showConfirmDialog(null, "������ ����Ͻðڽ��ϱ�?", "�Խù� ����", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						// Ȯ��, ��Ұ� �ƴ� X�� ���� ��� (��� �ۼ�)
					} else if (result == JOptionPane.YES_OPTION) { 
						ContentUI CUI=new ContentUI(mm, pp);
						dispose();
					} else {
						// ��Ҹ� ���� ���(��� �ۼ�)
					}	
				}
			} else if(e.getSource()==OK_btn) {
				// �ۼ��ϱ� ��ư Ŭ��
				if(OK_btn.getText().equals("�� �ۼ�")) {
					if ("".equals(title_TF.getText())) {
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Խù� �ۼ�", JOptionPane.INFORMATION_MESSAGE);
					} else if ("".equals(contents_TA.getText())) { 
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Խù� �ۼ�", JOptionPane.INFORMATION_MESSAGE);
					} else {
						BoardSystem BS=new BoardSystem(mm);
						try {
							Post post=new Post(0, title_TF.getText(), contents_TA.getText(), mm.getID(), null);
							int num=BS.writePost(post); 
							if(num>0) {
								JOptionPane.showMessageDialog(null, "���� �ۼ��Ǿ����ϴ�.", "�Խù� �ۼ�", JOptionPane.INFORMATION_MESSAGE);
								BoardUI BUI=new BoardUI();
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else if(OK_btn.getText().equals("�� ����")) {
					if ("".equals(title_TF.getText())) {
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Խù� ����", JOptionPane.INFORMATION_MESSAGE);
					} else if ("".equals(contents_TA.getText())) { 
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "�Խù� ����", JOptionPane.INFORMATION_MESSAGE);
					} else {
						BoardSystem BS=new BoardSystem(mm);
						pp.set_title(title_TF.getText());
						pp.set_contents(contents_TA.getText());
						int num;
						try {
							num = BS.adjustPost(pp);
							if(num>0) {
								JOptionPane.showMessageDialog(null, "���� �����Ǿ����ϴ�.", "�Խù� ����", JOptionPane.INFORMATION_MESSAGE);
								ContentUI CUI=new ContentUI(mm, pp);
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				}
				////////////////��ܹ�ư//////////////////////
			} else if(e.getSource()==recommend_btn) {
				//��� �޴���õ��ư Ŭ��
				int result = JOptionPane.showConfirmDialog(null, "�� �ۼ��� ����ϰ� �ٸ� �޴��� �̵��Ͻðڽ��ϱ�?", "�Խù� �ۼ�", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					// Ȯ���� �������(�ۼ� ���)
					try {
						RecommendUI RUI = new RecommendUI();
						dispose();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else if(e.getSource()==menusearch_btn) {
				//��� �޴��˻���ư Ŭ��
				int result = JOptionPane.showConfirmDialog(null, "�� �ۼ��� ����ϰ� �ٸ� �޴��� �̵��Ͻðڽ��ϱ�?", "�Խù� �ۼ�", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					try {
						MenuSearchUI MUI = new MenuSearchUI();
						dispose();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else if(e.getSource()==favorite_btn) {
				/*
				//��� ���ã���ư Ŭ��
				int result = JOptionPane.showConfirmDialog(null, "�� �ۼ��� ����ϰ� �ٸ� �޴��� �̵��Ͻðڽ��ϱ�?", "�Խù� �ۼ�", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					// Ȯ���� �������(�ۼ� ���)
					dispose();
				}
				*/
			} else if(e.getSource()==board_btn) {
				//��� �Խ��ǹ�ư Ŭ��
				int result = JOptionPane.showConfirmDialog(null, "�� �ۼ��� ����ϰ� �ٸ� �޴��� �̵��Ͻðڽ��ϱ�?", "�Խù� �ۼ�", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					// Ȯ���� �������(�ۼ� ���)
					try {
						BoardUI BUI=new BoardUI();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new WritePostUI();
	}
}
