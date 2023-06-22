package com.inclusion.exercise.domain;

public interface RemainderRepository {

  Integer getMax(int id);
  void saveMax(int id, int max);

}
