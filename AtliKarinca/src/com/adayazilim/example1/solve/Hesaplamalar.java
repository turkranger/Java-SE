package com.adayazilim.example1.solve;

import java.util.ArrayList;
import java.util.List;
import com.adayazilim.example1.domain.Grup;
import com.adayazilim.example1.domain.GrupSiraliListe;

/**
 * @author Alper
 * 
 */
public class Hesaplamalar {
	private Islemler islemler = new Islemler();
	private boolean dongu = false;
	private int sayac = 0;
	private int sayacTemp = 0;
	List<Grup> hafiza = new ArrayList<Grup>();

	public Hesaplamalar(Islemler islemler) {
		this.islemler = islemler;
	}

	public int HesaplamaYap(GrupSiraliListe grupSiraliListe) {

		int indis = 0;
		int calisma = 1;
		int hasilat = 0;
		Grup siradaki = grupSiraliListe.getIlkGrup();
		Grup onceki = null;
		while (calisma <= islemler.getAtliKarinca().getR()) {
			if (dongu == false) {//Optimizasyon sonucu bir dongu olusmadiysa bu islemler yapilacak
				int grupToplamKisi = 0;
				while (grupToplamKisi <= islemler.getAtliKarinca().getK()) {
					if (grupToplamKisi == 0) {
						indis = siradaki.getId();//indis ilk gelen grubu tutacak
					}
					onceki = siradaki;
					grupToplamKisi = grupToplamKisi + siradaki.getKisi();
					siradaki = siradaki.getSonraki();
				}

				grupToplamKisi = grupToplamKisi - onceki.getKisi();
				siradaki = onceki;
				OptimizeListe(indis, grupToplamKisi);//optimizasyon icin bu grup daha once gelmis mi kontrolu yapýlýyor
				hasilat = hasilat + grupToplamKisi;
				calisma++;
			} else {		//optimizasyon icin bir dongu mevcut ise bu islemleri yap
				sayac++;
				if (sayac == hafiza.size()) {	//listenin sonuna geldiyse dongunun basina don
					sayac = sayacTemp;
				}
				hasilat = hasilat + hafiza.get(sayac).getKisi();
				calisma++;
			}
		}
		for(int i=0;i<hafiza.size();i++){
			System.out.println(hafiza.get(i).getId());
		}
		hafiza.remove(0);
		for(int i=0;i<hafiza.size();i++){
			System.out.println(hafiza.get(i).getId());
		}
		return hasilat;
		
	}

	private void OptimizeListe(int indis, int grupToplamKisi) {
		if (hafiza.isEmpty()) {		//listemiz bos yeni eleman ekle
			hafiza.add(new Grup(indis, grupToplamKisi));
		} else {
			for (int i = 0; i < hafiza.size(); i++) {
				if (indis == hafiza.get(i).getId()) {
					dongu = true;	// optimizasyon icin bir dongu olustu
					sayac = i;		//listenin kacinci elemanýnda itibaren dongu basladigini tutacak
					sayacTemp = i;
					break;
				}
			}
			if (dongu == false) {	//listede bu eleman yok yeni eleman ekle
				hafiza.add(new Grup(indis, grupToplamKisi));
			}
		}

	}

}
