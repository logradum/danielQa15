package com.telran.qa15;

public class Team {
  private String teamName;
  private String teamDescription;


  public String getTeamName() {
    return teamName;
  }

  public String getTeamDescription() {
    return teamDescription;
  }

  public Team setTeamName(String teamName) {
    this.teamName = teamName;
    return this;
  }
  public Team setTeamDescription(String teamDescription) {
    this.teamDescription = teamDescription;
    return this;
  }
}
