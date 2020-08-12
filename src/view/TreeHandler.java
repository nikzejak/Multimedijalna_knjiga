package view;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import ObserverPackage.EventType;
import ObserverPackage.Observable;
import ObserverPackage.Observer;
import model.Stranica;
import model.Workspace;

public class TreeHandler implements Observer {
	
    private JTree tree;
	
	private DefaultTreeModel treeModel;
	
	private DefaultMutableTreeNode root;
	
	private Workspace rootOfOurModel;
	
	public TreeHandler() {}
	
	public TreeHandler(Workspace workspace) {
		this.rootOfOurModel = workspace;
	}
	
	public TreeHandler(JTree tree, DefaultTreeModel treeModel, 
			DefaultMutableTreeNode root) {
		super();
		this.tree = tree;
		this.treeModel = treeModel;
		this.root = root;
	}

	public void initTree() {	
		
		initData();
		
		this.treeModel = new DefaultTreeModel(this.root);
		this.treeModel.setAsksAllowsChildren(true);
		this.tree = new JTree(treeModel) {

			private static final long serialVersionUID = 2789999619139248302L;

			@Override
			public boolean isPathEditable(TreePath path) {
				return false;
			}
		};
		this.tree.setEditable(true);
		this.tree.setCellRenderer(new NodeTreeCellRendered());
		expandAllNodes(this.tree, 0, tree.getRowCount());
		this.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);	
		
	}
	
	private void initData() {
		this.root = new DefaultMutableTreeNode(this.rootOfOurModel);
		this.rootOfOurModel.addChilds(root);
	}
	
	private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public Workspace getRootOfOurModel() {
		return rootOfOurModel;
	}

	public void setRootOfOurModel(Workspace workspace) {
		this.rootOfOurModel = workspace;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> en = ((DefaultMutableTreeNode) treeModel
				.getRoot()).breadthFirstEnumeration();
		
		if (arg1 == EventType.REMOVED) {
			
			Stranica page = (Stranica)arg0;
			
			while (en.hasMoreElements()) {
				DefaultMutableTreeNode curr = en.nextElement();
				// voditi racuna oko id-a i jedinstvenosti
				// u realnom radu sa bazom, id bi svakako bio jedinstven
				if (curr.getUserObject() instanceof Stranica && 
						((Stranica)curr.getUserObject()).getId() == page.getId()) {
					
					this.treeModel.removeNodeFromParent(curr);
				}
			}
		} else if (arg1 == EventType.ADDED) {
			
			Stranica page = (Stranica)arg0;
			
			DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
					.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
			
			this.treeModel.insertNodeInto(new DefaultMutableTreeNode(page), childNodeView, childNodeView.getChildCount());
		}
	}

	public void setModel1(DefaultTreeModel tree1) {
		// TODO Auto-generated method stub
		this.tree.setModel(tree1);
	}

}
