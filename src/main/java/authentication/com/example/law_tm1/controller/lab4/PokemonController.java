package authentication.com.example.law_tm1.controller.lab4;

import authentication.com.example.law_tm1.model.mysql.Pokemon;
import authentication.com.example.law_tm1.service.lab4.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "pokemon")
public class PokemonController{
    @Qualifier("pokemonServiceImpl")
    @Autowired
    PokemonService pokemonService;

    @PostMapping("")
    public Pokemon addNewPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.addPokemon(pokemon);
    }

    @GetMapping("/{dex}")
    public Pokemon findPokemonByDex(@PathVariable Long dex){
        return pokemonService.findPokemonByDex(dex);
    }

    @PutMapping("/save")
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon){
        Pokemon oldPokemon = pokemonService.findPokemonByName(pokemon.getName());
        Pokemon newPokemon = new Pokemon();

        newPokemon.setDex(oldPokemon.getDex());

        newPokemon.setName(pokemon.getName() != null ?
                pokemon.getName() : oldPokemon.getName());
        newPokemon.setTypeOne(pokemon.getTypeOne() != null ?
                pokemon.getTypeOne() : oldPokemon.getTypeOne());
        newPokemon.setTypeTwo(pokemon.getTypeTwo() != null ?
                pokemon.getTypeTwo() : oldPokemon.getTypeTwo());
        newPokemon.setAbilityOne(pokemon.getAbilityOne() != null ?
                pokemon.getAbilityOne() : oldPokemon.getAbilityOne());
        newPokemon.setAbilityTwo(pokemon.getAbilityTwo() != null ?
                pokemon.getAbilityTwo() : oldPokemon.getAbilityTwo());
        newPokemon.setHiddenAbility(pokemon.getHiddenAbility() != null ?
                pokemon.getHiddenAbility() : oldPokemon.getHiddenAbility());
        newPokemon.setHp(pokemon.getHp() != 0 ?
                pokemon.getHp() : oldPokemon.getHp());
        newPokemon.setAttack(pokemon.getAttack() != 0 ?
                pokemon.getAttack() : oldPokemon.getAttack());
        newPokemon.setDefense(pokemon.getDefense() != 0 ?
                pokemon.getDefense() : oldPokemon.getDefense());
        newPokemon.setSpecialAttack(pokemon.getSpecialAttack() != 0 ?
                pokemon.getSpecialAttack() : oldPokemon.getSpecialAttack());
        newPokemon.setSpecialDefense(pokemon.getSpecialDefense() != 0 ?
                pokemon.getSpecialDefense() : oldPokemon.getSpecialDefense());
        newPokemon.setSpeed(pokemon.getSpeed() != 0 ?
                pokemon.getSpeed() : oldPokemon.getSpeed());

        return pokemonService.savePokemon(newPokemon);
    }

    @PostMapping("/save/picture/{dex}")
    public Pokemon savePokemonPicture(@RequestParam("file")MultipartFile file,
                                      @PathVariable Long dex) throws IOException {
        return pokemonService.savePokemonPicture(dex, file);

    }

    @DeleteMapping("/delete/{dex}")
    public String deletePokemon(@PathVariable Long dex){
        String pokemonName = pokemonService.findPokemonByDex(dex).getName();
        pokemonService.deletePokemon(dex);
        return pokemonName + " is deleted from PokeDex!";
    }

}
