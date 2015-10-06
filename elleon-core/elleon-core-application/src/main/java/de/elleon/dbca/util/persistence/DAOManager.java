package de.elleon.dbca.util.persistence;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOManager {

	protected Connection connection = null;
	
	protected DAOManager(Connection connection){
		this.connection = connection;
	}
	
	
	public Object execute(DAOCommand command) throws Exception {
		
		return command.execute(this);
		
	}
	
	
	public Object executeAndClose(DAOCommand command) throws Exception {
		try{
			return command.execute(this);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException closeException) {
				closeException.printStackTrace();
				throw closeException;
			}
		}
	}
	
	
	public Object transaction(DAOCommand command) throws Exception{
		try{
			this.connection.setAutoCommit(false);
			Object returnValue = command.execute(this);
			this.connection.commit();
			return returnValue;
		} catch(Exception e){
			try {
				this.connection.rollback();
				throw e;
				
			} catch (SQLException rollBackException) {
				rollBackException.printStackTrace();
				throw rollBackException;
			}
		} finally {
			try {
				this.connection.setAutoCommit(true);
			} catch (SQLException setAutoCommitException) {
				setAutoCommitException.printStackTrace();
				throw setAutoCommitException;
			}
		}
	}
	
	
	public Object transactionAndClose(final DAOCommand command) throws Exception{
		return executeAndClose(new DAOCommand(){
			public Object execute(DAOManager manager) throws Exception  {
				return manager.transaction(command);
			}
		});
	}
	
	
}
