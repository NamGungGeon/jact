package com.github.geon;


import org.jetbrains.annotations.Nullable;

public interface Subscriber<StateType extends Cloneable> {
  void updated(@Nullable StateType newState);
}
