package recommend_menu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ContentUI extends JFrame {
	Member mm;
	Post pp;
	JLabel postnumlabel=new JLabel();
	JLabel writerlable=new JLabel();
	JLabel writetimelabel=new JLabel();
	JButton recommend_btn = new JButton("�޴���õ");
	JButton menusearch_btn = new JButton("�޴��˻�");
	JButton favorite_btn = new JButton("���ã��");
	JButton board_btn = new JButton("�Խ���");
	JLabel title_LB = new JLabel("����   : ");
	JTextField title_TF = new JTextField(30);
	JLabel contents_LB = new JLabel("����   : ");	
	TextArea contents_TA = new TextArea();
	JButton del_btn = new JButton("�� ����");
	JButton adjust_btn = new JButton("�� ����");
	
	public ContentUI(Member mm, Post post) {
		this.mm=mm;
		this.pp=post;
		setTitle("�޴���õ���α׷�");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		postnumlabel.setText("��ȣ : "+Integer.toString(pp.get_postnum()));
		writerlable.setText("�ۼ��� : "+pp.get_writer());
		writetimelabel.setText("�ۼ��Ͻ� : "+pp.get_writetime());
		
		//��� ��ġ����
		postnumlabel.setBounds(100,50,100,30);
		writerlable.setBounds(200,50,150,30);
		writetimelabel.setBounds(350,50,200,30);
		recommend_btn.setBounds(15,0,140,50);
		menusearch_btn.setBounds(155,0,140,50);
		favorite_btn.setBounds(295,0,140,50);
		board_btn.setBounds(435,0,140,50);
		title_LB.setBounds(40,75,50,30);
		title_TF.setBounds(90,75,450,30);
		title_TF.setText(pp.get_title());
		title_TF.setEnabled(false);
		contents_LB.setBounds(40,123,50,30);
		contents_TA.setBounds(90,123,450,230);
		contents_TA.setEnabled(false);
		contents_TA.append(pp.get_contents());
		del_btn.setBounds(350,375,90,30);
		adjust_btn.setBounds(470,375,90,30);
		
		//��ư�̺�Ʈ�ޱ�
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		del_btn.addActionListener(new ButtonAction());
		adjust_btn.addActionListener(new ButtonAction());
		
		//��� �߰�
		c.add(recommend_btn);
		c.add(menusearch_btn);
		c.add(favorite_btn);
		c.add(board_btn);
		c.add(title_LB);
		c.add(title_TF);
		c.add(contents_LB);
		c.add(contents_TA);
		c.add(del_btn);
		c.add(adjust_btn);
		c.add(postnumlabel);
		c.add(writerlable);
		c.add(writetimelabel);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// ���� ��ư Ŭ��
			if(e.getSource()==del_btn) {
				// ����ڿ� �ۼ��ڰ� ������
				if(mm.getID().equals(pp.get_writer())) {
					int result = JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "�Խù� ����", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						// Ȯ��, ��Ұ� �ƴ� X�� ���� ��� (��� �ۼ�)
					} else if (result == JOptionPane.YES_OPTION) { 
						// Ȯ���� �������(����)
						BoardSystem BS=new BoardSystem(mm);
						try {
							int num=BS.delPost(pp);
							if(num>0) {
								JOptionPane.showMessageDialog(null, "���� �����Ǿ����ϴ�.", "�Խù� ����", JOptionPane.INFORMATION_MESSAGE);
								BoardUI BUI=new BoardUI();
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {	// ��Ҹ� ���� ���
					}
				}
				// �ۼ��ڿ� ����ڰ� ���� ������
				else JOptionPane.showMessageDialog(null, "�ۼ��ڰ� �ƴմϴ�.", "error", JOptionPane.INFORMATION_MESSAGE);
			} else if(e.getSource()==adjust_btn) {
				// ���� ��ư Ŭ��
				if(mm.getID().equals(pp.get_writer())) {
					WritePostUI WPUI=new WritePostUI(mm, pp);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "�ۼ��ڰ� �ƴմϴ�.", "error", JOptionPane.INFORMATION_MESSAGE);
				
				////////////////��ܹ�ư//////////////////////
			} else if(e.getSource()==recommend_btn) {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ContentUI CUI=new ContentUI();
	}

}
