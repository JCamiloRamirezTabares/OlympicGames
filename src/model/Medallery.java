package model;

public class Medallery implements Comparable<Medallery>{

	private String country;
	private int maleGoldMedal;
	private int maleSilverMedal;
	private int maleBronzeMedal;
	private int femaleGoldMedal;
	private int femaleSilverMedal;
	private int femaleBronzeMedal;
	private int goldMedal;
	private int silverMedal;
	private int bronzeMedal;
	
	public Medallery(String country, int maleGoldMedal, int maleSilverMedal, int maleBronzeMedal, int femaleGoldMedal, int femaleSilverMedal, int femaleBronzeMedal) {
		this.country = country;
		this.maleGoldMedal = maleGoldMedal;
		this.maleSilverMedal = maleSilverMedal;
		this.maleBronzeMedal = maleBronzeMedal;
		this.femaleGoldMedal = femaleGoldMedal;
		this.femaleSilverMedal = femaleSilverMedal;
		this.femaleBronzeMedal = femaleBronzeMedal;
		
	}
	
	public Medallery(String country, int goldMedal, int silverMedal, int bronzeMedal) {
		this.country = country;
		this.goldMedal = goldMedal;
		this.silverMedal = silverMedal;
		this.bronzeMedal = bronzeMedal;
		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMaleGoldMedal() {
		return maleGoldMedal;
	}

	public void setMaleGoldMedal(int maleGoldMedal) {
		this.maleGoldMedal = maleGoldMedal;
	}

	public int getMaleSilverMedal() {
		return maleSilverMedal;
	}

	public void setMaleSilverMedal(int maleSilverMedal) {
		this.maleSilverMedal = maleSilverMedal;
	}

	public int getMaleBronzeMedal() {
		return maleBronzeMedal;
	}

	public void setMaleBronzeMedal(int maleBronzeMedal) {
		this.maleBronzeMedal = maleBronzeMedal;
	}

	public int getFemaleGoldMedal() {
		return femaleGoldMedal;
	}

	public void setFemaleGoldMedal(int femaleGoldMedal) {
		this.femaleGoldMedal = femaleGoldMedal;
	}

	public int getFemaleSilverMedal() {
		return femaleSilverMedal;
	}

	public void setFemaleSilverMedal(int femaleSilverMedal) {
		this.femaleSilverMedal = femaleSilverMedal;
	}

	public int getFemaleBronzeMedal() {
		return femaleBronzeMedal;
	}

	public void setFemaleBronzeMedal(int femaleBronzeMedal) {
		this.femaleBronzeMedal = femaleBronzeMedal;
	}
	
	

	public int getGoldMedal() {
		return goldMedal;
	}

	public int getSilverMedal() {
		return silverMedal;
	}

	public int getBronzeMedal() {
		return bronzeMedal;
	}

	@Override
	public int compareTo(Medallery o) {
		
		if(femaleGoldMedal > o.getFemaleGoldMedal()) {
			return 1;
		} else if(femaleGoldMedal < o.getFemaleGoldMedal()) {
			return -1;
		} else {
			//Comparacion por Medalla de Plata
			if(femaleSilverMedal > o.getFemaleSilverMedal()) {
				return 1;
			}else if(femaleSilverMedal < o.getFemaleSilverMedal()) {
				return -1;
			}else {
				//Comparacion por Medalla de Bronce
				if(femaleBronzeMedal > o.getFemaleBronzeMedal()) {
					return 1;
				}else if(femaleBronzeMedal > o.getFemaleBronzeMedal()) {
					return -1;
				}else {
					//Comparacion por Nombre del pais
					return country.compareTo(o.getCountry());
				}
			}
			
		}
		
	}

	
	
	
	
}
