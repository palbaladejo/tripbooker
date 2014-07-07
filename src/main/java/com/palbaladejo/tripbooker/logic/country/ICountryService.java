package com.palbaladejo.tripbooker.logic.country;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.country.ICountryBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICountryService {
    List<ICountryBean> getAllCountries();
    ICountryBean getCountryByName(String name);
    boolean persistCountry(ICountryBean countryBean);
    boolean removeCountry(ICountryBean countryBean);
}
