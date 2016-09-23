/**
 * 
 */
package com.adayazilim.example2.solve;

/**
 * @author Alper
 *
 */
public class Islemler {
	private double brutTahmin=0;
	int i=0;

	public void setBrutTahmin(double brutTahmin) {
		this.brutTahmin = brutTahmin;
	}

	public  double BrutMaasHesapla(double netMaas, double tahminiNetMaas) {
		double tahminiNetMaasOnceki = tahminiNetMaas;
		double brutTahminOnceki=brutTahmin;
		brutTahmin = brutTahmin*(netMaas/tahminiNetMaas);
		//Yeni tahmini yaparken, net maasla onceki tahmini netmaasýn orani ile carptýk
		tahminiNetMaas = NetMaasHesapla(brutTahmin); 
		
		//Yaklasik degeri bulurken, hata payi 0.01 alindi
		if ((tahminiNetMaas - tahminiNetMaasOnceki >= 0.01)|| (tahminiNetMaas - tahminiNetMaasOnceki <= -0.01)) {
			return BrutMaasHesapla(netMaas, tahminiNetMaas);
		} else {
			return brutTahminOnceki;
		}

	}

	public double NetMaasHesapla(double brutTahmin) {
		double netMaas=brutTahmin * 0.7+120;
		
		return netMaas;
		//Programýn calisabilmesi icin NetMaasHesapla metodunu rasgele islemle yazdim
	}
}
