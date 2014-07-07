package com.palbaladejo.tripbooker.integration.country;

import java.util.List;
import com.palbaladejo.tripbooker.dto.domain.country.ICountryDO;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICountryDAO {
    List<ICountryDO> getAllCountries()throws TransactionException;
    ICountryDO getCountryByID(int id)throws TransactionException;
    ICountryDO getCountryByCode(String code)throws TransactionException;
    ICountryDO getCountryByName(String name)throws TransactionException;
    boolean persistCountry(ICountryDO country) throws TransactionException;
    boolean removeCountry(int id) throws TransactionException;
}
