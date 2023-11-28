package org.pokecollect.dao;

import org.pokecollect.dto.Pokecard;
import org.pokecollect.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

 //   SecurityUser findUserByUsername(String username);

    @Query("SELECT u.pokecardCollection FROM User u WHERE u.id = :userId")
    List<Pokecard> findPokecardCollectionByUserId(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM user_pokecards WHERE user_id = userId AND pokecard_pokecard_id = pokecardId")
    void deletePokecardFromCollection(@Param("userId") Long userId, @Param("pokecardId") int pokecardId);
}
