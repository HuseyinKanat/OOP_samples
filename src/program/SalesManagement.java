package program;
public class SalesManagement {
	private Sales[][] salesManagementArray ;
	
	public SalesManagement() {};
	Sales[] allSales;
	/*
	 * This method creates a two dimensional array that holds the sales which we can
	 * call by supplier number in first dimension and sales number in second.
	 */
	public void createSalesManagementArray(String file1,String file2,String file3){
        ObjectHolder objectHolder1= new ObjectHolder();
        
        Sales[] salesArr1=objectHolder1.createSalesArray(file1);
        Sales[] salesArr2=objectHolder1.createSalesArray(file2);
        Sales[] salesArr3=objectHolder1.createSalesArray(file3);
        
        int numberOfLines=salesArr1.length;
        int numberOfLines2=salesArr2.length;
        int numberOfLines3=salesArr3.length;
		
        int maxOfTwo= Math.max(numberOfLines, numberOfLines2);
		int finalMax= Math.max(maxOfTwo, numberOfLines3);
		
		Sales[][] salesManagementArray = new Sales[3][finalMax];
		int i=0;
        for(Sales sales1 : salesArr1){
            salesManagementArray[0][i] = sales1;
            i++;
        }
        i=0;
        for(Sales sales2 : salesArr2){
            salesManagementArray[1][i] = sales2;
            i++;
        }
        i=0;
        for(Sales sales3 : salesArr3){
            salesManagementArray[2][i] = sales3;
            i++;
        }
        this.salesManagementArray=salesManagementArray;     
	}
    public Sales[][] getSalesManagementArray(){
        return salesManagementArray;
    }
    /*
     * This method finds the customer who had purchased most product among three suppliers.
     * @return: Customer's ID
     */
	public String purchasedMost(){    
        int b=0;
	    for(Sales e:salesManagementArray[0]) {
		    if (e!=null) {
			    b++;
		    }
		}
		for(Sales c:salesManagementArray[1]) {
			if (c!=null) {
				b++;
			}
		}
		for(Sales d:salesManagementArray[2]) {
			if (d!=null) {
				b++;
			}
		}

        allSales = new Sales[b];
        
        int i = 0;
        for (Sales[] row : salesManagementArray) {
			for(Sales val1 : row) {
                if(val1!=null) {
				allSales[i] = val1;
                i++;
                }
			}
		}
            String customerId = "";
            int frequency = 0;
            int counter = 1;
            
            // loop for finding the customer had most purchases.
            for (int a = 0; a < allSales.length-1; a++)
            {
                    if (allSales[a].getCustomer().equals(allSales[a + 1].getCustomer())){
                        counter++;
                        }
                    if( a==(allSales.length-2) || !allSales[a].getCustomer().equals(allSales[a+1].getCustomer()))
                {      
                    if (counter > frequency)
                    {       
                        frequency = counter;
                        customerId = allSales[a].getCustomer();
                    }
                    counter = 1;
                }
            }
          
    return customerId;
    }
	/*
	 * This method calculates the how many times the customer purchased.
	 */
	public int getFrequency() {
		int frequency = 0;
		//loop for traversing allSales array and counting.
		for(int a=0; a<allSales.length; a++) {
			if(allSales[a].getCustomer().equals(purchasedMost())) {
				frequency++;
			}
		}
		return frequency;
	}
}
