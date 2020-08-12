package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import model.Node;
import model.Stranica;
import model.Workspace;

public class MainFrame extends JFrame {
	
	private static MainFrame instance=null;
	
	
      private Toolbar toolbar;
	
	   private JScrollPane scrollPaneTable;
	   private TableHandler tableHandler;
	   private TreeHandler treeHandler;
	   private Workspace rootOfOurModel;
	   

	   public CardLayout cl;
	   public JPanel panel1;
	   private boolean Citanje = false;
	
	 private MainFrame() {
		 
		 		 
	 }
	 
	 public static MainFrame getInstance(){
			
		 if(instance==null){
			 instance = new MainFrame();
	         instance.initGui();
		 }
		 
		 return instance; 
		 
    } 
	private void initGui()
	{
		 Toolkit kit = Toolkit.getDefaultToolkit();
         Dimension screenSize = kit.getScreenSize();
		 int screenHeight = screenSize.height;
	     int screenWidth = screenSize.width;
	     setSize(screenWidth / 2, screenHeight / 2);
	     setTitle("Multimedijalna knjiga");
	     
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setLocationRelativeTo(null);
	     
	     
	     toolbar=new Toolbar();
	     add(toolbar, BorderLayout.NORTH);
	     
	     
	     
	     this.tableHandler = new TableHandler();
	     scrollPaneTable = new JScrollPane(this.tableHandler.getTable());
	     
	     this.treeHandler = new TreeHandler();
	     this.rootOfOurModel = new Workspace("Workspace", null);
	     this.treeHandler.setRootOfOurModel(this.rootOfOurModel);
	     this.treeHandler.initTree();
	     
	     JScrollPane scrollpanel = new JScrollPane(this.treeHandler.getTree(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 scrollpanel.setPreferredSize(new Dimension(300, 300));
		 add(scrollpanel,BorderLayout.WEST);
		 
		 cl = new CardLayout();
		 JPanel jp=new JPanel();
		 panel1 = new JPanel();
		 
		 panel1.setPreferredSize(new Dimension(400,300));
		 add(panel1,BorderLayout.EAST);
		 panel1.setLayout(cl);
		 
		 panel1.add(jp,"1");
		 panel1.add(scrollPaneTable,"2");
		 cl.show(panel1, "1");
		 
		 
			
	}
		
	

	public JScrollPane getScrollPaneTable() {
		return scrollPaneTable;
	}

	public void setScrollPaneTable(JScrollPane scrollPaneTable) {
		this.scrollPaneTable = scrollPaneTable;
	}

	public TableHandler getTableHandler() {
		return tableHandler;
	}

	public void setTableHandler(TableHandler tableHandler) {
		this.tableHandler = tableHandler;
	}

	public TreeHandler getTreeHandler() {
		return treeHandler;
	}

	public void setTreeHandler(TreeHandler treeHandler) {
		this.treeHandler = treeHandler;
	}

	
	public void setTree1(DefaultTreeModel tree1) {
		this.treeHandler.setModel1(tree1);
	}

	public Toolbar getToolbar() {
		return toolbar;
	}

	public void setToolbar(Toolbar toolbar) {
		this.toolbar = toolbar;
	}

	public boolean isCitanje() {
		return Citanje;
	}

	public void setCitanje(boolean citanje) {
		Citanje = citanje;
	}
	
	
	

}
