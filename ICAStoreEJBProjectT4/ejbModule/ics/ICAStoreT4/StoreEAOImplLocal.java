package ics.ICAStoreT4;

import java.util.List;

import org.ics.exceptions.MyICAException;

import jakarta.ejb.Local;

@Local
public interface StoreEAOImplLocal {
	
	public Store findByStoreId(int id) throws MyICAException;
	public Store createStore(Store store);
	public Store updateStore(Store store);
	public void deleteStore(int id) throws MyICAException;
	public List<Store>findAllStores() throws MyICAException;
	 public List<Object[]> findSalesSummaryBySupermarketId(int supermarketId) throws MyICAException;

}
