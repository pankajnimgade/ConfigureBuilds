package configure.test.configurebuilds.activities.test101.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DateStoreModule.class})
public interface DateComponent {

    DateStore getDateStore();
}
