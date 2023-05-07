package recommend_menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class BoardUI extends JFrame {
	Member mm=new Member("member1", "member1", "ȸ��1", "�̸���1");
	
	JButton recommend_btn = new JButton("�޴���õ");
	JButton menusearch_btn = new JButton("�޴��˻�");
	JButton favorite_btn = new JButton("���ã��");
	JButton board_btn = new JButton("�Խ���");
	JLabel search_LB=new JLabel("�˻�   : ");
	JComboBox search_CB;
	JTextField search_TF=new JTextField(20);
	JButton search_btn=new JButton("�˻�");
	JButton write_btn=new JButton("�� �ۼ�");
	JTable postlisttable;
	JScrollPane pane;
	
	public BoardUI() throws SQLException {
		setTitle("�޴���õ���α׷�");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		//control Ŭ���� ���� & ȣ��
		BoardSystem BS=new BoardSystem(mm);
		Postlist pl=BS.updatePostlist();
		Post[] pll=pl.get_postlist();
		
		String header[]= {"��ȣ", "����", "����", "�ۼ���","�ۼ��Ͻ�"};
		String[][] conts;
		conts=new String[pll.length][header.length];
		
		for(int i=0; i<pll.length; i++) {
			conts[i][0]=Integer.toString(pll[i].get_postnum());
			conts[i][1]=pll[i].get_title();
			conts[i][2]=pll[i].get_contents();
			conts[i][3]=pll[i].get_writer();
			conts[i][4]=pll[i].get_writetime();
		}
		DefaultTableModel model=new DefaultTableModel(conts, header) {
			public boolean isCellEditable(int i, int c){ return false; }
		};
		
		postlisttable=new JTable(model);
		
		pane=new JScrollPane(postlisttable);		
		
		// �÷� ������ ����
		postlisttable.getColumnModel().getColumn(0).setPreferredWidth(40);
		postlisttable.getColumnModel().getColumn(1).setPreferredWidth(100);
		postlisttable.getColumnModel().getColumn(2).setPreferredWidth(250);
		postlisttable.getColumnModel().getColumn(3).setPreferredWidth(70);
		postlisttable.getColumnModel().getColumn(4).setPreferredWidth(120);
		
		//�޺��ڽ� ��������
		String[] kinds= {"����", "����", "�ۼ���"};
		search_CB=new JComboBox(kinds);
		
		//��� ��ġ����
		recommend_btn.setBounds(15,0,140,50);
		menusearch_btn.setBounds(155,0,140,50);
		favorite_btn.setBounds(295,0,140,50);
		board_btn.setBounds(435,0,140,50);
		search_LB.setBounds(180,60,50,30);
		search_CB.setBounds(235,60,70,30);
		search_TF.setBounds(315,60,150,30);
		search_btn.setBounds(480,60,80,30);
		write_btn.setBounds(490,380,80,30);
		pane.setBounds(15,100,560,270);
		
		//��ư�̺�Ʈ�ޱ�
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		search_btn.addActionListener(new ButtonAction());
		write_btn.addActionListener(new ButtonAction());
		postlisttable.addMouseListener(new MouseAction());
		
		//��� �߰�
		c.add(recommend_btn);
		c.add(menusearch_btn);
		c.add(favorite_btn);
		c.add(board_btn);
		c.add(search_TF);
		c.add(search_btn);
		c.add(search_LB);	
		c.add(pane);
		c.add(write_btn);
		c.add(search_CB);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class MouseAction extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==2) {
				int row=postlisttable.getSelectedRow();
				TableModel mmm=postlisttable.getModel();
				Post post=new Post(Integer.valueOf(mmm.getValueAt(row, 0).toString()), mmm.getValueAt(row, 1).toString(), mmm.getValueAt(row, 2).toString(), mmm.getValueAt(row, 3).toString(), mmm.getValueAt(row, 4).toString());
				ContentUI CUI=new ContentUI(mm, post);
			}
		}
	}
	
	private class ButtonAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str = "";
			//�˻���ư Ŭ��
			if(e.getSource()==search_btn) {
				//control Ŭ���� ����
				BoardSystem BS=new BoardSystem(mm);
				
				str=search_CB.getSelectedItem().toString();
				String str2="%"+search_TF.getText()+"%";
				
				Postlist p;
				Post[] pll = null;
				try {
					pll = BS.searchPost(str, str2); //control Ŭ���� searchPost ȣ��
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String header[]= {"��ȣ", "����", "����", "�ۼ���","�ۼ��Ͻ�"};
				String[][] conts;
				conts=new String[pll.length][header.length];
				
				for(int i=0; i<pll.length; i++) {
					conts[i][0]=Integer.toString(pll[i].get_postnum());
					conts[i][1]=pll[i].get_title();
					conts[i][2]=pll[i].get_contents();
					conts[i][3]=pll[i].get_writer();
					conts[i][4]=pll[i].get_writetime();
				}		
				DefaultTableModel model=new DefaultTableModel(conts, header) {
					public boolean isCellEditable(int i, int c){ return false; }
				};
				
				postlisttable=new JTable(model);
				// �÷� ������ ����
				postlisttable.getColumnModel().getColumn(0).setPreferredWidth(40);
				postlisttable.getColumnModel().getColumn(1).setPreferredWidth(100);
				postlisttable.getColumnModel().getColumn(2).setPreferredWidth(250);
				postlisttable.getColumnModel().getColumn(3).setPreferredWidth(70);
				postlisttable.getColumnModel().getColumn(4).setPreferredWidth(120);

				pane.setViewportView(postlisttable);
				postlisttable.addMouseListener(new MouseAction());
			}
			//���ۼ���ư Ŭ��
			else if(e.getSource()==write_btn) {
				WritePostUI WPUI=new WritePostUI(mm);
				dispose();
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
		BoardUI BUI = new BoardUI();
	}

}
