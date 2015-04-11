package version_bis;

import java.util.ArrayList;
import java.util.List;




public class Node<T> {
	private T content;
	private List<Node<?>> children;
	private Node<T> parent;
	
	//constructeurs
	public Node(T content) {
		this.content = content;
		this.children = new ArrayList<Node<?>>();
	}

	//methodes
	public void add(Node<?> fils){
		children.add(fils);
	}

	public void add2(Node<?> fg, Node<?> fd) {
		add(fg);
		add(fd);
	}



	@Override
	public String toString() {
		return toString(0);
	}

	private String toString(int indent) {
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < indent; i++) {
			buf.append("\t");
		}
		buf.append("#"+content+"\n");
		for (Node<?> child : children) {
			buf.append(child.toString(indent+1));
		}
		return buf.toString();
	}
	
	public String toStringInline() {
		StringBuffer buf = new StringBuffer();

		buf.append(content);
		for (Node<?> child : children) {
			buf.append(child.toString());
		}
		return buf.toString();
	}
	
	//setter et getters
	public T getContent() {
		return content;
	}


	public void setContent(T content) {
		this.content = content;
	}


	public List<Node<?>> getChildren() {
		return children;
	}


	public void setChildren(List<Node<?>> children) {
		this.children = children;
	}

}