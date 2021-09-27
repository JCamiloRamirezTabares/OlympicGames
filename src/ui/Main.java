package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Medallery;
import model.comparatorMaleGoldSilverBronze;

public class Main {
	
	private BufferedReader reader;
	private List<Medallery> medallery;
	private List<Medallery> combineMedallery;
	
	public Main() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		medallery = new ArrayList<Medallery>();
		combineMedallery = new ArrayList<Medallery>();
	}

	public static void main(String []juank) throws NumberFormatException, IOException {
		Main ppal = new Main();
		
		System.out.println("BIENVENIDO AL SISTEMA DE MEDALLERIA DE LOS JUEGOS OLIMPICOS");
		System.out.println("Por favor ingrese el numero de paises que desea ordenar:");
		System.out.print("N° de Paises: ");
		
		int countryNumber = Integer.parseInt(ppal.readALine());
		
		System.out.println("Por favor ingrese los valores de cada pais, separados por punto y coma");
		
		for(int i = 0; i < countryNumber; i++) {
			System.out.print("Datos del Pais #" + (i+1) + ": ");
			String info = ppal.readALine();
			String [] a = info.split(";");
			ppal.addMedalleryCountry(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]), Integer.parseInt(a[4]), Integer.parseInt(a[5]), Integer.parseInt(a[6]));
		}
		
		System.out.println("REPORTE:");
		System.out.println("------------------------------------------------------------------");
		
		ppal.printMaleReport();
		ppal.printFemaleReport();
		ppal.combineMedals();
		ppal.printCombineBySelectionSort();
		ppal.printCombineByInsertionSort();
	}
	
	public String readALine() throws IOException {
		String line = reader.readLine();
		
		return line;
	}
	
	public void addMedalleryCountry(String country, int mG, int mS, int mB, int fG, int fS, int fB) {
		medallery.add(new Medallery(country, mG, mS, mB, fG, fS, fB));
	}
	
	
	public void sortByComparator(){
		Comparator<Medallery> m = new comparatorMaleGoldSilverBronze();
		
		Collections.sort(medallery, m);
		
	}
	
	public void combineMedals() {
		for(int i = 0; i < medallery.size(); i++) {
			combineMedallery.add(new Medallery(medallery.get(i).getCountry(), (medallery.get(i).getMaleGoldMedal() + medallery.get(i).getFemaleGoldMedal()), (medallery.get(i).getMaleSilverMedal() + medallery.get(i).getFemaleSilverMedal()), (medallery.get(i).getMaleBronzeMedal() + medallery.get(i).getFemaleBronzeMedal())));
		}
	}
	
	public void selectSort() {
		int pos =0;
		while(pos < combineMedallery.size()) {
			Medallery max = combineMedallery.get(pos);
			for(int i= pos; i < combineMedallery.size(); i++) {

				if(combineMedallery.get(i).getGoldMedal() > max.getGoldMedal()) {
					Medallery temp = combineMedallery.get(i);
					combineMedallery.set(i, max);
					max = temp;
				}
			}
			combineMedallery.set(pos, max);
			pos++;
		}
		
	}
	
	public void insertionSort() {

		int j;
		Medallery aux;
		for (int i=1; i< combineMedallery.size(); i++) {
			aux = combineMedallery.get(i);
			j = i-1;
			while((j>=0) && (aux.getGoldMedal() > combineMedallery.get(j).getGoldMedal())) {
				combineMedallery.set(j+1, combineMedallery.get(j));
				j--;
			}
			combineMedallery.set(j+1, aux);
		}
	}
	
	public void printMaleReport() {
		System.out.println("Masculino");
		sortByComparator();
		for(int i=0; i< medallery.size(); i++) {
			System.out.println(medallery.get(i).getCountry()+" "+medallery.get(i).getMaleGoldMedal()+" "+medallery.get(i).getMaleSilverMedal()+" "+medallery.get(i).getMaleBronzeMedal());
		}
		System.out.println("--------------------------------------------");
	}
	
	public void printFemaleReport() {
		Collections.sort(medallery);
		System.out.println("Femenino");
		for(int i=0; i < medallery.size(); i++) {
			System.out.println(medallery.get(i).getCountry()+" "+medallery.get(i).getFemaleGoldMedal()+" "+medallery.get(i).getFemaleSilverMedal()+" "+medallery.get(i).getFemaleBronzeMedal());
		}
		System.out.println("--------------------------------------------");
	}
	
	public void printCombineBySelectionSort() {
		System.out.println("Combinacion por SelectionSort");
		selectSort();
		for(int i=0; i < combineMedallery.size(); i++) {
			System.out.println(combineMedallery.get(i).getCountry() + " " + combineMedallery.get(i).getGoldMedal() + " " + combineMedallery.get(i).getSilverMedal() + " " + combineMedallery.get(i).getBronzeMedal());
		}
		System.out.println("----------");
	}
	
	public void printCombineByInsertionSort() {
		System.out.println("Combinacion por InsertionSort");
		insertionSort();
		for(int i=0; i<combineMedallery.size(); i++) {
			System.out.println(combineMedallery.get(i).getCountry() + " " + combineMedallery.get(i).getGoldMedal() + " " + combineMedallery.get(i).getSilverMedal() + " " + combineMedallery.get(i).getBronzeMedal());
		}
	}
	
	
	
}
