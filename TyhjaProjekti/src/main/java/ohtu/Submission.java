package ohtu;

public class Submission {
    private String student_number;
    private String week;
    private double hours;
    private boolean a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21;
    private String weekMax = "";

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public double getHours() {
        return this.hours;
    }

    private boolean[] getTasksList() {
        boolean[] l = new boolean[21];
        l[0] = this.a1;
        l[1] = this.a2;
        l[2] = this.a3;
        l[3] = this.a4;
        l[4] = this.a5;
        l[5] = this.a6;
        l[6] = this.a7;
        l[7] = this.a8;
        l[8] = this.a9;
        l[9] = this.a10;
        l[10] = this.a11;
        l[11] = this.a12;
        l[12] = this.a13;
        l[13] = this.a14;
        l[14] = this.a15;
        l[15] = this.a16;
        l[16] = this.a17;
        l[17] = this.a18;
        l[18] = this.a19;
        l[19] = this.a20;
        l[20] = this.a21;

        return l;
    }

    public int getTasksDone() {
        int tasks = 0;
        boolean[] l = this.getTasksList();

        for (boolean a : l) {
            if (a == true) {
                tasks += 1;
            }
        }

        return tasks;
    }

    public String getTasksDoneString() {
        String tasks = "";
        boolean[] l = this.getTasksList();

        for (int i = 1; i-1 < l.length; i++) {
            if (l[i-1] == true) {
                tasks += i + " ";
            }
        }

        return tasks;
    }

    @Override
    public String toString() {
        return "  viikko " + this.week + ": tehtyjä tehtäviä yhteensä: " + this.getTasksDone() + " (maksimi " + this.weekMax
                + "), aikaa kului " + this.hours + " tuntia, tehdyt tehtävät: " + this.getTasksDoneString();
    }

    public void setWeekMax(Course c) {
        this.weekMax = c.getWeekMax(this.week);
    }
    
}
