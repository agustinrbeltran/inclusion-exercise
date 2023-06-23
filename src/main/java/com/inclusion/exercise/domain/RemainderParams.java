package com.inclusion.exercise.domain;

import java.util.Objects;

public class RemainderParams {

  private final Integer id;
  private final Integer x;
  private final Integer y;
  private final Integer n;

  private Integer maxRemainder;

  public RemainderParams(Integer x, Integer y, Integer n) throws RemainderInvalidArgument {

    if (x < 2 || x > Math.pow(10, 9)) {
      throw new RemainderInvalidArgument("Invalid x value: " + x);
    }

    if (x <= y || y < 0) {
      throw new RemainderInvalidArgument("Invalid y value: " + y);
    }

    if (n < y || n > Math.pow(10, 9)) {
      throw new RemainderInvalidArgument("Invalid n value: " + n);
    }

    this.x = x;
    this.y = y;
    this.n = n;
    this.id = Objects.hash(x, y, n);

  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }

  public Integer getN() {
    return n;
  }

  public Integer getId() {
    return id;
  }

  public Integer getMaxRemainder() {
    return maxRemainder;
  }

  public void setMaxRemainder(Integer maxRemainder) {
    this.maxRemainder = maxRemainder;
  }

  @Override
  public int hashCode() {
    return id;
  }

}
