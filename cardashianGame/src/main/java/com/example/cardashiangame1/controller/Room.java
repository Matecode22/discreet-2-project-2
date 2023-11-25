package com.example.cardashiangame1.controller;

public class Room {
    private boolean accessible;

    public Room(boolean isAccessible) {this.accessible = isAccessible;}

    public boolean isAccessible() {return this.accessible;}
    public void setAccessible(boolean accessible) {this.accessible = accessible;}
}
