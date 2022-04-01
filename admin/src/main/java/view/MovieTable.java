package view;

import model.BaseDao;
import model.MovieDAO;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class MovieTable extends JPanel {

	// rowData�������������
	// columnNames�������

	private final JPanel p1_1;
	Vector columnNames;
	JTable jt = null;
	JScrollPane jsp = null;
	ResultSetMetaData rsmd;
	BaseDao db;
	JPanel p1;
	JPanel p2;
	JButton jbaddnew;
	JButton jbdel;
	// JComboBox scorecb;
	JTextField[] t;

	Vector movies;
	MovieDAO movieDAO = new MovieDAO();

	public MovieTable() {
		setLayout(new BorderLayout());

		p1 = new JPanel();
//		p2 = new JPanel();
		// panel.add(new JButton("����һ��"));
		columnNames = new Vector<String>();
		tableDataload();


		// ��ʼ��Jtable
		DefaultTableModel jtm = new DefaultTableModel(movies, columnNames);

		jt = new JTable(jtm);

		// ��ʼ�� jsp
		jsp = new JScrollPane(jt);

		// ��jsp���뵽jframe
		this.add(jsp, "Center");


		p1_1 = new JPanel();
		p2 = new JPanel();
		jbdel = new JButton("ɾ��һ��");


		p1_1.setLayout(new GridLayout(10, 2, 5, 5));
		jbaddnew = new JButton("����һ��");

		// jt.setVisible(false);
		p1_1.add(jbaddnew);
		p1_1.add(jbdel);
		add(p1_1, BorderLayout.EAST);

		JButton jbreload = new JButton("\u5237\u65B0");
		p1_1.add(jbreload);
//		add(p2, "North");

		this.setSize(800, 600);

//		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		Menu.setStatus("��Ӱ��Ϣ����");
		this.setVisible(true);


		jbdel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand() == "ɾ��һ��") {
					if (jt.getSelectedRow() == -1)
//						javax.swing.JOptionPane.showMessageDialog(null,"111");
						Menu.setStatus("δѡ��ɾ������");

					else {
						int row = jt.getSelectedRow();
						String col = (String) jt.getValueAt(row, 0);
						int id = Integer.valueOf(col);

						if (new MovieDAO().del(id)) {
							Menu.setStatus("ɾ���гɹ�");
						} else {
							Menu.setStatus("ɾ����ʧ��");
						}

						tablereload();
					}
				}

			}
//			public boolean del(String p[]) {
//				try {
//
//					String sql = "delete from movie where id=?";
//
//					if (db.executeUpdate(sql, p) > 0)
//						return true;
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return false;
//			}

		});

		jbaddnew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == "����һ��") {
//					String[] p = new String[t.length];
//					Vector h = new Vector();
//					for (int i = 0; i < t.length; i++) {
//
//						p[i] = t[i].getText();
//						// hang.add(p[i]);
//					}
//					// jtm.addRow(hang);
//					if(add(p)) {
//						Menu.setStatus("�����гɹ�");
//					}
//
//					tablereload();


					MovieAdminTab.tabbedPane.setSelectedIndex(1);
				}

			}


//			public boolean add(String p[]) {
//				try {
//
//					String sql = "insert into moive(title,score,info,img) values(?,?,?,?)";
//
//					if (db.executeUpdate(sql, p) > 0)
//						return true;
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return false;
//			}

		});

		jbreload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tablereload();
			}
		});

		jtm.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int row = jt.convertRowIndexToView(e.getFirstRow());
				try {
					// for(int i=1;i<GetInfo.this.rsmd.getColumnCount();i++) {
					// System.out.println(e.getColumn());
					String sql = "update movie set "
							+ rsmd.getColumnName(e.getColumn() + 1) + "='"
							+ jt.getValueAt(e.getFirstRow(), e.getColumn())
							+ "' where " + rsmd.getColumnName(1) + "='"
							+ jt.getValueAt(row, 0) + "'";
					db.executeUpdate(sql, null);


					// System.out.println(sql);
					// }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

	}

	public void tablereload() {


		tableDataload();

		jt.revalidate();
	}

	private void tableDataload() {
		// TODO Auto-generated method stub
		db = new BaseDao();
		if (movies == null) {
			movies = new Vector();
		}
		movies.clear();
		try {
			ResultSet rs;
//		String sql = "select id,title,score,title_sub,story,classid,releasetime,duration,regionid,langid from movie";
			String sql = "select * from movie";
			rs = db.executeQuery(sql, null);
			rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				columnNames.add(rsmd.getColumnName(i));
			}
			while (rs.next()) {
				// rowData�����ݣ����Դ�Ŷ���
				Vector hang = new Vector();
				for (int i = 1; i <= rsmd.getColumnCount(); i++)
					hang.add(rs.getString(i));
				// ���뵽rowData
				movies.add(hang);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}

