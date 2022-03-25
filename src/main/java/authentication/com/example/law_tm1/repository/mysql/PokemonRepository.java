package authentication.com.example.law_tm1.repository.mysql;

import authentication.com.example.law_tm1.model.mysql.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByDex(Long dex);

    Pokemon findByName(String name);

    List<Pokemon> findAll();

//    Optional<Pokemon> findAllPokemon();
}
