package com.data;

/** Created by T5500 on 2015-09-01. */
public enum Locations {
  PL_KRK("Krakow, Poland"),
  US_CMB("Cambridge, United States");

  private String fullLocationName;

  Locations(String fullLocationName) {
    this.fullLocationName = fullLocationName;
  }

  public String getFullLocationName() {
    return this.fullLocationName;
  }
}
