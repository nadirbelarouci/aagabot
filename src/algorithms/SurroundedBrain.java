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

public class SurroundedBrain extends Brain {
    //---PARAMETERS---//
    private static int id = 0;
    private Robot one;
    private Robot two;

    private Task explorer = new ExploreTask();

    private Task c1 = new CircleTask(new CircleGoal(200, 1000, 1000));
    private Task c2 = new CircleTask(new CircleGoal(100, 1400, 1500));
    private Task c3 = new CircleTask(new CircleGoal(100, 200, 300));
    private TaskExecutor tasks = new TaskExecutor();
    private Task radarDetection = new RadarDetectionTask();
    private RadarReceptionTask radarReception = new RadarReceptionTask();

    public SurroundedBrain() {
        tasks.addAll(c1, c2, c3);

    }

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
            tasks.execute(one);
        } else if (two != null) {
            explorer.execute(two);
        }
    }

}