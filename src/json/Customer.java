package json;

public class Customer {
	
	//Instance Variables to be parsed
	private String name, surname, contact;
	
	//Objects to be parsed
	private Shopping_List shopping_list;

	public Shopping_List getShopping_list() {
		return shopping_list;
	}

	public void setShopping_list(Shopping_List shopping_list) {
		this.shopping_list = shopping_list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
