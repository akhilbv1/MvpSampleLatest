package smartapps.com.mvpsamplelatest.UI.base;

/**
 * Created by akhil on 18/7/18.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();
}
