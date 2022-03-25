package authentication.com.example.law_tm1.model.mysql;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dex;

    @NotNull
    @Size(max = 30)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(max = 30)
    @Column(name = "type_1", nullable = false)
    private String typeOne;

    @Size(max = 30)
    @Column(name = "type_2", nullable = true)
    private String typeTwo;

    @NotNull
    @Size(max = 30)
    @Column(name = "ability_1", nullable = false)
    private String abilityOne;

    @Size(max = 30)
    @Column(name = "ability_2", nullable = true)
    private String abilityTwo;

    @Size(max = 30)
    @Column(name = "hidden_ability", nullable = true)
    private String hiddenAbility;

    @NotNull
    @Column(name = "health_point", nullable = false)
    private int hp;

    @NotNull
    @Column(name = "attack", nullable = false)
    private int attack;

    @NotNull
    @Column(name = "defense", nullable = false)
    private int defense;

    @NotNull
    @Column(name = "special_attack", nullable = false)
    private int specialAttack;

    @NotNull
    @Column(name = "special_defense", nullable = false)
    private int specialDefense;

    @NotNull
    @Column(name = "speed", nullable = false)
    private int speed;

    @Size(max = 50)
    @Column(name = "file_name", nullable = true)
    private String fileName;

    @Lob
    @Column(name = "file_content", nullable = true)
    private byte[] content;

    public Pokemon(){

    }

    public Long getDex() {
        return dex;
    }

    public void setDex(Long dex) {
        this.dex = dex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        this.typeOne = typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo;
    }

    public String getAbilityOne() {
        return abilityOne;
    }

    public void setAbilityOne(String abilityOne) {
        this.abilityOne = abilityOne;
    }

    public String getAbilityTwo() {
        return abilityTwo;
    }

    public void setAbilityTwo(String abilityTwo) {
        this.abilityTwo = abilityTwo;
    }

    public String getHiddenAbility() {
        return hiddenAbility;
    }

    public void setHiddenAbility(String hiddenAbility) {
        this.hiddenAbility = hiddenAbility;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
