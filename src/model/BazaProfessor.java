package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class BazaProfessor {
	private static BazaProfessor instance = null;

	public static BazaProfessor getInstance() {
		if (instance == null) {
			instance = new BazaProfessor();
		}
		return instance;
	}

	private long generator;

	private ArrayList<Professor> profesori;
	public ArrayList<Professor> searched;	//pravimo novu listu za pretrazivanje 
	private ArrayList<String> kolone;
	private boolean searchedDone;			

	private BazaProfessor() {
		generator = 0;
		searched = new ArrayList<Professor>();
		searchedDone = false;

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("BROJ LICNE");

		this.profesori = new ArrayList<Professor>();


//		profesori.add(new Professor("Nebojsa", "Ralevic", LocalDate.now(), new Address("Zmaj Jovina","1","Novi Sad","Srbija"), "069/2903456",
//				"email@gmai", new Address("Strazilovska","2","Novi Sad","Srbija"), "ID3457","redovni profesor",15));
//		profesori.add(new Professor("Rade", "Doroslovacki", LocalDate.now(), new Address("Jevrejska","1","Novi Sad","Srbija"), "069/00022",
//				"email1@gmai", new Address("Futoska","2","Novi Sad","Srbija"), "ID1157","docent",20));
//		profesori.add(new Professor("Milan", "Rapaic", LocalDate.now(), new Address("Dunavska","7","Novi Sad","Srbija"), "069/299996",
//				"email2@gmai", new Address("Kosovska","2","Novi Sad","Srbija"), "ID300000","vanredni profesor",33)); 
/*
 * 
 * 
 * 
 */
		Address ak1 = new Address("Šafarikova","2","Novi Sad","Srbija");
		Address ak2 = new Address("Nikole Tesle","56","Novi Sad","Srbija");
		Address ak3 = new Address("Bulevar Patrijaha Pavla","3","Beograd","Srbija");
		Address ak4 = new Address("Stražilovska","6a","Novi Sad","Srbija");
		Address ak5 = new Address("Nikole Pašića","2d","Kikinda","Srbija");
		Address ak6 = new Address("Bulevar Kralja Petra","22","Niš","Srbija");
		Address ak7 = new Address("Tolstojeva","31","Novi Sad","Srbija");
		Address ak8 = new Address("Marićeva","11","Kragujevac","Srbija");
		Address ak9 = new Address("Stražilovska","3","Beograd","Srbija");
		Address ak10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		Address ak11 = new Address("Bulevar Kralja Petra","2d","Niš","Srbija");
		Address ak12 = new Address("Knez Mihajlova","22","Beograd","Srbija");
		/*work adres*/

		Address ap10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		profesori.add(new Professor(1	,   "123123123",	"Miloš"	,"Nikolić",	LocalDate.parse("12.12.1965.",formatter)	,ak1,	"021/356-785",	"milos.nikolic@mailinator.com",	ap10,	30,	"redovni profesor",new ArrayList<Subject>()));
		profesori.add(new Professor(2	,   "321321321",	"Nikola"	,"Mirković",	LocalDate.parse("01.01.1978.",formatter)	,ak2,	"021/368-456",	"nikola.mirkovic@mailinator.com",	ap10,	22,	"redovni profesor",new ArrayList<Subject>()));
		profesori.add(new Professor(3	,   "456456456",	"Ilija"	,"Petković",	LocalDate.parse("03.09.1988.",formatter)	,ak3,	"021/215-314",	"ilija.petkovic@mailinator.com",	ap10,	22,	"vanredni profesor",new ArrayList<Subject>()));
		profesori.add(new Professor(4	,   "789789789",	"Mitar"	,"Petrović",	LocalDate.parse("25.07.1976.",formatter)	,ak4,	"021/884-640",	"mitar.petrovic@mailinator.com",	ap10,	27,	"vanredni profesor",new ArrayList<Subject>()));
		profesori.add(new Professor(5	,   "100100144",	"Vasa"	,"Micić",	LocalDate.parse("14.02.1970.",formatter)	,ak5,	"021/212-114",	"vasa.micic@mailinator.com",	ap10,	24,	"docent",new ArrayList<Subject>()));
		profesori.add(new Professor(6	,   "200020244",	"Srđan"	,"Miletić",	LocalDate.parse("20.04.1966.",formatter)	,ak6,	"021/978-225",	"srdjan.miletic@mailinator.com",	ap10,	31,	"docent",new ArrayList<Subject>()));
		profesori.add(new Professor(7	,   "559585632",	"Branislav"	,"Mihajlović",	LocalDate.parse("28.06.1980.",formatter)	,ak7,	"021/778-323",	"branislav.mihajlovic@mailinator.com",	ap10,	13,	"redovni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(8	,   "334968855",	"Marko"	,"Marković",	LocalDate.parse("31.01.1985.",formatter)	,ak8,	"021/899-659",	"marko.markovic@mailinator.com",	ap10,	17,	"redovni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(9	,   "730703654",	"Miloš"	,"Milaković",	LocalDate.parse("21.09.1975.",formatter)	,ak9,	"021/122-326",	"milos.milakovic@mailinator.com",	ap10,	12,	"vanredni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(10,	"600378644",	"Lazar"	,"Bratić",	LocalDate.parse("13.11.1973.",formatter)	,ak10,	"021/156-326",	"lazar.bratic@mailinator.com",	ap10,	3,	"vanredni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(11,	"158496152",	"Ljeposava"	,"Dražić",	LocalDate.parse("11.08.1964.",formatter)	,ak11,	"021/888-156",	"ljeposava.drazic@mailinator.com",	ap10,	31,	"docent"	,new ArrayList<Subject>()));
		profesori.add(new Professor(12,	"777348595",	"Miroljub"	,"Dragić",	LocalDate.parse("02.03.1959.",formatter)	,ak12,	"021/456-125",	"miroljub.dragic@mailinator.com",	ap10,	42,	"docent"	,new ArrayList<Subject>()));
		profesori.add(new Professor(13,	"721254363",	"Bogdan"	,"Rekavić",	LocalDate.parse("23.06.1977.",formatter)	,ak6,	"021/886-455",	"bogdan.rekavic@mailinator.com",	ap10,	18,	"vanredni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(14,	"225533448",	"Stanka"	,"Milić",	LocalDate.parse("03.03.1991.",formatter)	,ak3,	"021/945-155",	"stanka.milic@mailinator.com",	ap10,	7,	"docent"	,new ArrayList<Subject>()));
		profesori.add(new Professor(15,	"111555888",	"Milica"	,"Vuković",	LocalDate.parse("18.10.1967.",formatter)	,ak8,	"021/746-659",	"milica.vukovic@mailinator.com",	ap10,	14,	"vanredni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(16,	"300300344",	"Miša"	,"Mišić",	LocalDate.parse("20.10.1969.",formatter)	,ak1,	"021/489-326",	"misa.misic@mailinator.com",	ap10,	19,	"docent"	,new ArrayList<Subject>()));
		profesori.add(new Professor(17,	"400400444",	"Branko"	,"Maričić",	LocalDate.parse("18.01.1973.",formatter)	,ak2,	"021/487-265",	"branko.maricic@mailinator.com",	ap10,	22,	"docent"	,new ArrayList<Subject>()));
		profesori.add(new Professor(18,	"500500544",	"Branislav"	,"Lukovic",	LocalDate.parse("08.04.1982.",formatter)	,ak3,	"021/159-478",	"branislav.lukovic@mailinator.com",	ap10,	9,	"redovni profesor"	,new ArrayList<Subject>()));
		profesori.add(new Professor(19,	"600600644",	"Branimir"	,"Obradović",	LocalDate.parse("07.01.1979.",formatter)	,ak1,	"021/922-333",	"branimir.obradovic@mailinator.com",	ap10,	17,	"docent"	,new ArrayList<Subject>()));
		/*
		 * 
		 * 
		 * 
		 */
	}

	public ArrayList<Professor> getProfesori() {
		return profesori;
	}
	
	public void setProfessor(ArrayList<Professor> profesori) {
		this.profesori = profesori;
	}

	public Professor getProfessorByID(String idCard) {
		for(Professor i : profesori) {
			if(i.getIdCard().equals(idCard)) {
				return i;
			}
		}
		return null;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Professor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Professor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getFirstName();
		case 1:
			return profesor.getLastName();
		case 2:
			return profesor.getPosition();
		case 3:
			return profesor.getIdCard();
		default:
			return null;
		}

	}

	public void dodajProfesora(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress,
			String phone, String email, Address officeAddress, String idCard, String position, int workingYear) {
		Professor prof = new Professor(firstName, lastName, dateOfBirth, homeAddress, phone, email, officeAddress,
				idCard, position, workingYear);
		this.profesori.add(prof);
	}

	public void izbrisiProfesora(int row) { // brise red u tabeli
		profesori.remove(row);
	}


	public void izmeniProfesora(Professor profesor, String firstName, String lastName, LocalDate dateOfBirth, Address home_address,
			String phone, String email, Address officeAddress, String idCard, String position, int workingYear) {
		

		profesor.setFirstName(firstName);
		profesor.setLastName(lastName);
		profesor.setDateOfBirth(dateOfBirth);
		profesor.setHomeAddress(home_address);
		profesor.setPhone(phone);
		profesor.setEmail(email);
		profesor.setOfficeAddress(officeAddress);
		profesor.setIdCard(idCard);
		profesor.setPosition(position);
		profesor.setWorkingYear(workingYear);
	}

	public void izmeniProfesora(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress,
			String phone, String email, Address officeAddress, String idCard, String position, int workingYear) {
		for (Professor profesor : profesori) {
			if (profesor.getIdCard().equals(idCard)) {
				profesor.setFirstName(firstName);
				profesor.setLastName(lastName);
				profesor.setDateOfBirth(dateOfBirth);
				profesor.setHomeAddress(homeAddress);
				profesor.setPhone(phone);
				profesor.setEmail(email);
				profesor.setOfficeAddress(officeAddress);
				profesor.setIdCard(idCard);
				profesor.setPosition(position);
				profesor.setWorkingYear(workingYear);
				return;
			}
		}
	}

	public void getProffessorNameSurname(String lastName, String name) {
		searched.clear();
		searchedDone = true;
		for (Professor p : profesori) {
			if (name == null) {
				if (p.getLastName().toLowerCase().contains(lastName)) {
					searched.add(p);
				}
			} else {
				if (p.getLastName().toLowerCase().contains(lastName) && p.getFirstName().toLowerCase().contains(name)) {
					searched.add(p);
				}
			}
		}

	}

	public boolean isSearchedDone() {
		return searchedDone;
	}

	public Professor getRowSearch(int rowIndex) {
		return this.searched.get(rowIndex);
	}

	public String getValueAtSearch(int row, int column) {

		Professor profesor = this.searched.get(row);
		switch (column) {
		case 0:
			return profesor.getFirstName();
		case 1:
			return profesor.getLastName();
		case 2:
			return profesor.getPosition();
		case 3:
			return profesor.getEmail();
		default:
			return null;
		}

	}

	public ArrayList<Professor> getSearched() {
		return searched;
	}
	
	public Professor getProfWithKey(int id) {
		for(Professor i : profesori) {
			if(i.getId() == id) {
				return i;
			}
		}
		return null;
	}

	
}