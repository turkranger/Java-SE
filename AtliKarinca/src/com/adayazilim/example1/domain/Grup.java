package com.adayazilim.example1.domain;

/**
 * @author Alper
 * 
 */
public class Grup {
	private int id;
	private int kisi;
	private Grup sonraki; //Linkli bir yapida kullanilacak 

	public Grup(int id, int kisi) {
		this.id = id;
		this.kisi = kisi;
	}

	public int getId() {
		return id;
	}

	public int getKisi() {
		return kisi;
	}

	public Grup getSonraki() {
		return sonraki;
	}

	public void setSonraki(Grup sonraki) {
		this.sonraki = sonraki;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKisi(int kisi) {
		this.kisi = kisi;
	}

}
