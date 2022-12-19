package program;

public class Product {
	private String id ;
	private String title ;
	private double rate ;
	private int numOfRewievs ;
	private int price ;
	
	/*
	 * This constructor takes product information details and creates an Product object.
	 */
	public Product(String id, String title,double rate, int numOfRewievs,int price){
		this.id = id;
		this.title = title;
		this.rate = rate;
		this.numOfRewievs = numOfRewievs;
		this.price = price;
	}
	/*
	 * This copy constructor creates a Product object by copying another Product object's datas.
	 * @param customer: a non-null Product object
	 */
	public Product(Product product) {
		this.id = product.getId();
		this.title = product.getId();
		this.rate = product.getRate();
		this.numOfRewievs = product.getNumOfRewievs();
		this.price = product.getPrice();
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getRate() {
		return rate;
	}

	public int getNumOfRewievs() {
		return numOfRewievs;
	}
	public int getPrice() {
		return price;
	}
	/*
	 * This method calculates the sales price by formula
	 * sales price = price + ((rate/5.0)*100)*(number of views)
	 */
	public double getSalesPrice(){
		return price + ((rate/5.0)*100)*numOfRewievs;
	}
	/*
	 * This method calculates the profit
	 */
	public double getProfit(){
		return getSalesPrice()-price;
	}
	public String toString() {
		String myString = id +" "+ title+" " +rate+" " + numOfRewievs+" " +price;
		return myString;
	}
	
	

	
}
