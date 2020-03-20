/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: algorithms/Stage1.java 2014-10-18 buixuan.
 * ******************************************************/
package algorithms;

import algorithms.strategy.Robot;
import algorithms.strategy.task.FireTask;
import algorithms.strategy.task.MoveToTask;
import algorithms.strategy.task.RadarReceptionTask;
import characteristics.Parameters;
import robotsimulator.Brain;

public class MainBotBrain extends Brain {
    //---PARAMETERS---//
    private static int id = 0;
    FireTask fireTask = new FireTask();
    private Robot one;
    private Robot two;
    private Robot three;
    private RadarReceptionTask radarReceptionTask = new RadarReceptionTask();

    public MainBotBrain() {
    }

    public void activate() {
        id++;
        switch (id) {
            case 1:
                one = new Robot(this, Parameters.teamAMainBot1InitX, Parameters.teamAMainBot1InitY, Parameters.teamAMainBotSpeed);
                break;
            case 2:
                two = new Robot(this, Parameters.teamAMainBot2InitX, Parameters.teamAMainBot2InitY, Parameters.teamAMainBotSpeed);
                break;
            case 3:
                three = new Robot(this, Parameters.teamAMainBot3InitX, Parameters.teamAMainBot3InitY, Parameters.teamAMainBotSpeed);
                break;
        }
    }

    public void step() {

        if (one != null) {
            radarReceptionTask.execute(one);
            System.out.println(radarReceptionTask.getMessages());
            radarReceptionTask.getMessages()
                    .stream()
                    .findAny().ifPresent(result -> {
                one.setFireDirection(result.fireTheta);
                fireTask.setTask(new MoveToTask(result));
                fireTask.execute(one);
            });
        } else if (two != null) {
            radarReceptionTask.execute(two);
            radarReceptionTask.getMessages()
                    .stream()
                    .findAny().ifPresent(result -> {
                two.setFireDirection(result.fireTheta);

                fireTask.setTask(new MoveToTask(result));
                fireTask.execute(two);
            });
        } else if (three != null) {
            radarReceptionTask.execute(three);
            radarReceptionTask.getMessages()
                    .stream()
                    .findAny().ifPresent(result -> {
                three.setFireDirection(result.fireTheta);

                fireTask.setTask(new MoveToTask(result));
                fireTask.execute(three);
            });

        }
    }

}