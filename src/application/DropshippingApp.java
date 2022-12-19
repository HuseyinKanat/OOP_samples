/* @authors 
 * Yusuf Bayındır     280201049	
 * Hüseyin Kanat      280201027
 * Ahmet Çoko         290201006
 * Rana Elif Albayrak 280201037
 */

package application;
import program.SalesQuery;

public class DropshippingApp {

	public static void main(String[] args) {	
		SalesQuery sq= new SalesQuery();
		System.out.println(sq.displayMostProfitProduct()+"\n"+sq.displayMaxSalesPrice()+"\n"+sq.displayMostPurchasedCustomer()+"\n"+sq.displayTotalProfit()+"\n"+sq.displayMinProfitableProduct());
	}
}

