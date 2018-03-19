package iText;

public class Triple {

	 int numRiga;
	 int numColonna;
	 int numPannello;
	 
	 public Triple(int riga,int colonna,int pannello) {
		 this.numRiga = riga;
		 this.numColonna = colonna;
		 this.numPannello = pannello;
	 }
	 
	 public int getRiga(){
		 return this.numRiga;
	 }
	 
	 public int getColonna(){
		 return this.numColonna;
	 }
	 
	 public int getPannello(){
		 return this.numPannello;
	 }
	
}
