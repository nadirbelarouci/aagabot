/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: algorithms/Stage1.java 2014-10-18 buixuan.
 * ******************************************************/
package algorithms;

import algorithms.strategy.task.RepeatableTask;
import algorithms.strategy.Robot;
import algorithms.strategy.task.CircleGoal;
import algorithms.strategy.task.CircleTask;
import algorithms.strategy.task.ExploreTask;
import algorithms.strategy.task.Task;
import characteristics.Parameters;
import robotsimulator.Brain;

public class SurroundedBrain extends Brain {
    //---PARAMETERS---//
    private static int id = 0;
    private Robot one;
    private Robot two;

    private Task explorer = new ExploreTask();
    private Task circle = new RepeatableTask(new CircleTask(new CircleGoal(200, 1000, 1000)));

    public SurroundedBrain() {

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
            circle.execute(one);
        } else if (two != null) {
            explorer.execute(two);
        }
    }

}