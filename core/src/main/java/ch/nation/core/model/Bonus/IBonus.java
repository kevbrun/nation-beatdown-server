package ch.nation.core.model.Bonus;


import ch.nation.core.model.Enums.StatModTarget;


public interface IBonus<T> {


    public T getBonus();

    public void setBonus(T bonus);

    public StatModTarget getStatTarget();


    public void setStatTarget(StatModTarget statTarget);


}
