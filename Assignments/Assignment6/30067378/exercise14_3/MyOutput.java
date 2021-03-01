import java.util.ArrayList;
import java.util.regex.*;

interface FormattedOutput{
    String getFormatted();
}

enum Actions{
    END,
    ENABLE,
    START,
    TEST,
    DISABLE
}

enum Months{
    JAN{
        public String toLog(){
            return "Jan";
        }
        public int toInt(){
            return 1;
        }
        public String toString(){
            return "January";
        }
    },
    FEB{
        public String toLog(){
            return "Feb";
        }
        public int toInt(){
            return 2;
        }
        public String toString(){
            return "February";
        }
    },
    MAR{
        public String toLog(){
            return "Mar";
        }
        public int toInt(){
            return 3;
        }
        public String toString(){
            return "March";
        }
    },
    APR{
        public String toLog(){
            return "APR";
        }
        public int toInt(){
            return 4;
        }
        public String toString(){
            return "April";
        }
    },
    MAY{
        public String toLog(){
            return "May";
        }
        public int toInt(){
            return 5;
        }
        public String toString(){
            return "May";
        }
    },
    JUN{
        public String toLog(){
            return "Jun";
        }
        public int toInt(){
            return 6;
        }
        public String toString(){
            return "June";
        }
    },
    JUL{
        public String toLog(){
            return "Jul";
        }
        public int toInt(){
            return 7;
        }
        public String toString(){
            return "July";
        }
    },
    AUG{
        public String toLog(){
            return "Aug";
        }
        public int toInt(){
            return 8;
        }
        public String toString(){
            return "August";
        }
    },
    SEP{
        public String toLog(){
            return "Sep";
        }
        public int toInt(){
            return 9;
        }
        public String toString(){
            return "September";
        }
    },
    OCT{
        public String toLog(){
            return "Oct";
        }
        public int toInt(){
            return 10;
        }
        public String toString(){
            return "October";
        }
    },
    NOV{
        public String toLog(){
            return "Nov";
        }
        public int toInt(){
            return 11;
        }
        public String toString(){
            return "November";
        }
    },
    DEC{
        public String toLog(){
            return "Dec";
        }
        public int toInt(){
            return 12;
        }
        public String toString(){
            return "December";
        }
    };

    public abstract String toString();
    public abstract int toInt();
    public abstract String toLog();
}

class IPv4 implements FormattedOutput{
    final private String IP;
    final static private String REGEX = "[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}";
    final static private Pattern PATTERN = Pattern.compile(REGEX);

    public IPv4(String ip){
        if(PATTERN.matcher(ip).matches()){
            this.IP = ip;
        }
        else{
            System.err.println("Error! Invalid IPv4 Format!");
            IP = "ERROR";
        }
    }
    public String getIP() {
        return IP;
    }
    public static String getRegex() {
        return REGEX;
    }
    @Override
    public String getFormatted() {
        return "IPv4: " + IP;
    }
}

class Device implements FormattedOutput{
    final private String DEVICE;
    final static private String REGEX = "[a-z\s]+ \\(";
    final static private Pattern PATTERN = Pattern.compile(REGEX);

    public Device(String device){
        if(PATTERN.matcher(device).matches()){
            this.DEVICE = device.substring(1, device.length()-2);
        }
        else{
            System.err.println("Error! Invalid Device Format!");
            DEVICE = "ERROR";
        }
    }
    public String getDevice() {
        return DEVICE;
    }
    public static String getRegex() {
        return REGEX;
    }
    @Override
    public String getFormatted() {
        return "Device: " + DEVICE;
    }
}

class Action implements FormattedOutput{
    final private String ACTION;
    final static private String REGEX = "\"[A-Z]+";
    final static private Pattern PATTERN = Pattern.compile(REGEX);

    public Action(String action){
        if(PATTERN.matcher(action).matches()){
            boolean validAction = false;
            try {
                Actions.valueOf(action.substring(1));    //throws exception if action isnt found
                validAction = true;
            } 
            catch (IllegalArgumentException e) {
                System.err.println("Error! Invalid Action!");
            }
            finally{
                if(validAction){
                    ACTION = action.substring(1);
                }
                else{
                    ACTION = "Invalid Action";
                }
            }
        }
        else{
            System.err.println("Error! Invalid Action Format!");
            ACTION = "ERROR";
        }
    }
    public String getAction() {
        return ACTION;
    }
    public static String getRegex() {
        return REGEX;
    }
    @Override
    public String getFormatted() {
        return "Action: " + ACTION;
    }
}

