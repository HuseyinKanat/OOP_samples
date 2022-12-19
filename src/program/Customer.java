package program;

public class Customer {
	private String id ;
	private String name ;
	private String email ;
	private String country ;
	private String address ;
	/*
	 * This constructor takes customer information details and creates an customer object.
	 */
	public Customer(String id, String name,String email, String country,String address){
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.address = address;
	} 
	/*
	 * This copy constructor creates a customer object by copying another customer object's datas.
	 * @param customer: a non-null Customer object
	 */
	public Customer(Customer customer) {
		this.id=customer.getId();
		this.name=customer.getName();
		this.email=customer.getEmail();
		this.country=customer.getCountry();
		this.address=customer.getAdress();
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCountry() {
		return country;
	}

	public String getAdress() {
		return address;
	}
	public String toString() {
		String myString = id +" "+ name+" " + email+" " + country+" "+address;
		return myString;
	}
}
