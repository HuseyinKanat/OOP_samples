package program;
public class SalesQuery {
 	private double profitHolder[];
	private double maxPrice;
	private Product[] products;
	private double priceHolder[];
	
	/*
	 * This method calculates the total profit 
	 */
	
	public double calculateTotalProfit() {
		ObjectHolder tempproductsHolder = new ObjectHolder();
		Product[] products1 = tempproductsHolder.createProductArray("S1_Products.csv");
		Product[] products2 = tempproductsHolder.createProductArray("S2_Products.csv");
		Product[] products3 = tempproductsHolder.createProductArray("S3_Products.csv");
		
		SalesManagement salesManagement = new SalesManagement();
		salesManagement.createSalesManagementArray("S1_Sales.csv", "S2_Sales.csv", "S3_Sales.csv");
		Sales[][] salesArray= salesManagement.getSalesManagementArray();
		double totalCounter=0;
		
		for(int k=0;k<salesArray[0].length;k++){
			for(int i =0; i<products1.length;i++) {
				if (salesArray[0][k].getProduct().equals(products1[i].getId())) {
					totalCounter += products1[i].getProfit();
				}
			}
		}
		for(int k=0;k<salesArray[1].length;k++){
			for(int i =0; i<products2.length;i++) {
				if(salesArray[1][k]!=null) {
					if (salesArray[1][k].getProduct().equals(products2[i].getId())) {
						totalCounter += products2[i].getProfit();
					}
				}
			}
		}
		for(int k=0;k<salesArray[2].length;k++){
			for(int i =0; i<products3.length;i++) {
				if(salesArray[2][k]!=null) {
					if (salesArray[2][k].getProduct().equals(products3[i].getId())) {
						totalCounter += products3[i].getProfit();
					}
				}
			}
		}
		return totalCounter;
	}
	/*
	 * This method calculates the maximum profit among all products in a file.
	 * @return: amount of profit
	 */
 	private double calculateMaxProfit(String filename) {
		ObjectHolder tempproductsHolder = new ObjectHolder();
		products = tempproductsHolder.createProductArray(filename);
		double profitHolder[] = new double[products.length];
		int i=0;
        for(Product tempProduct: products) {
			double a =tempProduct.getProfit();
            profitHolder[i]=a;
            i++;
		}
		double max=profitHolder[0];
		for (int k = 0; k < profitHolder.length; k++){
            if (profitHolder[k] > max) {
                max= profitHolder[k];
            }
		}
		this.profitHolder=profitHolder;
        return max ; 
 	}
 	/*
	 * This method calculates the minimum profit among all products in a file.
	 * @return: amount of profit
	 */
	private double calculateMinProfit(String filename) {
		ObjectHolder tempproductsHolder = new ObjectHolder();
		products = tempproductsHolder.createProductArray(filename);
		double profitHolder[] = new double[products.length];
		int i=0;
        for(Product tempProduct: products) {
			double a =tempProduct.getProfit();
            profitHolder[i]=a;
            i++;
		}
		double min=profitHolder[0];
		for (int k = 0; k < profitHolder.length; k++){
            if (profitHolder[k] < min) {
                min= profitHolder[k];
            }
		}		
		this.profitHolder=profitHolder;
        return min ; 
 	}
	
	/*
	 * This method finds the index of a double value in an double array.
	 * @param parameter: the double array to be searched
	 * @param max: the double value to be searched in the array
	 * @return: the index of the searched value
	 */
	private int findIndexWithValue(double[] parameter,double max) {
		int myindex = -1; 
    	for(int i=0; i<parameter.length; i++) {
        if(parameter[i] == max)
            myindex = i ;
		}
		return myindex ;
	}
	
	/*
	 * This method finds the most profitable product among all products.
	 */
	private Product findMostProfitableProduct(){
		double max1=calculateMaxProfit("S1_Products.csv");
		double max2 = calculateMaxProfit("S2_Products.csv");
		double max3 = calculateMaxProfit("S3_Products.csv");		
	   	
		double max = max1; 
        if(max2 > max) {
            max = max2;
        }
        if(max3 > max) {
            max = max3;
        }
		
		if(max==max3){
			int index= findIndexWithValue(profitHolder, max);
			return products[index];
		}
		else if (max==max2){
			calculateMaxProfit("S2_Products.csv");
			int index= findIndexWithValue(profitHolder, max) ;
			return products[index];
		}
		else if (max==max1){
			calculateMaxProfit("S1_Products.csv");
			int index= findIndexWithValue(profitHolder, max);
			return products[index];
		}
		return null;
	}
	
