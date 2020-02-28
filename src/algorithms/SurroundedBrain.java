/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: algorithms/Stage1.java 2014-10-18 buixuan.
 * ******************************************************/
package algorithms;

import robotsimulator.Brain;

public class SurroundedBrain extends Brain {
    //---PARAMETERS---//
    private static final double HEADINGPRECISION = 0.001;
    private static final double ANGLEPRECISION = 0.1;
    private static final int DIPSY = 0;
    private static final int TINKY = 1;
    private static final int PO = 2;
    private static final int UNDEFINED = 0xBADCCCE0;
    private static final int TURNSOUTHTASK = 1;
    private static final int MOVESOUTHTASK = 2;
    private static final int TURNEASTTASK = 3;
    private static final int MOVEEASTTASK = 4;
    private static final int UTURNTASK = 5;
    private static final int UTURNAGAINTASK = 6;
    private static final int SINK = 0xBADC0DE1;
    private static int BOT = 0;
    //---VARIABLES---//
    private int state;
    private double myX, myY;
    private boolean isMoving;
    private Robot whoAmI;
    private double width;
    private int ballet;

    public SurroundedBrain() {
        super();
    }

    public void activate() {
        whoAmI = new Robot(this, BOT++);
        whoAmI.moveTo(500,500 );
    }

    public void step() {
        whoAmI.step();
    }

    private void myMove() {
        isMoving = true;
        move();
    }

    private double myGetHeading() {
        double result = getHeading();
        while (result < 0) result += 2 * Math.PI;
        while (result > 2 * Math.PI) result -= 2 * Math.PI;
        return result;
    }

    private boolean isSameDirection(double dir1, double dir2) {
        return Math.abs(dir1 - dir2) < ANGLEPRECISION;
    }
}