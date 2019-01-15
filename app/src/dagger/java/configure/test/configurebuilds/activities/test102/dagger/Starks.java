package configure.test.configurebuilds.activities.test102.dagger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Starks implements House {

    String mName = "Stark";

    @Inject
    public Starks() {
    }

    @Override
    public String toString() {
        return this.mName;
    }

    @Override
    public void prepareForWar() {
        System.out.println("Start:--prepareForWar:--");
    }

    @Override
    public void reportForWar() {
        System.out.println("Start:--reportForWar:--");

    }
}