	/*
	 * This method finds the least profitable product in the file.
	 * @param fileName: name of the file to be searched.
	 */
	private Product findMinProfitableProduct(String fileName){
		double min=calculateMinProfit(fileName);
		int index = findIndexWithValue(profitHolder,min);
		return products[index];
	}
		
		/*
		 * This method finds the maximum sales price in the file.
		 * @return: amount of minimum price
		 */
	private double calculateMaxSalesPrice(String filename) {	
		ObjectHolder tempproductsHolder = new ObjectHolder();
		products = tempproductsHolder.createProductArray(filename);
		priceHolder = new double[products.length];
		int i=0;
        for(Product tempProduct: products) {
			double a =tempProduct.getSalesPrice();
            priceHolder[i]=a;
            i++;
		}
		double maxPrice=priceHolder[0];
		for (int k = 0; k < priceHolder.length; k++){
            if (priceHolder[k] > maxPrice) {
                maxPrice= priceHolder[k];
            }
		}
		
		this.maxPrice=maxPrice;
		return maxPrice;
	}
	
	/*
	 * This method finds the product that has the highest sales price among all products.
	 * @return: the product which has the highest sales price
	 */
	private Product findMostSalesPriceProduct(){
		double max1 = calculateMaxSalesPrice("S1_Products.csv");
		double max2 = calculateMaxSalesPrice("S2_Products.csv");
		double max3 = calculateMaxSalesPrice("S3_Products.csv");		
	   	
		double max = max1; 
        if(max2 > max) {
            max = max2;
        }
        if(max3 > max) {
            max = max3;
        }
		
		if(max==max3){
			int index= findIndexWithValue(priceHolder, maxPrice);
			return products[index];
		}
		else if (max==max2){
			calculateMaxSalesPrice("S2_Products.csv");
			int index= findIndexWithValue(priceHolder, maxPrice);
			return products[index];
		}
		else if (max==max1){
			calculateMaxSalesPrice("S1_Products.csv");
			int index= findIndexWithValue(priceHolder, maxPrice);
			return products[index];
		}
		return null;
	}
	
	/*
	 * This method finds the customer who had most purchases among all customers
	 * @param target: ID of the customer
	 * @return: the customer who had most purchases
	 */
	private Customer findMostPurchasedCustomer(String target){
			ObjectHolder objectHolder = new ObjectHolder();
			Customer[] customerArray = objectHolder.createCustomerArray();
			Customer tempoCustomer = null ;
			for (Customer tempCustomer:customerArray){
				if(tempCustomer.getId().equals(target)){
					tempoCustomer =  tempCustomer;
				}
			}
		return tempoCustomer ;
	}
	
	public String displayMostProfitProduct() {
		Product maxProfitProduct= findMostProfitableProduct();
		return "The most profitable product among the three suppliers : "+maxProfitProduct.toString()+" -> "+maxProfitProduct.getProfit()+" TL profit";
	}
	public String displayMaxSalesPrice() {
		Product maxSalesPriceProduct= findMostSalesPriceProduct();
		return "The most expensive product in terms of Sales Price : " +maxSalesPriceProduct.toString()+"-> with sales price "+maxSalesPriceProduct.getSalesPrice();
	}
	public String displayMostPurchasedCustomer() {
		SalesManagement manage= new SalesManagement();
		manage.createSalesManagementArray("S1_Sales.csv", "S2_Sales.csv", "S3_Sales.csv");
		String purchasedMost= manage.purchasedMost();
		Customer customer=findMostPurchasedCustomer(purchasedMost);
		return "The customer who purchases the most products for all three suppliers : "+customer.toString()+" -> "+manage.getFrequency()+" purchases";
	}
	public String displayTotalProfit() {
		return "The total profit that is made from all sales : "+calculateTotalProfit();
	}
	public String displayMinProfitableProduct() {
		Product minProfitProduct=findMinProfitableProduct("S1_Products.csv");
		return "The least-profit product of S1 : "+minProfitProduct.toString()+" -> "+calculateMinProfit("S1_Products.csv")+" TL profit";
	}
}	
	
	

 

