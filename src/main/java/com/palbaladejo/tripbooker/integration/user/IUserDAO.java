package com.palbaladejo.tripbooker.integration.user;

import java.util.List;
import com.palbaladejo.tripbooker.dto.domain.user.IUserDO;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IUserDAO {
    List<IUserDO> getAllUsers() throws TransactionException;
    IUserDO getUserByID(int userID) throws TransactionException;
    IUserDO getUserByCode(String code) throws TransactionException;
    boolean removeUser(int userID) throws TransactionException;
    boolean persistUser(IUserDO userDO) throws TransactionException;
}
