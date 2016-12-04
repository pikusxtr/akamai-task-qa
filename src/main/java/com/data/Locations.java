package com.data;

public enum Locations {
  PL_KRK("Krakow, Poland");

  private String fullLocationName;

  Locations(String fullLocationName) {
    this.fullLocationName = fullLocationName;
  }

  public String getFullLocationName() {
    return this.fullLocationName;
  }
}
