package com.adayazilim.example1.test;

import java.util.Scanner;

import com.adayazilim.example1.domain.GrupSiraliListe;
import com.adayazilim.example1.solve.Hesaplamalar;
import com.adayazilim.example1.solve.Islemler;
/**
 * @author Alper
 * 
 */
public class Run {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		boolean cikis = false;
		GrupSiraliListe grupSiraliListe = new GrupSiraliListe();
		Islemler islemler = new Islemler();
		Hesaplamalar hesaplamalar = new Hesaplamalar(islemler);
		Scanner in = new Scanner(System.in);
		System.out.println("Sirasiyla gun icerisinde atli karincanin kac defa calisacagini\n"
						+ "Atli karincanin kapasitesini\n"
						+ "Kac grubun oldugunu birer boslukla girip 'ENTER' a basiniz.\n"
						+ "Cikis icin 'EXIT' giriniz.\n ");
		boolean control = false;
		while (control != true && cikis == false) {
			islemler.setGirdi(in.nextLine());
			cikis = islemler.getGirdi().equals("exit")|| islemler.getGirdi().equals("EXIT");
			if (cikis == false) {
				control = islemler.parseRkN();
				while (control != true) {
					islemler.setGirdi(in.nextLine());
					control = islemler.parseRkN();
				}
				grupSiraliListe = null;
				while (grupSiraliListe == null) {
					grupSiraliListe = null;
					System.out.println("Gruplarin kacar kisi olduklarini birer boslukla giriniz");
					control = false;
					while (control != true) {
						islemler.setGruplar(in.nextLine());
						control = islemler.parseGrupNumber();
					}
					grupSiraliListe = islemler.BilgileriAl();
				}

				System.out.println("Hasilat:"+ hesaplamalar.HesaplamaYap(grupSiraliListe) + " Lira");
			}
		}

	}

}
