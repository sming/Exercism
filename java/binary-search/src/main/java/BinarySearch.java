package com.peterkingswell.exercism.java;

import java.util.List;

public class BinarySearch {
  private final List<Integer> input;

  public BinarySearch(List<Integer> input) {
    this.input = input;
  }

  public int indexOf(int query) throws com.peterkingswell.exercism.java.ValueNotFoundException {
    if (input == null || input.size() == 0)
      throw new com.peterkingswell.exercism.java.ValueNotFoundException("Value not in array");

    return findIndexOf(query, 0, input.size() - 1);
  }

  private int findIndexOf(int query, int startIdx, int endIdx)
      throws com.peterkingswell.exercism.java.ValueNotFoundException {
    int midwayIdx = startIdx + Math.abs((endIdx - startIdx) / 2);
    int midway = input.get(midwayIdx);

    //System.err.println(
    //    "findIndexOf(" + query + ", " + startIdx + ", " + midwayIdx + ", " + endIdx + ")");

    if (midway == query) return midwayIdx;
    else if (input.get(startIdx) == query) return startIdx;
    else if (input.get(endIdx) == query) return endIdx;

    if (midwayIdx > startIdx && midway > query) {
      return findIndexOf(query, startIdx, midwayIdx -1);
    } else if (midwayIdx > startIdx && midway < query) {
      return findIndexOf(query, midwayIdx, endIdx);
    }

    throw new com.peterkingswell.exercism.java.ValueNotFoundException("Value not in array");
  }
}
