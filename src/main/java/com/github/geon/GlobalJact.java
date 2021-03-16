package com.github.geon;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GlobalJact<StateType extends Cloneable> extends Jact<StateType> {
  private GlobalJact(@Nullable StateType state) {
    super(state);
  }
  
  private static GlobalJact inst = null;
  
  @NotNull
  public static <StateType extends Cloneable> GlobalJact<StateType> getInstance(@Nullable StateType expectState) {
    if (inst == null) {
      inst = new GlobalJact<StateType>(null);
    }
    if (expectState != null)
      inst.setState(expectState);
    return inst;
  }
}
