package com.palbaladejo.tripbooker.logic.facade.factory;

import com.palbaladejo.tripbooker.logic.facade.airline.IAirlineFacade;
import com.palbaladejo.tripbooker.logic.facade.business.IBusinessFacade;
import com.palbaladejo.tripbooker.logic.facade.system.ISystemFacade;
import com.palbaladejo.tripbooker.logic.facade.user.IUserFacade;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class FacadeFactory {
    private static FacadeFactory instance;
    
    public static synchronized FacadeFactory getInstance(){
        if(instance == null) instance = new FacadeFactoryImp();
        return instance;
    }
    
    public abstract IBusinessFacade getBusinessFacade();
    public abstract ISystemFacade getSystemFacade();
    public abstract IAirlineFacade getAirlineFacade();
    public abstract IUserFacade getUserFacade();

}
