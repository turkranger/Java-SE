package com.adayazilim.example1.solve;

import com.adayazilim.example1.domain.AtliKarinca;
import com.adayazilim.example1.domain.Grup;
import com.adayazilim.example1.domain.GrupSiraliListe;

/**
 * @author Alper
 * 
 */
public class Islemler {
	private String girdi = " ";
	private String gruplar = " ";
	private String[] grup;
	private AtliKarinca atliKarinca = new AtliKarinca();

	public AtliKarinca getAtliKarinca() {
		return atliKarinca;
	}

	public String getGruplar() {
		return gruplar;
	}

	public void setGruplar(String gruplar) {
		this.gruplar = gruplar;
	}

	public String getGirdi() {
		return girdi;
	}

	public void setGirdi(String girdi) {

		this.girdi = girdi;
	}

	public boolean parseRkN() {

		String[] words = girdi.split(" ");


			if (words.length == 3) {
				try {
					atliKarinca.setR(Integer.parseInt(words[0]));
					atliKarinca.setK(Integer.parseInt(words[1]));
					atliKarinca.setN(Integer.parseInt(words[2]));
				} catch (Exception e) {
					System.out.println("Integer deger giriniz.");
					return false;
				}
			} else {
				System.out.println("Eksik yada fazla deger girildi. Tekrar giriniz.");
				return false;
			}
		
		if(Integer.parseInt(words[0]) <= 0 || Integer.parseInt(words[1]) <=0|| Integer.parseInt(words[2]) <= 0){
			System.out.println("Sifirdan buyuk degerler giriniz.");
			return false;
		}
		return true;
	}

	public boolean parseGrupNumber() {
		grup = gruplar.split(" ");
		if (grup.length != atliKarinca.getN()) {
			System.out.println("Eksik yada fazla deger girildi. Tekrar giriniz.");
			return false;
		}

		return true;

	}

	public GrupSiraliListe BilgileriAl() {
		GrupSiraliListe grupSiraliListe = new GrupSiraliListe();
		int kontrol = 0;
		int kapasite=0;
		for (int i = 0; i < grup.length; i++) {
			try {
				kapasite = Integer.parseInt(grup[i]);
			} catch (Exception e) {
				System.out.println("Lutfen sayi giriniz.");
				return null;
			}
			
			
			if (kapasite > atliKarinca.getK()|| kapasite<=0) {//Grubun eleman sayisi 
				kontrol = 1;						//Atli karinca kapasitesinden fazlaysa durdur.
				break;
			}
			Grup temp = new Grup(i, kapasite);
			grupSiraliListe.add(temp);
		}
		if (kontrol == 0) {
			return grupSiraliListe;
		} else {
			System.out.println("Gruptaki kisi sayisi Atli karincanin kapasitesinden fazla olamaz.\n" +
					"Grup kisi sayisi sifirdan fazla olmali"
							+ "Bilgileri tekrardan giriniz.");
			return null;
		}

	}

}
