package smartapps.com.mvpsamplelatest.UI.News;

import smartapps.com.mvpsamplelatest.Data.TestResponsePojo;
import smartapps.com.mvpsamplelatest.UI.base.MvpView;

/**
 * Created by akhil on 20/7/18.
 */

public interface TestMvpView extends MvpView {

    void getDetailsSuccess(TestResponsePojo testResponsePojo);

    void getDetailsFailure(String message);

    void onShowProgress();

    void onDismissProgress();
}
