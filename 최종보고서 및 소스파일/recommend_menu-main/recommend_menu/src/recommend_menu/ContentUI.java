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
	JButton recommend_btn = new JButton("메뉴추천");
	JButton menusearch_btn = new JButton("메뉴검색");
	JButton favorite_btn = new JButton("즐겨찾기");
	JButton board_btn = new JButton("게시판");
	JLabel title_LB = new JLabel("제목   : ");
	JTextField title_TF = new JTextField(30);
	JLabel contents_LB = new JLabel("내용   : ");	
	TextArea contents_TA = new TextArea();
	JButton del_btn = new JButton("글 삭제");
	JButton adjust_btn = new JButton("글 수정");
	
	public ContentUI(Member mm, Post post) {
		this.mm=mm;
		this.pp=post;
		setTitle("메뉴추천프로그램");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		postnumlabel.setText("번호 : "+Integer.toString(pp.get_postnum()));
		writerlable.setText("작성자 : "+pp.get_writer());
		writetimelabel.setText("작성일시 : "+pp.get_writetime());
		
		//요소 위치지정
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
		
		//버튼이벤트달기
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		del_btn.addActionListener(new ButtonAction());
		adjust_btn.addActionListener(new ButtonAction());
		
		//요소 추가
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
			// 삭제 버튼 클릭
			if(e.getSource()==del_btn) {
				// 사용자와 작성자가 같으면
				if(mm.getID().equals(pp.get_writer())) {
					int result = JOptionPane.showConfirmDialog(null, "글을 삭제하시겠습니까?", "게시물 삭제", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						// 확인, 취소가 아닌 X로 닫은 경우 (계속 작성)
					} else if (result == JOptionPane.YES_OPTION) { 
						// 확인을 누른경우(삭제)
						BoardSystem BS=new BoardSystem(mm);
						try {
							int num=BS.delPost(pp);
							if(num>0) {
								JOptionPane.showMessageDialog(null, "글이 삭제되었습니다.", "게시물 삭제", JOptionPane.INFORMATION_MESSAGE);
								BoardUI BUI=new BoardUI();
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {	// 취소를 누른 경우
					}
				}
				// 작성자와 사용자가 같지 않으면
				else JOptionPane.showMessageDialog(null, "작성자가 아닙니다.", "error", JOptionPane.INFORMATION_MESSAGE);
			} else if(e.getSource()==adjust_btn) {
				// 수정 버튼 클릭
				if(mm.getID().equals(pp.get_writer())) {
					WritePostUI WPUI=new WritePostUI(mm, pp);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "작성자가 아닙니다.", "error", JOptionPane.INFORMATION_MESSAGE);
				
				////////////////상단버튼//////////////////////
			} else if(e.getSource()==recommend_btn) {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ContentUI CUI=new ContentUI();
	}

}
