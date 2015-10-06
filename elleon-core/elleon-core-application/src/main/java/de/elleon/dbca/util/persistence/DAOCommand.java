package de.elleon.dbca.util.persistence;

interface DAOCommand {
	Object execute(DAOManager daoManager) throws Exception;
}
