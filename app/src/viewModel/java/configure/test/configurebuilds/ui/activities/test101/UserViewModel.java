package configure.test.configurebuilds.ui.activities.test101;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private String userId;
    private MutableLiveData<User> userLiveData = new MutableLiveData<>();

    public void init(String userId) {
        this.userId = userId;
        User user = new User("John", "Smith");
        userLiveData.postValue(user);

    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }
}
