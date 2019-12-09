package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {
    private ArrayList<Matcher> matchers;


    public QueryBuilder() {
        this.matchers = new ArrayList<>();
        this.matchers.add(new All());
    }

    public Matcher build() {
        ArrayList<Matcher> m = matchers;
        this.matchers = new ArrayList<>();
        this.matchers.add(new All());
        return new And(m.toArray(new Matcher[matchers.size()]));
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFeverThan(value, category));
        return this;
    }

    //    public Querybuilder not(Matcher matcher){
//        matchers.add(new Not(matcher));
//        return this;
//    }
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers1) {
        matchers.add(new Or(matchers1));
        return this;
    }


}
