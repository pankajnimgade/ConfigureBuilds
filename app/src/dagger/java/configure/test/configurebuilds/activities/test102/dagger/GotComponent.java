package configure.test.configurebuilds.activities.test102.dagger;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component
public interface GotComponent {

    War getWar();
}
