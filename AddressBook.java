package com.adressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	
	String name,lname,address,city,state;
	int zip;
	long phoneNm;
	
	ArrayList<PersonInfo> persons;
	public AddressBook ( ) { 
		  persons = new ArrayList();
	}

	Scanner sc= new Scanner(System.in);
	
	public void addPerson(String name2, String address2, String city2, String state2, String lname, int zip2, long phoneNm2 ) {
	
		name=name2;
		address=address2;
		city=city2;
		state=state2;
		zip=zip2;
		phoneNm=phoneNm2;
		lname=lname;
		System.out.println("Enter  Name :\t");
		name=sc.nextLine();
		System.out.println("Enter Last Name :\t");
		String lname=sc.nextLine();
		System.out.println("Enter Address :\t");
		String address=sc.nextLine();
		System.out.println("Enter City :\t");
		String city=sc.nextLine();
		System.out.println("Enter State :\t");
		String state=sc.nextLine();
		System.out.println("Enter ZipCode :\t");
		int zip=sc.nextInt();
		System.out.println("Enter Phone Number :\t");
		long phoneNm=sc.nextLong();
	
	PersonInfo p = new PersonInfo(name,lname,address, city, state, zip, phoneNm);

	
	persons.add(p);
		
	displayPerson();

	}

	 
	public void searchPerson (String n) 
	{
		
		for(PersonInfo p2: persons)
		{
			if(p2.getFname().equals(n))
			{
			System.out.println(p2);
				break;
			}
			else
			{
				System.out.println("Not Found");
			}
		}
	
	
	

	} 

	 
	public void deletePerson (String n) {

		for (int i=0; i< persons.size(); i++) {
		PersonInfo p = (PersonInfo)persons.get(i); 
		if ( n.equals(p.fname) ) {
		persons.remove(i);
		System.out.println("Removed Successfully");
		displayPerson();
		}
		

		} 

		} 
	public void displayPerson () {
				for(PersonInfo p2: persons)
				{
					System.out.println(p2);
				}
		
		} 

		

public void editPerson (String x) {
	for(PersonInfo p2: persons)
	{
		if(p2.getFname().equals(x))
		{
			System.out.println("Enter Address :\t");
			String address=sc.next();
			p2.setAddress(address);
			System.out.println("Enter City :\t");
			String city=sc.next();
			p2.setCity(city);
			System.out.println("Enter State :\t");
			String state=sc.next();
			p2.setState(state);
			System.out.println("Enter ZipCode :\t");
			int zip=sc.nextInt();
			p2.setZip(zip);
			System.out.println("Enter Phone Number :\t");
			long phoneNm=sc.nextLong();
			p2.setPhoneNm(phoneNm);
			System.out.println("Updated Successfully");
			displayPerson();
			
		}
		else
		{
			System.out.println("Not Found");
		}
	}

} 

public void sortByName() {
	
	Collections.sort(persons,new NameSort());
	System.out.println("Sorted Successfully by Name");
	displayPerson();
	
	
}

public void sortByZip() {
	
	Collections.sort(persons,new ZipSort());
	System.out.println("Sorted Successfully By ZipCode");
	displayPerson();
	
	
}
} 




package com.adressbook;
import java.util.Comparator;

import javax.swing.*; 
class PersonInfo 
{
String fname; 
String lname;
String city;
String state;
int zip;
String address; 
long phoneNm;


public PersonInfo(String fn,String ln,String a,String c,String s,int z,long p) {
 fname = fn;
 lname=ln;
 address = a;
 city=c;
 state=s;
 zip=z;
 phoneNm = p;

}


public String getFname() {
	return fname;
}


public void setFname(String fname) {
	this.fname = fname;
}


public String getLname() {
	return lname;
}


public void setLname(String lname) {
	this.lname = lname;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public int getZip() {
	return zip;
}


public void setZip(int zip) {
	this.zip = zip;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public long getPhoneNm() {
	return phoneNm;
}


public void setPhoneNm(long phoneNm) {
	this.phoneNm = phoneNm;
}


@Override
public String toString() {
	return "PersonInfo [fname=" + fname + ", city=" + city + ", state=" + state + ", zip=" + zip
			+ ", address=" + address + ", phoneNm=" + phoneNm + "]";
}




public void print( ) {
	System.out.println("Name----LastName-----Address----City----State---ZipCode----Phone Number");
	System.out.println(fname+"----"+lname+"-----"+address+"-----"+city+"----"+state+"-----"+zip+"---"+phoneNm);
}
}




package com.adressbook;

import java.util.Scanner;

public class Test {
public static void main	(String args[]) {
AddressBook ab = new AddressBook(); 
String input, s;
int ch; 
	String ans="y";
	while(ans!="N") {
		 Scanner sc= new Scanner(System.in);

		
				 System.out.println("1.ADD\n2.Search\n3.Edit\n4.Delete\n5.Sort ByName\n6.Sort ByZipcode\n7.Exit");
				 System.out.println("Enter a Option :\t");
				 Scanner sc= new Scanner(System.in);
				 ch=sc.nextInt();
				switch (ch)
				{ 
				case 1:
					System.out.println("Enter  Name :\t");
					String name=sc.next();
					System.out.println("Enter Last Name :\t");
					String lname=sc.next();
					System.out.println("Enter Address :\t");
					String address=sc.next();
					System.out.println("Enter City :\t");
					String city=sc.next();
					System.out.println("Enter State :\t");
					String state=sc.next();
					System.out.println("Enter ZipCode :\t");
					int zip=sc.nextInt();
					System.out.println("Enter Phone Number :\t");
					long phoneNm=sc.nextLong();
				
				ab.addPerson(name,lname, address, city, state, zip, phoneNm);
					       break;
				case 2:
					ab.displayPerson();
					System.out.println("Enter name to search");
					s=sc.next();
					ab.searchPerson(s); 
					break;
					case 3:
						System.out.println("Enter Name to of Person to edit the details:\t");
						String x=sc.next();
						ab.editPerson(x);
						 break;
					case 4:
						 System.out.println("Enter name to delete");
						 s=sc.next();
						ab.deletePerson(s);
						ab.displayPerson();
							break;
					case 5:
							ab.sortByName();
							break;
					case 6: 
							ab.sortByZip();
							break;
					case 7:
							System.exit(0);
							break;
				}
							

}
}
}




package com.adressbook;

import java.util.Comparator;

public class NameSort implements Comparator<PersonInfo> {

	@Override
	public int compare(PersonInfo o1, PersonInfo o2) {
		
		return o1.fname.compareTo(o2.fname);
	}
}




package com.adressbook;

import java.util.Comparator;

public class ZipSort implements Comparator<PersonInfo> 
{

	@Override
	public int compare(PersonInfo o3, PersonInfo o4) {
		
		if(o3.zip==o4.zip)
			return 0;
		else if(o3.zip>=o4.zip)
			return 1;
		else
			return -1;
		
	}

}








