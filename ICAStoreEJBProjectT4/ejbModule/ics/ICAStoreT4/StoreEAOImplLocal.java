package ics.ICAStoreT4;

import java.util.List;

import jakarta.ejb.Local;

@Local
public interface StoreEAOImplLocal {
	
	public Store findByStoreId(int id);
	public Store createStore(Store store);
	public Store updateStore(Store store);
	public void deleteStore(int id);
	public List<Store>findAllStores();

}
