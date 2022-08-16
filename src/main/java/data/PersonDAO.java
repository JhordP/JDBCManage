package data;

import java.util.List;
import java.sql.SQLException;
import domain.PersonDTO;

public interface PersonDAO {

    public List<PersonDTO> select() throws SQLException;
    public int insert(PersonDTO person) throws SQLException;
    public int update(PersonDTO person) throws SQLException;
    public int delete(PersonDTO person) throws SQLException;
}
