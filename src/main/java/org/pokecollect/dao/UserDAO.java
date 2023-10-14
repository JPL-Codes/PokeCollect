package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;
import org.pokecollect.dto.User;

public interface UserDAO {
    User save(User user) throws Exception;
    User fetch(int userId);

}