class DateTime implements FormattedOutput{
    final private int DAY;
    final private int MONTH;
    final private int YEAR;
    final private int HOUR;
    final private int MINUTE;
    final private int SECOND;
    final static private String REGEX = "\\[([0-9]{1,2})/([a-zA-Z]{3})/([0-9]{4}):([0-9]{1,2}):([0-9]{2}):([0-9]{2})\\]";
    final static private Pattern PATTERN = Pattern.compile(REGEX);

    public DateTime(String DateTime){
        Matcher matcher;
        if((matcher = PATTERN.matcher(DateTime)).matches()){
            DAY = Integer.parseInt(matcher.group(1));
            MONTH = monthLogToInt(matcher.group(2));
            YEAR = Integer.parseInt(matcher.group(3));
            HOUR = Integer.parseInt(matcher.group(4));
            MINUTE = Integer.parseInt(matcher.group(5));
            SECOND = Integer.parseInt(matcher.group(6));
        }
        else{
            System.err.println("Error! Invalid DateTime Format!");
            DAY = 0;
            MONTH = 0;
            YEAR = 0;
            HOUR = 0;
            MINUTE = 0;
            SECOND = 0;
        }
    }
    public int getDay() {
        return DAY;
    }
    public int getHour() {
        return HOUR;
    }
    public int getMinute() {
        return MINUTE;
    }
    public int getMonth() {
        return MONTH;
    }
    public static String getRegex() {
        return REGEX;
    }
    public int getSecond() {
        return SECOND;
    }
    public int getYear() {
        return YEAR;
    }
    @Override
    public String getFormatted() {
        return 
        "Day: " + String.valueOf(DAY) +
        ", Month: " + monthToString() + 
        ", Year: " + String.valueOf(YEAR) + 
        ", Hour: " + String.valueOf(HOUR) + 
        ", Minute: " + String.valueOf(MINUTE) + 
        ", Second: " + String.valueOf(SECOND);
    }
    public String monthToString(){
        for (Months month : Months.values()) {
            if(this.MONTH == month.toInt()){
                return month.toString();
            }
        }
        return "Error! Month not found!";
    }
    private int monthLogToInt(String monthLog) {
        for (Months month : Months.values()) {
            if(monthLog.equals(month.toLog())){
                return month.toInt();
            }
        }
        return -1;
    }
}

class Location implements FormattedOutput{
    final private String ROOM;
    final private String BUILDING;
    final static private String REGEX = "[a-zA-Z\s]+ - [a-zA-Z\s]+";
    final static private Pattern PATTERN = Pattern.compile(REGEX);

    public Location(String location){
        if(PATTERN.matcher(location).matches()){
            String[] splitLocation = location.split(" - ");
            ROOM = splitLocation[0];
            BUILDING = splitLocation[1];
        }
        else{
            System.err.println("Error! Invalid Location Format!");
            ROOM = "ERROR";
            BUILDING = "ERROR";
        }
    }
    public String getRoom(){
        return this.ROOM;
    }
    public String getBuilding(){
        return this.BUILDING;
    }
    public static String getRegex() {
        return REGEX;
    }
    @Override
    public String getFormatted() {
        return "Room: " + ROOM + ", Building: " + BUILDING;
    }
}

class ParseLine{
    final private String LOGLINE;
    final private Location LOCATION;
    final private Device DEVICE;
    final private Action ACTION;
    final private DateTime DATETIME;
    final private IPv4 IPV4;
    
