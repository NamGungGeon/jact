package com.github.geon;


public interface Subscriber<StateType> {
  void updated(StateType newState);
}
