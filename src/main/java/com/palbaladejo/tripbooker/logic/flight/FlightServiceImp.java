package com.palbaladejo.tripbooker.logic.flight;

import java.util.ArrayList;
import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.flight.IFlightBean;
import com.palbaladejo.tripbooker.dto.domain.aircraft.IAircraftDO;
import com.palbaladejo.tripbooker.dto.domain.airline.IAirlineDO;
import com.palbaladejo.tripbooker.dto.domain.airport.IAirportDO;
import com.palbaladejo.tripbooker.dto.domain.flight.IFlightDO;
import com.palbaladejo.tripbooker.dto.domain.route.IRouteDO;
import com.palbaladejo.tripbooker.dto.mapper.DTOMapper;
import com.palbaladejo.tripbooker.integration.factory.DAOFactory;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;
import com.palbaladejo.tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightServiceImp implements IFlightService{

    @Override
    public List<IFlightBean> getAllFlights() {
        List<IFlightBean> result = new ArrayList<IFlightBean>();
            try {
                //Get all the flights
                List<IFlightDO> flightDOlist = DAOFactory.getInstance().getFlightDAO().getAllFlights();

                for(IFlightDO flightDO : flightDOlist){
                    //Get Airline
                    IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());
                
                    //Get Route
                    IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByID(flightDO.getRouteID());

                    //Get the airports
                    IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                    IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                    //Get the aircraft
                    IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                    //Convert the data
                    IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);

                    //Store the result
                    result.add(flightBean);
                }

            } catch (TransactionException ex) {
                //TODO
            }
        return result;
    }
    
    @Override
    public List<IFlightBean> getAllFlightsSeats() {
        List<IFlightBean> result = new ArrayList<IFlightBean>();
            try {
                //Get all the flights
                List<IFlightDO> flightDOlist = DAOFactory.getInstance().getFlightDAO().getAllFlights();

                for(IFlightDO flightDO : flightDOlist){
                    //1) Get the capacity
                    IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());                    
                    
                    //2) Get the slod tickets
                    int tickets = DAOFactory.getInstance().getTicketDAO().countTicketsByFlight(flightDO.getFlightID());
                    
                    if((aircraftDO.getSeats() - tickets) > 0){//Flight with empty seats
                        //Get Airline
                        IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());

                        //Get Route
                        IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByID(flightDO.getRouteID());

                        //Get the airports
                        IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                        IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                        //Convert the data
                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);

                        //Store the result
                        result.add(flightBean);
                    }
                }
            } catch (TransactionException ex) {
                //TODO
            }
        return result;
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByAirline(String airlineCode) {
        List<IFlightBean> result = new ArrayList<IFlightBean>();
            try {
                //Get Airline
                IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(airlineCode);

                if(airlineDO != null){
                    //Get all the flights by Airline
                    List<IFlightDO> flightDOlist = DAOFactory.getInstance().getFlightDAO().getFlightsByAirline(airlineDO.getAirlineID());

                    for(IFlightDO flightDO : flightDOlist){               
                        //Get Route
                        IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRouteByID(flightDO.getRouteID());

                        //Get the airports
                        IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());
                        IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                        //Get the aircraft
                        IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                        //Convert the data
                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);
                        
                        //Store the result
                        result.add(flightBean);
                    }
                }

            } catch (TransactionException ex) {
                //TODO
            }
        return result;
    }

    @Override
    public List<IFlightBean> getAllFlightsByDepartureAirport(String airportCode) {
        List<IFlightBean> resultBean = new ArrayList<IFlightBean>();
        try {
            //Get Airport
            IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportCode);
            
            if(departure != null){
                //Get all the routes from departure
                List<IRouteDO> routesDO = DAOFactory.getInstance().getRouteDAO().getAllRoutesByDeparture(departure.getAirportID());

                for(IRouteDO routeDO : routesDO){
                    //Get the destination
                    IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                    //Get all flights for each route
                    List<IFlightDO> flightsDO = DAOFactory.getInstance().getFlightDAO().getFlightsByRoute(routeDO.getRouteID());
                    for(IFlightDO flightDO : flightsDO){

                        //Get the Airline
                        IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());

                        //Get the Aircraft
                        IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);
                        resultBean.add(flightBean);
                    }
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return resultBean;
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDestinationAirport(String airportCode) {
        List<IFlightBean> resultBean = new ArrayList<IFlightBean>();
        try {
            //Get Airport
            IAirportDO destination = DAOFactory.getInstance().getAirportDAO().getAirportByCode(airportCode);
            
            if(destination != null){
                //Get all the routes from departure
                List<IRouteDO> routesDO = DAOFactory.getInstance().getRouteDAO().getAllRoutesByDestination(destination.getAirportID());

                for(IRouteDO routeDO : routesDO){
                    //Get the Airports
                    IAirportDO departure = DAOFactory.getInstance().getAirportDAO().getAirportByID(routeDO.getDepartureID());

                    //Get all flights for each route
                    List<IFlightDO> flightsDO = DAOFactory.getInstance().getFlightDAO().getFlightsByRoute(routeDO.getRouteID());
                    for(IFlightDO flightDO : flightsDO){

                        //Get the Airline
                        IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());

                        //Get the Aircraft
                        IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                        IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departure, destination, aircraftDO);
                        resultBean.add(flightBean);
                    }
                }
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return resultBean;
    }

    @Override
    public List<IFlightBean> getAllFlightsByAirports(String departureCode, String destinationCode) {
        List<IFlightBean> resultBean = new ArrayList<IFlightBean>();
        try{
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(departureCode);
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(destinationCode);

            IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRoute(departureDO.getAirportID(), destinationDO.getAirportID());           
            
            //Get all flights for each route
            List<IFlightDO> flightsDO = DAOFactory.getInstance().getFlightDAO().getFlightsByRoute(routeDO.getRouteID());
            for(IFlightDO flightDO : flightsDO){

                //Get the Airline
                IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByID(flightDO.getAirlineID());

                //Get the Aircraft
                IAircraftDO aircraftDO = DAOFactory.getInstance().getAircraftDAO().getAircraftByID(flightDO.getAircraftID());

                IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO, airlineDO, departureDO, destinationDO, aircraftDO);
                resultBean.add(flightBean);
            }
        }catch(Exception e){

        }
        return resultBean;
    }

    @Override
    public boolean persistFlight(IFlightBean flightBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IAirportDO departureDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(flightBean.getDepartureCode());
            IAirportDO destinationDO = DAOFactory.getInstance().getAirportDAO().getAirportByCode(flightBean.getDestinationCode());
            if(departureDO != null && destinationDO != null){
                
                IRouteDO routeDO = DAOFactory.getInstance().getRouteDAO().getRoute(departureDO.getAirportID(), destinationDO.getAirportID());
                IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(flightBean.getAirline());
                IAircraftDO aircraftDO =  DAOFactory.getInstance().getAircraftDAO().getAircraftByModel(flightBean.getAircraftModel());
                if(routeDO != null && airlineDO != null && aircraftDO != null){
                    IFlightDO flightDO = DTOMapper.getInstance().getFlightDO(flightBean, aircraftDO, airlineDO, routeDO);
                    result = DAOFactory.getInstance().getFlightDAO().persistFlight(flightDO);
                }
            }
            TransactionManager.getInstance().commit();
        } catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - Close error
            }
        }
        return result;
    }

    @Override
    public boolean removeFlight(IFlightBean flightBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            IFlightDO flightDO = DAOFactory.getInstance().getFlightDAO().getFlightByCodeDate(flightBean.getCode(),flightBean.getDate());
            if(flightDO != null){
                result = DAOFactory.getInstance().getFlightDAO().removeFlight(flightDO.getFlightID());
            }
            TransactionManager.getInstance().commit();
        }catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollbacke error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - Close Error
            }
        }
        return result;
    }
}
