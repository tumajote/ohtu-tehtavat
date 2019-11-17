package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String nationality;
    private String team;
    private String birthdate;
    private Integer goals;
    private Integer assists;
    private Integer penalties;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + this.team + " " + this.goals + " + " + this.assists + " = " + (this.goals + this.assists);
    }

    @Override
    public int compareTo(Player o) {
        if (this.assists + this.goals > o.getAssists() + o.getGoals()) {
            return +1;
        } else if (this.assists + this.goals < o.getAssists() + o.getGoals()) {
            return -1;
        }
        return 0;
    }

}
