/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: algorithms/Stage1.java 2014-10-18 buixuan.
 * ******************************************************/
package algorithms;

import algorithms.strategy.Robot;
import algorithms.strategy.task.*;
import characteristics.Parameters;
import robotsimulator.Brain;

public class SecondaryBotBrain extends Brain {
    //---PARAMETERS---//
    private static int id = 0;
    private Robot one;
    private Robot two;

    private Task explorer = new ExploreTask();
    private Task radarDetection = new RadarDetectionTask();
    private Task move = new MoveToTask(new MoveGoal(2000,300));

    public void activate() {
        id++;
        switch (id) {
            case 1:
                one = new Robot(this, Parameters.teamASecondaryBot1InitX, Parameters.teamASecondaryBot1InitY, Parameters.teamASecondaryBotSpeed);
                break;
            case 2:
                two = new Robot(this, Parameters.teamASecondaryBot2InitX, Parameters.teamASecondaryBot2InitY, Parameters.teamASecondaryBotSpeed);
                break;
        }
    }

    public void step() {
        if (one != null) {
            radarDetection.execute(one);
            move.execute(one);
        } else if (two != null) {
            radarDetection.execute(two);
            explorer.execute(two);
        }
    }

}