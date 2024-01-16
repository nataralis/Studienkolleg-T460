public class StudentIn {
	
	String vorname;
	String nachname;
	String studienfach;
	int matrikelnummer;

	public static void main(String[] args) {
		
		StudentIn student1 = new StudentIn();
		student1.vorname = "Mariam";
		student1.matrikelnummer = 123456789;
		
		StudentIn student2 = new StudentIn();
		student2.vorname = "Luis";
		student2.matrikelnummer = 987654321;

	}

}
