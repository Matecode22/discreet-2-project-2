package com.example.cardashiangame1.controller;

public class Graph {
    public Node[][] nodeGrid = new Node[15][8];

    public Graph() {
        for (int i = 0; i < this.nodeGrid.length; i++) {
            for (int j = 0; j < this.nodeGrid[i].length; j++) {
                this.nodeGrid[i][j] = new Node();
                this.nodeGrid[i][j].value = new Room(true);
            }
        }
    }
}
