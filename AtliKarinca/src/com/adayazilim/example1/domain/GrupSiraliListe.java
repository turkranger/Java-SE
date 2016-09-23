package com.adayazilim.example1.domain;

/**
 * @author Alper
 * 
 */
public class GrupSiraliListe {
	private Grup ilkGrup = null;
	private Grup sondakiGrup = null;

	public Grup getIlkGrup() {
		return ilkGrup;
	}

	public void setIlkGrup(Grup ilkGrup) {
		this.ilkGrup = ilkGrup;
	}

	public Grup getSondakiGrup() {
		return sondakiGrup;
	}

	public void setSondakiGrup(Grup sondakiGrup) {
		this.sondakiGrup = sondakiGrup;
	}

	public void add(Grup eklenen) {
		if (ilkGrup == null) {	//daha once bir grup eklenmediyse 
			ilkGrup = eklenen;
			sondakiGrup = eklenen;
			eklenen.setSonraki(ilkGrup);
		} else {				//linkli listemiz bos degilse
			sondakiGrup.setSonraki(eklenen);
			sondakiGrup = eklenen;
			eklenen.setSonraki(ilkGrup);
		}
	}
}
