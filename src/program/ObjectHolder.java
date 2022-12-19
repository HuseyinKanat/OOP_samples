package program;
import fileOperation.FileOperation;

public class ObjectHolder {
	
	/*
	 * This class has methods to create arrays of each object.
	 */
	
	public Customer[] createCustomerArray() {
		FileOperation fOperator= new FileOperation();
		fOperator.takeTheContentOfFile("Customers.csv");
		String[][] tempContentArray= fOperator.generateArrayForContentOfFile();
		int numberOfLines=fOperator.getNumberOfLines();
		Customer[] customerArray= new Customer[numberOfLines-1] ;
		int k=0;
		for(int i =1; i < numberOfLines ; i++ ) {
			Customer tempCustomer = new Customer(tempContentArray[i][k], tempContentArray[i][k+1], tempContentArray[i][k+2], tempContentArray[i][k+3], tempContentArray[i][k+4]);
			customerArray[i-1]= tempCustomer;       		
        }
		return customerArray;
	}
	public Product[] createProductArray(String fileName) {
		FileOperation fOperator= new FileOperation();
		fOperator.takeTheContentOfFile(fileName);
		String[][] tempContentArray= fOperator.generateArrayForContentOfFile();
		int numberOfLines=fOperator.getNumberOfLines();
		Product[] productArray= new Product[numberOfLines-1] ;
		int k=0;
		for(int i =1; i < numberOfLines ; i++ ) {
			Product tempProduct = new Product(tempContentArray[i][k], tempContentArray[i][k+1], Double.parseDouble(tempContentArray[i][k+2]), Integer.parseInt(tempContentArray[i][k+3]),Integer.parseInt(tempContentArray[i][k+4]));
			productArray[i-1]= tempProduct;       
		}
		return productArray;
	}
	public Sales[] createSalesArray(String fileName) {
		FileOperation fOperator= new FileOperation();
		fOperator.takeTheContentOfFile(fileName);
		String[][] tempContentArray= fOperator.generateArrayForContentOfFile();
		int numberOfLines=fOperator.getNumberOfLines();
		Sales[] salesArray= new Sales[numberOfLines-1] ;
		int k=0;
		for(int i =1; i < numberOfLines ; i++ ) {
			Sales tempSales = new Sales(Integer.parseInt(tempContentArray[i][k]),tempContentArray[i][k+1],tempContentArray[i][k+2],tempContentArray[i][k+3]);
			salesArray[i-1]= tempSales;       
		}
		return salesArray;
	}
}