    public ParseLine(String line){
        LOGLINE = line;

        Matcher matcher = Pattern.compile(IPv4.getRegex()).matcher(line);
        if(matcher.find()){
            IPV4 = new IPv4(matcher.group());
        }
        else{
            throw new IllegalArgumentException();
        }

        matcher = Pattern.compile(Location.getRegex()).matcher(line);
        if(matcher.find()){
            LOCATION = new Location(matcher.group());
        }
        else{
            throw new IllegalArgumentException();
        }

        matcher = Pattern.compile(Action.getRegex()).matcher(line);
        if(matcher.find()){
            ACTION = new Action(matcher.group());
        }
        else{
            throw new IllegalArgumentException();
        }

        matcher = Pattern.compile(DateTime.getRegex()).matcher(line);
        if(matcher.find()){
            DATETIME = new DateTime(matcher.group());
        }
        else{
            throw new IllegalArgumentException();
        }

        matcher = Pattern.compile(Device.getRegex()).matcher(line);
        if(matcher.find()){
            DEVICE = new Device(matcher.group());
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    public IPv4 getIPv4() {
        return IPV4;
    }
    public String getLogLine() {
        return LOGLINE;
    }
    public Location getLocation(){
        return LOCATION;
    }
    public Device getDevice() {
        return DEVICE;
    }
    public Action getAction() {
        return ACTION;
    }
    public DateTime getDateTime() {
        return DATETIME;
    }
}

class ParseLogfile{
    private ArrayList<ParseLine> log;

    public ParseLogfile(String[] array){
        log = new ArrayList<ParseLine>();

        for (int i = 0; i < array.length; i++) {
            log.add(new ParseLine(array[i]));
        }
    }
    public ParseLine getLine(int index){
        return log.get(index);
    }
    public ArrayList<ParseLine> getLog() {
        return log;
    }
}

public class MyOutput{
    public static void main(String args[]) {

		String[] exampleLog = exampleLog();

		var logfile = new ParseLogfile(exampleLog);
        for (int i = 0; i < exampleLog.length; i++) {
            var line = logfile.getLine(i);
            System.out.println("Log line "+ String.valueOf(i) + ": " + line.getLogLine());

            var ip = line.getIPv4();
            System.out.println("IPv4: "+ip.getIP());
            
            var dt = line.getDateTime();
            System.out.println("Day: "+dt.getDay());
            System.out.println("Month: "+dt.getMonth());
            System.out.println("Month (named): "+dt.monthToString());
            System.out.println("Year: "+dt.getYear());
            System.out.println("Hour: "+dt.getHour());
            System.out.println("Minute: "+dt.getMinute());
            System.out.println("Second: "+dt.getSecond());

            var act = line.getAction();
            System.out.println("Action: "+act.getAction());

            var dev = line.getDevice();
            System.out.println("Device: "+dev.getDevice());

            var loc = line.getLocation();
            System.out.println("Room: "+loc.getRoom());
            System.out.println("Building: "+loc.getBuilding());
            System.out.println();
        }

		// String[] exampleLog = exampleLog();
		// var logfile = new ParseLogfile(exampleLog);
		// var line = logfile.getLine(0);
		// System.out.println("Log line 0: " + line.getLogLine());

		// var ip = line.getIPv4();
		// System.out.println("IPv4: "+ip.getIP());
		
		// var dt = line.getDateTime();
		// System.out.println("Day: "+dt.getDay());
		// System.out.println("Month: "+dt.getMonth());
		// System.out.println("Month (named): "+dt.monthToString());
		// System.out.println("Year: "+dt.getYear());
		// System.out.println("Hour: "+dt.getHour());
		// System.out.println("Minute: "+dt.getMinute());
		// System.out.println("Second: "+dt.getSecond());

		// var act = line.getAction();
		// System.out.println("Action: "+act.getAction());

		// var dev = line.getDevice();
		// System.out.println("Device: "+dev.getDevice());

		// var loc = line.getLocation();
		// System.out.println("Room: "+loc.getRoom());
		// System.out.println("Building: "+loc.getBuilding());

		// System.out.println();
		// line = logfile.getLine(6);
		// System.out.println("Log line 6: " + line.getLogLine());
		// System.out.println(line.getIPv4().getFormatted());
		// System.out.println(line.getDateTime().getFormatted());
		// System.out.println(line.getAction().getFormatted());
		// System.out.println(line.getDevice().getFormatted());
		// System.out.println(line.getLocation().getFormatted());

		// System.out.println("\nExample of toLog() output: " + Months.AUG.toLog());
		// System.out.println("\nExample regex (for DateTime): "+DateTime.getRegex());
    }

    public static String[] exampleLog() {
		String[] log = {
            "81.220.24.207 - - [2/Mar/2020:10:05:44] \"END sprinkler (Visitor entrance - Building A)\"",
            "81.220.24.207 - - [2/Mar/2020:10:05:26] \"ENABLE cooling system (Secured room - Building A)\"",
            "81.220.24.207 - - [2/Mar/2020:10:05:39] \"START heating system (Hall - Central)\"",
            "81.220.24.207 - - [2/Mar/2020:10:05:52] \"ENABLE door lock (Visitor entrance - Building B)\"",
            "81.220.24.207 - - [2/Mar/2020:10:05:21] \"TEST cooling system (Entrance - Building B)\"",
            "66.249.73.135 - - [17/May/2020:01:05:17] \"TEST fan (Secured room - Airport location)\"",
            "46.105.14.53 - - [17/May/2020:11:05:42] \"TEST cooling system (Secured room - Airport location)\"",
            "218.30.103.62 - - [17/May/2020:11:05:11] \"START sprinkler (Secured room - Airport location)\"",
            "218.30.103.62 - - [17/May/2020:11:05:46] \"DISABLE fan (Control room - Central)\"",
            "218.30.103.62 - - [17/May/2020:11:05:45] \"START door lock (Secured room - Building A)\"",
            "66.249.73.135 - - [27/Jun/2020:11:05:31] \"TEST sprinkler (Hall - Building B)\""};
		return log;
	}
}