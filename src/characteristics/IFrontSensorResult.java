/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: characteristics/IFrontSensorResult.java 2014-10-26 buixuan.
 * ******************************************************/
package characteristics;

public interface IFrontSensorResult {
    //--------------------------------------------------------//
    //---SIMULATOR-PROVIDED-METHODS---------------------------//
    //------implemented-in-robotsimulator.FrontSensorResult---//
    //--------------------------------------------------------//
    Types getObjectType(); //return the type of observed object

    enum Types {NOTHING, OpponentMainBot, OpponentSecondaryBot, TeamMainBot, TeamSecondaryBot, Wreck, WALL, BULLET}
}
