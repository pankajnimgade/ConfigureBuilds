package configure.test.configurebuilds.activities.test101.dagger;

import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DateStoreImpl implements DateStore {

    @Inject
    public DateStoreImpl() {
    }

    @Override
    public long getDate() {
        return Calendar.getInstance().getTimeInMillis();
    }
}
