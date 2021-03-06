package com.github.geon;



import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Jact<StateType> implements Serializable {
  public static <StateType> Jact<StateType> useJact(StateType stateType){
    return new Jact<>(stateType);
  }
  public Jact(StateType state) {
    this.state = state;
  }
  public Jact(StateType state, @NotNull List<Subscriber<StateType>> subscribers) {
    this(state);
    this.subscribers= subscribers;
  }
  
  private StateType state;
  private List<Subscriber<StateType>> subscribers= new ArrayList<>();
  
  public StateType getState(){
    return state;
  }
  public void setState(StateType newState){
    this.state= newState;
    notifyToSubscribers();
  }

  public void handleState(@NotNull JactHandler<StateType> jHandler){
    StateType newState= jHandler.handle(getState());
    setState(newState);
  }

  private void notifyToSubscribers(){
    for(Subscriber<StateType> subscriber: subscribers){
      subscriber.updated(state);
    }
  }
  
  public void subscribe(@NotNull Subscriber<StateType> subscriber){
    subscribers.add(subscriber);
  }
  public void unsubscribe(@NotNull Subscriber<StateType> subscriber){
    Iterator<Subscriber<StateType>> iterator= subscribers.iterator();
    while(iterator.hasNext()){
      if(iterator.next().equals(subscriber)){
        iterator.remove();
        return;
      }
    }
  }
}
