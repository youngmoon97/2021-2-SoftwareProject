package recommend_menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class BoardUI extends JFrame {
	Member mm=new Member("member1", "member1", "회원1", "이메일1");
	
	JButton recommend_btn = new JButton("메뉴추천");
	JButton menusearch_btn = new JButton("메뉴검색");
	JButton favorite_btn = new JButton("즐겨찾기");
	JButton board_btn = new JButton("게시판");
	JLabel search_LB=new JLabel("검색   : ");
	JComboBox search_CB;
	JTextField search_TF=new JTextField(20);
	JButton search_btn=new JButton("검색");
	JButton write_btn=new JButton("글 작성");
	JTable postlisttable;
	JScrollPane pane;
	
	public BoardUI() throws SQLException {
		setTitle("메뉴추천프로그램");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		//control 클래스 생성 & 호출
		BoardSystem BS=new BoardSystem(mm);
		Postlist pl=BS.updatePostlist();
		Post[] pll=pl.get_postlist();
		
		String header[]= {"번호", "제목", "내용", "작성자","작성일시"};
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
		
		// 컬럼 사이즈 지정
		postlisttable.getColumnModel().getColumn(0).setPreferredWidth(40);
		postlisttable.getColumnModel().getColumn(1).setPreferredWidth(100);
		postlisttable.getColumnModel().getColumn(2).setPreferredWidth(250);
		postlisttable.getColumnModel().getColumn(3).setPreferredWidth(70);
		postlisttable.getColumnModel().getColumn(4).setPreferredWidth(120);
		
		//콤보박스 내용지정
		String[] kinds= {"내용", "제목", "작성자"};
		search_CB=new JComboBox(kinds);
		
		//요소 위치지정
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
		
		//버튼이벤트달기
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		search_btn.addActionListener(new ButtonAction());
		write_btn.addActionListener(new ButtonAction());
		postlisttable.addMouseListener(new MouseAction());
		
		//요소 추가
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
			//검색버튼 클릭
			if(e.getSource()==search_btn) {
				//control 클래스 생성
				BoardSystem BS=new BoardSystem(mm);
				
				str=search_CB.getSelectedItem().toString();
				String str2="%"+search_TF.getText()+"%";
				
				Postlist p;
				Post[] pll = null;
				try {
					pll = BS.searchPost(str, str2); //control 클래스 searchPost 호출
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String header[]= {"번호", "제목", "내용", "작성자","작성일시"};
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
				// 컬럼 사이즈 지정
				postlisttable.getColumnModel().getColumn(0).setPreferredWidth(40);
				postlisttable.getColumnModel().getColumn(1).setPreferredWidth(100);
				postlisttable.getColumnModel().getColumn(2).setPreferredWidth(250);
				postlisttable.getColumnModel().getColumn(3).setPreferredWidth(70);
				postlisttable.getColumnModel().getColumn(4).setPreferredWidth(120);

				pane.setViewportView(postlisttable);
				postlisttable.addMouseListener(new MouseAction());
			}
			//글작성버튼 클릭
			else if(e.getSource()==write_btn) {
				WritePostUI WPUI=new WritePostUI(mm);
				dispose();
			}
			
			////////////////상단버튼//////////////////////
			//상단 메뉴추천버튼 클릭
			else if(e.getSource()==recommend_btn) {
				try {
					RecommendUI RUI = new RecommendUI();
					dispose();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			//상단 메뉴검색버튼 클릭
			else if(e.getSource()==menusearch_btn) {
				try {
					MenuSearchUI MUI = new MenuSearchUI();
					dispose();
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			//상단 즐겨찾기버튼 클릭
			else if(e.getSource()==favorite_btn) {
				
			}
			//상단 게시판버튼 클릭
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
