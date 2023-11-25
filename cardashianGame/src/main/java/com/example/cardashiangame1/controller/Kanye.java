package com.example.cardashiangame1.controller;

import com.example.cardashiangame1.views.game.GameView;

public class Kanye {
    float minX = 15, minY = 120;

    public int posY = 0, posX = 0;

    public float getLocationX() {
        return (GameView.X_LENGTH/14)*this.posX+minX;
    }

    public float getLocationY() {
        return (GameView.Y_LENGTH/7)*this.posY+minY;
    }

//    public void setPosX(int pos) {this.posX = pos;}
//    public void setPosY(int pos) {this.posY = pos;}
}
