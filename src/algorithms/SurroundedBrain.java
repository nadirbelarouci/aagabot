/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: algorithms/Stage1.java 2014-10-18 buixuan.
 * ******************************************************/
package algorithms;

import algorithms.strategy.*;
import characteristics.IRadarResult;
import characteristics.Parameters;
import robotsimulator.Brain;

public class SurroundedBrain extends Brain {
    //---PARAMETERS---//
    private static int id = 0;
    private Robot one;
    private Robot two;
    private Robot three;
    private Task task1 = new MoveToTask(new MoveGoal(2500, 200));

    private TaskExecutor executor = new TaskExecutor();

    public SurroundedBrain() {
        executor.addAll(task1);
    }

    public void activate() {
        id++;
        switch (id) {
            case 1:
                one = new Robot(this, Parameters.teamAMainBot1InitX, Parameters.teamAMainBot1InitY, Parameters.teamAMainBotSpeed);
                break;
        }
    }

    public void step() {
        if (one != null) {
            executor.execute(one);
        }
    }

}