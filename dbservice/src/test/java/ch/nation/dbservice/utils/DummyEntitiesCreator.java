package ch.nation.dbservice.utils;

import ch.nation.core.model.Enums.StatGrowthType;
import ch.nation.dbservice.entities.characteristics.Characteristic;
import ch.nation.dbservice.entities.characteristics.SkillCharacteristic;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.clazzes.Stat;
import ch.nation.dbservice.entities.skills.Skill;
import ch.nation.dbservice.entities.skills.effects.SkillEffect;
import ch.nation.dbservice.entities.units.EmeddableVector3;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.user.Nation;
import ch.nation.dbservice.entities.user.User;

public final class DummyEntitiesCreator {



    public static Unit getUnit(){
        Unit unit = new Unit();
        unit.setName("Kevin");
        unit.setPosition(new EmeddableVector3(5f,5f,5f));
        unit.setUnitIsDead(true);
   //     unit.setCharacterClass(getClazz());





        return unit;
    }


    public static SkillEffect getSkillEffect(){
        SkillEffect effect =  new SkillEffect();
        effect.setName("Some Skill Effect");
        effect.setDescription("Some desc");
        return effect;


    }


    public static Skill getSkill(){
        Skill dummySkill = new Skill();
        dummySkill.setName("Dummy_skill");
        dummySkill.setDescription("Some dummy skill");


        return dummySkill;
    }

    public static User getUser(){
        User user = new User();
        user.setName("Kevin");
        user.setAdmin(false);
        user.setPassword("123");
        return user;


    }


    public static Nation getNation(){
        Nation nation = new Nation();
        nation.setName("Super Tolle Nation");
        return nation;


    }



    public static CharacterClass getClazz(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Warrior");
        characterClass.setLevel(100);
        characterClass.setHealthPoints(new Stat(40,0,100, StatGrowthType.LINEAR));
        characterClass.setExp(100);
        return characterClass;
    }


    public static Characteristic getBaseCharacteristics(){
        Characteristic chara = new Characteristic();
        chara.setName("Super grosse Leute!");
        return chara;

    }

    public static SkillCharacteristic getSkillCharacteristics(){
        SkillCharacteristic characteristic = new SkillCharacteristic();
        characteristic.setName("Skill Characteristic");
        return characteristic;
    }




}
