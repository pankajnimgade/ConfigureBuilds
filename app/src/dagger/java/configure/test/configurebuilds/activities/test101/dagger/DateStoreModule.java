package configure.test.configurebuilds.activities.test101.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DateStoreModule {

    @Provides
    @Singleton
    DateStore providesDateStore(DateStoreImpl dateStore) {
        return dateStore;
    }
}
