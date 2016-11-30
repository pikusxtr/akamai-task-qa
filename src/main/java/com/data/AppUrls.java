package com.data;

/** Created by T5500 on 2015-09-01. */
public enum AppUrls {
  PROD("http://akamaijobs.referrals.selectminds.com/");

  private String url;

  AppUrls(String url) {
    this.url = url;
  }

  public String getUrl() {
    return this.url;
  }
}
