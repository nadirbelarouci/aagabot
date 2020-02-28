/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: characteristics/IBrain.java 2014-10-19 buixuan.
 * ******************************************************/
package characteristics;

import java.util.ArrayList;

public interface IBrain {
    //----------------------------------------------//
    //---TEAM-PROVIDED-METHODS----------------------//
    //------implemented-in-class-given-by-name------//
    //------Parameters.teamAMainBotBrainClassName---//
    //------Parameters.teamBMainBotBrainClassName---//
    //----------------------------------------------//
    void activate(); //instructions to perform at activation

    void step(); //instructions to perform at step action

    //--------------------------------------------//
    //---SIMULATOR-PROVIDED-METHODS---------------//
    //------implemented-in-robotsimulator.Brain---//
    //--------------------------------------------//
    void sendLogMessage(String message); //send message to log panel

    void move(); //move straight one step, distance is Parameters.teamXMainBotSpeed

    void moveBack(); //move backward one step, distance is Parameters.teamXMainBotSpeed

    void stepTurn(Parameters.Direction dir); //turn one step, direction is Parameters.Direction.LEFT or Parameters.Direction.RIGHT, angle is Parameters.teamXMainBotStepTurnAngle

    void broadcast(String message); //broadcast message to all team mates

    ArrayList<String> fetchAllMessages(); //fetch all received message

    double getHeading(); //returns current heading angle, unit is clockwise trigonometric according to screen pixel coordinate reference

    IFrontSensorResult detectFront(); //returns object IFrontSensorResult when something is detected from frontal object sensor

    ArrayList<IRadarResult> detectRadar(); //FICTIONAL SIMOVIES: returns object IRadarResult when something is detected from the top radar. Top radar can only detect objects within range: distance from bot's center to object's center must be at most the bot's range value.

    void fire(double direction); //FICTIONAL SIMOVIES: fire a rocket towards direction

    double getHealth(); //FICTIONAL SIMOVIES: returns current hitpoints
}
