package com.inclusion.exercise.domain;

import javax.naming.directory.InvalidAttributesException;
import java.util.Objects;

public class RemainderParams {

  private final int id;
  private final int x;
  private final int y;
  private final int n;

  public RemainderParams(int x, int y, int n) throws InvalidAttributesException {

    if (x < 2 || x > Math.pow(10, 9)) {
      throw new InvalidAttributesException("Invalid x value: " + x);
    }

    if (x <= y || y < 0) {
      throw new InvalidAttributesException("Invalid y value: " + y);
    }

    if (n < y || n > Math.pow(10, 9)) {
      throw new InvalidAttributesException("Invalid n value: " + n);
    }

    this.x = x;
    this.y = y;
    this.n = n;
    this.id = Objects.hash(x, y, n);

  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getN() {
    return n;
  }

  public int getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return id;
  }

}
