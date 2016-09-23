package com.adayazilim.example2.test;

import java.util.Scanner;

import com.adayazilim.example2.solve.Islemler;

/**
 * @author Alper
 * 
 */
public class Run {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Islemler islemler=new Islemler();
		double netMaas = 0.0;
		String input = " ";
		Scanner in = new Scanner(System.in);
		System.out.println("Calisanin net maasini giriniz:");
		input = in.nextLine();
		while (!(netMaas > 0))
			try {
				netMaas = Double.parseDouble(input);

			} catch (Exception e) {
				System.out.println("Double deger giriniz.");
				input = in.nextLine();
			}
		islemler.setBrutTahmin(netMaas*1.5);
		double tahminiNetMaas = islemler.NetMaasHesapla(netMaas*1.5);
		double brutMaas = islemler.BrutMaasHesapla(netMaas, tahminiNetMaas);
		System.out.println("Tahmini Brut Maas: "+brutMaas);

	}



}
