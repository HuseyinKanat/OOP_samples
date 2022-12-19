package program;

public class Sales {
	private int id ;
	private String customer ;
	private String product ;
	private String salesDate ;
	private int salesPrice ;
	/*
	 * This constructor takes sales information details and creates an Sales object.
	 */
	public Sales(int id, String customer ,String product, String dateTime){
		this.id = id;
		this.customer = customer;
		this.product = product;
		this.salesDate = dateTime;
	}
	/*
	 * This copy constructor creates a Sales object by copying another Sales object's datas.
	 * @param sales: a non-null Sales object
	 */
	public Sales(Sales sales) {
		this.id = sales.getId();
		this.customer = sales.getCustomer();
		this.product = sales.getProduct();
		this.salesDate = sales.getSalesDate();
	}
	public int getId() {
		return id;
	}

	public String getCustomer() {
		return customer;
	}

	public String getProduct() {
		return product;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public String toString() {
		String myString = id +", "+ customer+", " + product+", " + salesDate;
		return myString;
	}	
}
