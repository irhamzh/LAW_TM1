package authentication.com.example.law_tm1.service.lab4;

import authentication.com.example.law_tm1.model.mysql.Pokemon;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PokemonService {
    Pokemon addPokemon(Pokemon pokemon);

    Pokemon savePokemon(Pokemon pokemon);

    Pokemon savePokemonPicture(Long dex, MultipartFile file) throws IOException;

    Pokemon findPokemonByDex(Long dex);

    Pokemon findPokemonByName(String name);

    void deletePokemon(Long dex);
}
