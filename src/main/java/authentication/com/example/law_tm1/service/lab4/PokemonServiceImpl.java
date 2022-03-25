package authentication.com.example.law_tm1.service.lab4;

import authentication.com.example.law_tm1.model.mysql.Pokemon;
import authentication.com.example.law_tm1.repository.mysql.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService{
    @Autowired
    PokemonRepository pokemonRepository;

    @Override
    public Pokemon addPokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon findPokemonByDex(Long dex){
        return pokemonRepository.findByDex(dex);
    }

    @Override
    public Pokemon findPokemonByName(String name){
        return pokemonRepository.findByName(name);
    }

    @Override
    public Pokemon savePokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon savePokemonPicture(Long dex, MultipartFile file) throws IOException {
        Pokemon updatedPokemon = pokemonRepository.findByDex(dex);
        updatedPokemon.setFileName(file.getOriginalFilename());
        updatedPokemon.setContent(file.getBytes());
        return pokemonRepository.save(updatedPokemon);
    }

    @Override
    public void deletePokemon(Long dex){
        pokemonRepository.delete(pokemonRepository.findByDex(dex));
    }

}
