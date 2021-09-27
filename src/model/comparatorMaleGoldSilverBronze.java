package model;

import java.util.Comparator;

public class comparatorMaleGoldSilverBronze implements Comparator<Medallery> {

	@Override
	public int compare(Medallery o1, Medallery o2) {
		//Comparacion por Medalla de Oro
		if(o1.getMaleGoldMedal() > o2.getMaleGoldMedal()) {
			return -1;
		} else if(o1.getMaleGoldMedal() < o2.getMaleGoldMedal()) {
			return 1;
		} else {
			//Comparacion por Medalla de Plata
			if(o1.getMaleSilverMedal() > o2.getMaleSilverMedal()) {
				return -1;
			}else if(o1.getMaleSilverMedal() < o2.getMaleSilverMedal()) {
				return 1;
			}else {
				//Comparacion por Medalla de Bronce
				if(o1.getMaleBronzeMedal() > o2.getMaleBronzeMedal()) {
					return -1;
				}else if(o1.getMaleBronzeMedal() < o2.getMaleBronzeMedal()) {
					return 1;
				}else {
					//Comparacion por Nombre del pais
					return o1.getCountry().compareTo(o2.getCountry());
				}
			}
			
		}
	}

}
