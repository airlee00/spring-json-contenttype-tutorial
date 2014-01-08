package org.toms.sample.json;

import java.io.Serializable;

public class JavaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JavaBean [data=" + data + "]";
	}
	
	
}
