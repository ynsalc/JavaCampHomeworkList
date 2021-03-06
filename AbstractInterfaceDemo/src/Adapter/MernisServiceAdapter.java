package Adapter;

import java.rmi.RemoteException;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService
{

	@Override
	public boolean CheckIfRealPerson(Customer customer)
	{
		boolean result=false;
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try 
		{
			result=client.TCKimlikNoDogrula(
			Long.parseLong(customer.getNationalityId()),
			customer.getFirstName().toUpperCase(), 
			customer.getLastName().toUpperCase(), 
			customer.getDateOfBirth());
		}
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}
		
		if(result)
		{
			System.out.println("Kimlik do?rulama ba?ar?l?.");
		}
		else
		{
			System.out.println("Kimlik do?rulama ba?ar?s?z.");
		}
		
		return result;
	}
	
}
