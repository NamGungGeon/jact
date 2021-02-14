package com.github.geon;
public class State implements Cloneable{
  public State clone() throws CloneNotSupportedException{
    return (State) super.clone();
  }
}
