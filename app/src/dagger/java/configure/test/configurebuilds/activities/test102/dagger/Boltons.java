package configure.test.configurebuilds.activities.test102.dagger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Boltons implements House {

    String mName = "Boltons";

    @Inject
    public Boltons() {
    }

    @Override
    public void prepareForWar() {
        System.out.println("Boltons:--prepareForWar:--");
    }

    @Override
    public void reportForWar() {
        System.out.println("Boltons:--reportForWar:--");
    }

    @Override
    public String toString() {
        return this.mName;
    }
}
