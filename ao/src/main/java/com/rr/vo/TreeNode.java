package com.rr.vo;

import java.util.List;
import java.util.Map;

public class TreeNode {
	 	public static String STATE_OPEN = "open"; 
	    public static String STATE_CLOSED = "closed"; 
	    private String id; 
	    private String text; 
	    private boolean chedcked; 
	    private String state = STATE_OPEN; 
	    private Map<String, Object> attributes; 
	    private List<TreeNode> children; 
	 
	    public TreeNode() { 
	        this.state = STATE_OPEN; 
	    } 
	 
//	    public TreeNode(String id, String text) { 
//	        this(id, text, STATE_OPEN); 
//	    } 
//	    public TreeNode(String id, String text, Map<String, Object> attributes) { 
//	        //this(id, text, STATE_OPEN); 
//	        this.id = id;
//	        this.text = text;
//	        this.attributes = attributes;
//	        this.state = STATE_OPEN;
//	    } 
    
//	    public TreeNode(String id, String text, String state) { 
//	        this.id = id; 
//	        this.text = text; 
//	        this.state = state;
//	        this.children = new ArrayList<TreeNode>(); 
//	    } 
//	    
//	    public void addChild(TreeNode ctd) { 
//	        this.children.add(ctd); 
//	    }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public boolean isChedcked() {
			return chedcked;
		}

		public void setChedcked(boolean chedcked) {
			this.chedcked = chedcked;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Map<String, Object> getAttributes() {
			return attributes;
		}

		public void setAttributes(Map<String, Object> attributes) {
			this.attributes = attributes;
		}

		public List<TreeNode> getChildren() {
			return children;
		}

		public void setChildren(List<TreeNode> children) {
			this.children = children;
		} 
	    
	    
}
