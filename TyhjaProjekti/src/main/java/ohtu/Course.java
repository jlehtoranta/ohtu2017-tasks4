package ohtu;

public class Course {
    private String name;
    private String term;
    private String week1,week2,week3,week4,week5,week6;

    public String getName() {
        return this.name;
    }

    public String getTerm() {
        return this.term;
    }

    public String getWeekMax(String week) {
        String max = "";
        switch(week) {
            case "1": max = this.week1; break;
            case "2": max = this.week2; break;
            case "3": max = this.week3; break;
            case "4": max = this.week4; break;
            case "5": max = this.week5; break;
            case "6": max = this.week6; break;
            default: max = "";
        }
        return max;
    }
}
