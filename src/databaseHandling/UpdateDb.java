package databaseHandling;

import ContactHandling.Contact;

import java.sql.*;


public abstract class UpdateDb {



    public static boolean callDb(Connection connection,Contact contact) {
        int rows = -1;
        if (connection != null) {
            Statement stm = null;

            try {
                String query = "UPDATE contacs SET firstname="+contact.getFirstName()+
                        ",lastname="+contact.getLastName()+
                        ",phone="+contact.getPhone()+
                        ",adress="+contact.getAddress()+
                        ",email="+contact.getEmail()+
                        " WHERE id="+contact.getId()+";";
                System.out.println(query); // Säkra att du skrivit rätt, tas bort senare.
                stm = connection.createStatement();
                rows = stm.executeUpdate(query);


            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
            } finally {


            }

        }

        if (rows < 0) {
            return false;
        } else {
            return true;
        }
    }

}