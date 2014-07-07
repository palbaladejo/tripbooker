package com.palbaladejo.tripbooker.logic.ticket;

import java.util.ArrayList;
import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.ticket.ITicketBean;
import com.palbaladejo.tripbooker.dto.domain.airline.IAirlineDO;
import com.palbaladejo.tripbooker.dto.domain.flight.IFlightDO;
import com.palbaladejo.tripbooker.dto.domain.ticket.ITicketDO;
import com.palbaladejo.tripbooker.dto.domain.user.IUserDO;
import com.palbaladejo.tripbooker.dto.mapper.DTOMapper;
import com.palbaladejo.tripbooker.integration.factory.DAOFactory;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;
import com.palbaladejo.tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketServiceImp implements ITicketService{

    @Override
    public List<ITicketBean> getAllTickets() {
        List<ITicketBean> result = new ArrayList<ITicketBean>();
        try{
            List<ITicketDO> list = DAOFactory.getInstance().getTicketDAO().getAllTickets();
            for(ITicketDO ticketDO : list){
                IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByID(ticketDO.getUserID());
                IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByID(ticketDO.getFlightID());
                result.add(DTOMapper.getInstance().getTicketBean(ticketDO,userDO,flightDO));
            }
        } catch(TransactionException ex){
            //TODO
        }
        return result;
    }

    @Override
    public List<ITicketBean> getAllTicketsByAirline(String airlineCode) {
        List<ITicketBean> result = new ArrayList<ITicketBean>();
        try{
            IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(airlineCode);
            if(airlineDO != null ){
                List<IFlightDO> flightList = DAOFactory.getInstance().getFlightDAO().getFlightsByAirline(airlineDO.getAirlineID());
                for(IFlightDO flightDO : flightList){
                    List<ITicketDO> ticketList = DAOFactory.getInstance().getTicketDAO().getAllTicketsByFlight(flightDO.getFlightID());
                    for(ITicketDO ticketDO : ticketList){
                        IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByID(ticketDO.getUserID());
                        result.add(DTOMapper.getInstance().getTicketBean(ticketDO,userDO,flightDO));
                    }
                }
            }
        } catch(TransactionException ex){
            //TODO
        }
        return result;
    }

    @Override
    public ITicketBean getTicketByCode(String code) {
        ITicketDO ticketDO = null;
        IUserDO userDO = null;
        IFlightDO flightDO = null;
        try{
            ticketDO = DAOFactory.getInstance().getTicketDAO().getTicketByCode(code);
            if(ticketDO != null){
                userDO = DAOFactory.getInstance().getUserDAO().getUserByID(ticketDO.getUserID());
                flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByID(ticketDO.getFlightID());
            }
        }catch (TransactionException ex){
            //TODO
        }
        return DTOMapper.getInstance().getTicketBean(ticketDO,userDO,flightDO);
    }

    @Override
    public boolean persistTicket(ITicketBean ticketBean) {
        boolean result = false;        
        try{
            TransactionManager.getInstance().begin();
            IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByCode(ticketBean.getUserCode());
            IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByCodeDate(ticketBean.getCode(),ticketBean.getFlightDate());
            if(userDO != null && flightDO != null){
                ITicketDO ticketDO = DTOMapper.getInstance().getTicketDO(ticketBean,userDO,flightDO);
                result = DAOFactory.getInstance().getTicketDAO().persistTicket(ticketDO);
                TransactionManager.getInstance().commit();
            }
        }catch(TransactionException ex){
            try{
                TransactionManager.getInstance().rollback();
            }catch (TransactionException ex1){
                //TODO - Rollback error
            }
        }finally{
            try{
                TransactionManager.getInstance().close();
            }catch (TransactionException ex){
                //TODO - Close error
            }
        }     
        return result;
    }

    @Override
    public boolean removeTicket(ITicketBean ticketBean) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            ITicketDO ticketDO = DAOFactory.getInstance().getTicketDAO().getTicketByCode(ticketBean.getCode());
            if(ticketDO != null){
                result = DAOFactory.getInstance().getTicketDAO().removeTicket(ticketDO.getTicketID());
            }
            TransactionManager.getInstance().commit();
        }catch(TransactionException ex){
            try{
                TransactionManager.getInstance().rollback();
            }catch (TransactionException ex1){
                //TODO - Rollback error
            }
        }finally{
            try{
                TransactionManager.getInstance().close();
            }catch (TransactionException ex){
                //TODO - Close error
            }
        }     
        return result;
    }

}
