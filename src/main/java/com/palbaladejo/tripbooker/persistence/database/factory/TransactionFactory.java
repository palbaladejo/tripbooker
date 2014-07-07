package com.palbaladejo.tripbooker.persistence.database.factory;

import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;
import com.palbaladejo.tripbooker.persistence.database.transaction.ITransaction;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class TransactionFactory {
    public static TransactionFactory instance;
    
    public static synchronized TransactionFactory getInstance(){
        if(instance == null) instance = new TransactionFactoryImp();
        return instance;
    }

    public abstract ITransaction getTransaction() throws TransactionException;
}
