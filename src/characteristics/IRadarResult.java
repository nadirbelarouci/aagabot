/* ******************************************************
 * Simovies - Eurobot 2015 Robomovies Simulator.
 * Copyright (C) 2014 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: characteristics/IRadarResult.java 2014-10-28 buixuan.
 * ******************************************************/
package characteristics;

import robotsimulator.RadarResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface IRadarResult {
    Pattern pattern = Pattern.compile("(.*);(.*);(.*);(.*)");

    static RadarResult parse(String message) {
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            return new RadarResult(
                    IRadarResult.Types.valueOf(matcher.group(1)),
                    Double.parseDouble(matcher.group(2)),
                    Double.parseDouble(matcher.group(3)),
                    Double.parseDouble(matcher.group(4)));

        }
        throw new RuntimeException("PATTERN ERROR in: " + message);
    }

    static String parse(IRadarResult result) {

        return result.getObjectType() + ";"
                + result.getObjectDirection() + ";"
                + result.getObjectDistance() + ";"
                + result.getObjectRadius();
    }

    //--------------------------------------------------------//
    //---SIMULATOR-PROVIDED-METHODS---------------------------//
    //------implemented-in-robotsimulator.FrontSensorResult---//
    //--------------------------------------------------------//
    Types getObjectType(); //return the type of observed object. Object can only be detected is getObjectDistance() is at most the bot's range value

    double getObjectDirection(); //return the direction of observed object, from center to center

    double getObjectDistance(); //return the distance of observed object, from center to center

    double getObjectRadius(); //return the radius of observed object

    enum Types {OpponentMainBot, OpponentSecondaryBot, TeamMainBot, TeamSecondaryBot, Wreck, BULLET}
}
