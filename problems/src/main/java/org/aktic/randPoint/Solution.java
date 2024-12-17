package org.aktic.randPoint;

import java.util.Random;

public class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        Random rand = new Random();
        while (true) {
            double x = rand.nextDouble(this.x_center - this.radius, this.x_center + this.radius);
            double y = rand.nextDouble(this.y_center - this.radius, this.y_center + this.radius);

            double distance = Math.sqrt(Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2));

            if (distance <= radius) {
                return new double[] {x, y};
            }
        }
    }
}
