package view;

import javax.swing.*;
import java.awt.*;

public class MovieAdminTab extends JPanel {
	public static JTabbedPane tabbedPane;
	protected static MovieTable movietable;

	public MovieAdminTab() {
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.addTab("���ģʽ", movietable = new MovieTable());
		tabbedPane.addTab("����¼�¼", new MovieAdd());


		add(tabbedPane);


	}

}
