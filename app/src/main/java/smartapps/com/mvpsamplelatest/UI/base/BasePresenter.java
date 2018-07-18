package smartapps.com.mvpsamplelatest.UI.base;

import smartapps.com.mvpsamplelatest.Data.DataManager;

/*
 * Created by akhil on 18/7/18.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    private DataManager mDataManager;

    public BasePresenter(DataManager mDataManager)
    {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView(){
        return mMvpView;
    }

    public DataManager getDataManager(){
        return mDataManager;
    }

}
