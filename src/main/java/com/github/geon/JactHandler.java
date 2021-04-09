package com.github.geon;

public interface JactHandler<StateType> {
    //return new State
    StateType handle(StateType stateType);
}
