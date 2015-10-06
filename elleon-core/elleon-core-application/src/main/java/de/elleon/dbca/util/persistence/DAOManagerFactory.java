package de.elleon.dbca.util.persistence;

public interface DAOManagerFactory {

	public abstract DAOManager getDAOManager() throws Exception;
	
	public abstract DAOManager getDAOManager(String name) throws Exception;
	
	
}
