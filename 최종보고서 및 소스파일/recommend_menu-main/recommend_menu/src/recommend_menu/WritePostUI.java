package recommend_menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class WritePostUI extends JFrame {
	Member mm=null;
	Post pp=null;
	JButton recommend_btn = new JButton("메뉴추천");
	JButton menusearch_btn = new JButton("메뉴검색");
	JButton favorite_btn = new JButton("즐겨찾기");
	JButton board_btn = new JButton("게시판");
	JLabel title_LB = new JLabel("제목   : ");
	JTextField title_TF = new JTextField(30);
	JLabel contents_LB = new JLabel("내용   : ");	
	TextArea contents_TA = new TextArea();
	JButton CANCEL_btn = new JButton("작성 취소");
	JButton OK_btn = new JButton("글 작성");
	
	
	public WritePostUI(Member mm) {
		//로그인한 회원 정보를 작성 화면에 넘겨줌
		this.mm=mm;
		setTitle("메뉴추천프로그램");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		//요소 위치지정
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
		
		//버튼이벤트달기
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		CANCEL_btn.addActionListener(new ButtonAction());
		OK_btn.addActionListener(new ButtonAction());
		
		//요소 추가
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
	
	//게시물 수정시 작성 화면
	public WritePostUI(Member mm, Post post) {
		//로그인한 회원 정보를 작성 화면에 넘겨줌
		this.mm=mm;
		this.pp=post;
		setTitle("메뉴추천프로그램");
		Container c = getContentPane();
		c.setLayout(null);
		setSize(600, 465);
		
		CANCEL_btn.setText("수정 취소");
		OK_btn.setText("글 수정");
		
		//요소 위치지정
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
		
		//버튼이벤트달기
		recommend_btn.addActionListener(new ButtonAction());
		menusearch_btn.addActionListener(new ButtonAction());
		favorite_btn.addActionListener(new ButtonAction());
		board_btn.addActionListener(new ButtonAction());
		CANCEL_btn.addActionListener(new ButtonAction());
		OK_btn.addActionListener(new ButtonAction());
		
		//요소 추가
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
			// 작성 취소 버튼 클릭
			if(e.getSource()==CANCEL_btn) {
				if(CANCEL_btn.getText().equals("작성 취소")) {
				int result = JOptionPane.showConfirmDialog(null, "글 작성을 취소하시겠습니까?", "게시물 작성", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					// 확인, 취소가 아닌 X로 닫은 경우 (계속 작성)
				} else if (result == JOptionPane.YES_OPTION) { 
					// 확인을 누른경우(작성 취소)
					try {
						BoardUI BUI=new BoardUI();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					// 취소를 누른 경우(계속 작성)
				}	
				}
				else if(CANCEL_btn.getText().equals("수정 취소")) {
					int result = JOptionPane.showConfirmDialog(null, "수정을 취소하시겠습니까?", "게시물 수정", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						// 확인, 취소가 아닌 X로 닫은 경우 (계속 작성)
					} else if (result == JOptionPane.YES_OPTION) { 
						ContentUI CUI=new ContentUI(mm, pp);
						dispose();
					} else {
						// 취소를 누른 경우(계속 작성)
					}	
				}
			} else if(e.getSource()==OK_btn) {
				// 작성하기 버튼 클릭
				if(OK_btn.getText().equals("글 작성")) {
					if ("".equals(title_TF.getText())) {
						JOptionPane.showMessageDialog(null, "제목을 입력해주세요.", "게시물 작성", JOptionPane.INFORMATION_MESSAGE);
					} else if ("".equals(contents_TA.getText())) { 
						JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "게시물 작성", JOptionPane.INFORMATION_MESSAGE);
					} else {
						BoardSystem BS=new BoardSystem(mm);
						try {
							Post post=new Post(0, title_TF.getText(), contents_TA.getText(), mm.getID(), null);
							int num=BS.writePost(post); 
							if(num>0) {
								JOptionPane.showMessageDialog(null, "글이 작성되었습니다.", "게시물 작성", JOptionPane.INFORMATION_MESSAGE);
								BoardUI BUI=new BoardUI();
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				else if(OK_btn.getText().equals("글 수정")) {
					if ("".equals(title_TF.getText())) {
						JOptionPane.showMessageDialog(null, "제목을 입력해주세요.", "게시물 수정", JOptionPane.INFORMATION_MESSAGE);
					} else if ("".equals(contents_TA.getText())) { 
						JOptionPane.showMessageDialog(null, "내용을 입력해주세요.", "게시물 수정", JOptionPane.INFORMATION_MESSAGE);
					} else {
						BoardSystem BS=new BoardSystem(mm);
						pp.set_title(title_TF.getText());
						pp.set_contents(contents_TA.getText());
						int num;
						try {
							num = BS.adjustPost(pp);
							if(num>0) {
								JOptionPane.showMessageDialog(null, "글이 수정되었습니다.", "게시물 수정", JOptionPane.INFORMATION_MESSAGE);
								ContentUI CUI=new ContentUI(mm, pp);
								dispose();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				}
				////////////////상단버튼//////////////////////
			} else if(e.getSource()==recommend_btn) {
				//상단 메뉴추천버튼 클릭
				int result = JOptionPane.showConfirmDialog(null, "글 작성을 취소하고 다른 메뉴로 이동하시겠습니까?", "게시물 작성", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					// 확인을 누른경우(작성 취소)
					try {
						RecommendUI RUI = new RecommendUI();
						dispose();
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else if(e.getSource()==menusearch_btn) {
				//상단 메뉴검색버튼 클릭
				int result = JOptionPane.showConfirmDialog(null, "글 작성을 취소하고 다른 메뉴로 이동하시겠습니까?", "게시물 작성", JOptionPane.YES_NO_OPTION);
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
				//상단 즐겨찾기버튼 클릭
				int result = JOptionPane.showConfirmDialog(null, "글 작성을 취소하고 다른 메뉴로 이동하시겠습니까?", "게시물 작성", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					// 확인을 누른경우(작성 취소)
					dispose();
				}
				*/
			} else if(e.getSource()==board_btn) {
				//상단 게시판버튼 클릭
				int result = JOptionPane.showConfirmDialog(null, "글 작성을 취소하고 다른 메뉴로 이동하시겠습니까?", "게시물 작성", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) { 
					// 확인을 누른경우(작성 취소)
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
