package com.fabbandco.android.model;

public class DummyItem {
	public String id;
	public String content;
	public String contentDummy;
	public boolean idImage;

	public DummyItem(String _id, String _content, String _contentDummy, boolean id_image) {
		this.id = _id;
		this.content = _content;
		this.contentDummy=_contentDummy;
		this.idImage=id_image;
	}

	@Override
	public String toString() {
		return content;
	}
	
	public String toStringAllDummy() {
		return content +"\n"+ contentDummy;
	}
	
	public boolean havePicture (){
		return this.idImage;
	}
	
}