class Solution {
    public double angleClock(int hour, int minutes) {
        int degreeMins = 6; //360 degree / 60mins a rotation
        int degreeHrs = 30; //360 degree / 12hrs a rotation

        double angMins = minutes * degreeMins;
        double angHrs = (hour + minutes / 60.0 ) * degreeHrs;

        double res = Math.abs(angHrs - angMins);

        return Math.min(res, 360 - res);    //return the smaller angle made
    }
}