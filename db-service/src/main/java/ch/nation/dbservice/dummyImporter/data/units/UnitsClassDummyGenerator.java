package ch.nation.dbservice.dummyImporter.data.units;

import ch.nation.core.model.Enums.UnitState;
import ch.nation.dbservice.dummyImporter.data.AbstractDummyGenerator;
import ch.nation.dbservice.entities.clazzes.CharacterClass;
import ch.nation.dbservice.entities.units.EmeddableVector3;
import ch.nation.dbservice.entities.units.Unit;
import ch.nation.dbservice.entities.units.UnitAssets;
import ch.nation.dbservice.repositories.clazzes.CharacterClassRepository;
import ch.nation.dbservice.repositories.units.UnitRepository;

public class UnitsClassDummyGenerator extends AbstractDummyGenerator<Unit> {

    private final UnitRepository unitRepository;
    private final CharacterClassRepository characterClassRepository;

    public UnitsClassDummyGenerator(UnitRepository unitRepository, CharacterClassRepository characterClassRepository) throws Exception {
        super();
        this.unitRepository = unitRepository;
        this.characterClassRepository = characterClassRepository;
        handleCration();
    }


    @Override
    protected void handleCration() throws Exception {
        createWarrior();
        createWarrior2();
        createBarbar();
        createShinChanDerZeitmagaier();
    }

    private void createWarrior(){
        Unit unit = new Unit();
        unit.setName("Kaffi däääää Schwärt");
        unit.setPosition(new EmeddableVector3(5f,5f,5f));
        UnitAssets unitAssets = new UnitAssets();
        unitAssets.setHead("Basic/Head");
        unitAssets.setWeaponType("Melee1H");
        unitAssets.setHelmet("Samurai/NinjaHelm2 [Paint]");
        unitAssets.setArmor("Basic/BanditLightArmor [Paint]");
        unit.setUnitAssets(unitAssets);
        unit.setState(UnitState.IDLE);


        unit = unitRepository.save(unit);


        CharacterClass characterClass = characterClassRepository.findByIdentifier("warrior");

        unit.setCharacterClass(characterClass);




        unitRepository.save(unit);


    }

    private void createWarrior2(){
        Unit unit = new Unit();
        unit.setName("Dumbo");
        unit.setPosition(new EmeddableVector3(5f,5f,5f));
        UnitAssets unitAssets = new UnitAssets();
        unitAssets.setHead("Basic/Head");
        unitAssets.setHelmet("Samurai/NinjaHelm2 [Paint]");
        unitAssets.setArmor("SpellMasters/NecromancerArmor");
        unit.setUnitAssets(unitAssets);
        unitAssets.setWeaponType("Melee1H");
        unit.setState(UnitState.IDLE);


        unit = unitRepository.save(unit);


        CharacterClass characterClass = characterClassRepository.findByIdentifier("warrior");

        unit.setCharacterClass(characterClass);




        unitRepository.save(unit);


    }

    private void createBarbar(){
        Unit unit = new Unit();
        unit.setName("Judas der Barbar");
        unit.setPosition(new EmeddableVector3(5f,5f,5f));
        UnitAssets unitAssets = new UnitAssets();
        unitAssets.setHead("Basic/Head");
        unitAssets.setHelmet("SpellMasters/InquisitorHat1 [Paint]");
        unitAssets.setWeaponType("Melee1H");
        unitAssets.setArmor("AbandonedWorkshop/WhiteGuardian");
        unit.setState(UnitState.IDLE);


        unit.setUnitAssets(unitAssets);
        unit = unitRepository.save(unit);

        CharacterClass characterClass = characterClassRepository.findByIdentifier("barbar");

        unit.setCharacterClass(characterClass);

        unitRepository.save(unit);


    }

    private void createShinChanDerZeitmagaier(){
        Unit unit = new Unit();
        unit.setName("Shin Chan der Zeitmagier");
        unit.setPosition(new EmeddableVector3(5f,5f,5f));
        UnitAssets unitAssets = new UnitAssets();
        unitAssets.setHead("Basic/Head");
        unitAssets.setHelmet("Basic/HawkHelm");
        unitAssets.setWeaponType("Melee1H");
        unitAssets.setArmor("AbandonedWorkshop/OzeriasRobe");
        unit.setUnitAssets(unitAssets);
        unit.setState(UnitState.IDLE);
        unit = unitRepository.save(unit);

        CharacterClass characterClass = characterClassRepository.findByIdentifier("time_hunter");

        unit.setCharacterClass(characterClass);

        unitRepository.save(unit);

    }


}
