package com.palbaladejo.tripbooker.persistence.database.factory;

import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;
import com.palbaladejo.tripbooker.persistence.database.transaction.ITransaction;
import com.palbaladejo.tripbooker.persistence.database.transaction.Transaction;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TransactionFactoryImp extends TransactionFactory{

    @Override
    public ITransaction getTransaction() throws TransactionException {
       return new Transaction();
    }

}
