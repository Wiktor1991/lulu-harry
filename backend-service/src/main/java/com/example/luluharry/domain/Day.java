package com.example.luluharry.domain;






public enum Day {

  MON("Montag"),
    TUE("Dienstag"),
    WEN("Mittwoch"),
    THU("Donnerstag"),
    FRI("Freitag"),
    SAT("Samstag");

    Day(String dayName) {
        dayName = this.name();
    }
    public String getDay(){
      return name();
    }
}
