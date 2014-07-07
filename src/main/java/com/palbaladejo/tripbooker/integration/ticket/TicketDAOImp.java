package com.palbaladejo.tripbooker.integration.ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.palbaladejo.tripbooker.dto.domain.factory.DOFactory;
import com.palbaladejo.tripbooker.dto.domain.ticket.ITicketDO;
import com.palbaladejo.tripbooker.integration.factory.DAO;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketDAOImp extends DAO implements ITicketDAO{

    private void copyResultTicketData(ResultSet result, ITicketDO ticket) throws SQLException {
        ticket.setTicketID(result.getInt(1));
        ticket.setCode(result.getString(2));
        ticket.setUserID(result.getInt(3));
    }
    
    @Override
    public List<ITicketDO> getAllTickets() throws TransactionException {
        List<ITicketDO> list = new ArrayList<ITicketDO>();
        String query = "SELECT * FROM ticket";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ITicketDO aircraft = DOFactory.getInstance().getTicketDO();
                copyResultTicketData(resultSet, aircraft);
                list.add(aircraft);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public List<ITicketDO> getAllTicketsByFlight(int flightID) throws TransactionException {
        List<ITicketDO> list = new ArrayList<ITicketDO>();
        String query = "SELECT * FROM ticket WHERE flightID = '"+flightID+"'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ITicketDO aircraft = DOFactory.getInstance().getTicketDO();
                copyResultTicketData(resultSet, aircraft);
                list.add(aircraft);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public int countTicketsByFlight(int flightID) throws TransactionException {
        int count = 0;
        String query = "SELECT COUNT(*) FROM ticket WHERE flightID = '"+flightID+"'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (this.resultSet.next()) {
                count = this.resultSet.getInt(1);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return count;
    }
    
    @Override
    public ITicketDO getTicketByCode(String code) throws TransactionException {
        ITicketDO ticket = null;
        String query = "SELECT * FROM ticket"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                ticket = DOFactory.getInstance().getTicketDO();
                copyResultTicketData(resultSet, ticket);
            } else {
                ticket = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return ticket;
    }

    @Override
    public ITicketDO getTicketByID(int ticketID) throws TransactionException {
        ITicketDO ticket = null;
        String query = "SELECT * FROM ticket"
                + " WHERE ticketID = '" + ticketID + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                ticket = DOFactory.getInstance().getTicketDO();
                copyResultTicketData(resultSet, ticket);
            } else {
                ticket = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return ticket;
    }
    
    @Override
    public boolean persistTicket(ITicketDO ticketDO) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        if(this.getTicketByID(ticketDO.getTicketID()) != null){
            query = "UPDATE ticket SET " 
                + "code = '" + ticketDO.getCode() +"', "
                + "userID = '" + ticketDO.getUserID() +"' "
                + "WHERE ticketID = '" + ticketDO.getTicketID() + "'";
        }else{
            query = "INSERT INTO ticket"
                    + " (`code`, `userID`) VALUES ("
                    + "'" + ticketDO.getCode()+ "', "
                    + "'" + ticketDO.getUserID()+ "' "
                    + ")";
        }
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                InsertActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
        return InsertActionResult;
    }

    @Override
    public boolean removeTicket(int ticketID) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  ticket"
                + " WHERE ticketID = '" + ticketID + "'";
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                deleteActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
        return deleteActionResult;
    }

}
