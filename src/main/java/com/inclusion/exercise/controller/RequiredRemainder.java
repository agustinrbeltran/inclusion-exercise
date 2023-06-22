package com.inclusion.exercise.controller;

import javax.naming.directory.InvalidAttributesException;

public class RequiredRemainder {

  private final int x;
  private final int y;
  private final int n;

  public RequiredRemainder(int x, int y, int n) throws InvalidAttributesException {

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

  }

  public Integer getMaxRemainder() {

    for (int k = n; k >= 0; k--) {
      if (k % x == y) {
        return k;
      }
    }
    return 0;

  }

}
