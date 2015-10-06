package de.elleon.dbca.util.persistence;

public abstract class PersistenceActionBase {

	
	protected DAOManager daoManager = null;
	protected boolean closeConnectionAfterAction;

	public PersistenceActionBase(DAOManager daoManager){
		this(daoManager, true);
	}
	
	public PersistenceActionBase(DAOManager daoManager, boolean closeConnectionAfterAction){
		this.daoManager = daoManager;
		this.closeConnectionAfterAction = closeConnectionAfterAction;
	}

	public Object doAction() throws Exception {
		
		if (closeConnectionAfterAction) {
			return this.daoManager.transactionAndClose(new DAOCommand(){
				public Object execute(DAOManager manager) throws Exception{
					return doPersistenceAction(manager);
				}
			});
		}
		
		return this.daoManager.execute(new DAOCommand(){
			public Object execute(DAOManager manager) throws Exception{
				return doPersistenceAction(manager);
			}
		});

	}

	protected abstract Object doPersistenceAction(DAOManager manager) throws Exception;
	
}
