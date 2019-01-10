package configure.test.configurebuilds.activities.test102.dagger;

import javax.inject.Inject;

public class War {

    private Starks mStarks;

    private Boltons mBoltons;

    @Inject
    public War(Starks mStarks, Boltons mBoltons) {
        this.mStarks = mStarks;
        this.mBoltons = mBoltons;
    }


    public void prepare() {
        System.out.println("War::prepare");
        mStarks.prepareForWar();
        mBoltons.prepareForWar();
    }

    public void report() {
        System.out.println("War::report");
        mStarks.reportForWar();
        mBoltons.reportForWar();
    }

    public Boltons getmBoltons() {
        return mBoltons;
    }

    public Starks getmStarks() {
        return mStarks;
    }
}
