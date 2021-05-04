package AbstractInterfaceDemo;

import Abstract.BaseCustomerManager;
import Adapter.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) 
	{
		Customer customer = new Customer();
		customer.setDateOfBirth(1997);
		customer.setFirstName("Yunus");
		customer.setLastName("Alýcý");
		customer.setNationalityId("13612341966");
		
		BaseCustomerManager customerManagerNero = new NeroCustomerManager();
		customerManagerNero.Save(customer);
		
		BaseCustomerManager customerManager=new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.Save(customer);
	}

}
