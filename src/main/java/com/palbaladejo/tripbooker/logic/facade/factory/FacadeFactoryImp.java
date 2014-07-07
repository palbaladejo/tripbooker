package com.palbaladejo.tripbooker.logic.facade.factory;

import com.palbaladejo.tripbooker.logic.facade.airline.AirlineFacade;
import com.palbaladejo.tripbooker.logic.facade.airline.IAirlineFacade;
import com.palbaladejo.tripbooker.logic.facade.business.BusinessFacade;
import com.palbaladejo.tripbooker.logic.facade.business.IBusinessFacade;
import com.palbaladejo.tripbooker.logic.facade.system.ISystemFacade;
import com.palbaladejo.tripbooker.logic.facade.system.SystemFacade;
import com.palbaladejo.tripbooker.logic.facade.user.IUserFacade;
import com.palbaladejo.tripbooker.logic.facade.user.UserFacade;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FacadeFactoryImp extends FacadeFactory{
    @Override
    public ISystemFacade getSystemFacade() {
        return new SystemFacade();
    }

    @Override
    public IAirlineFacade getAirlineFacade() {
        return new AirlineFacade();
    }

    @Override
    public IUserFacade getUserFacade() {
        return new UserFacade();
    }
    
    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }
}
