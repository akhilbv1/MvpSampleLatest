package smartapps.com.mvpsamplelatest.Di.Module;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import smartapps.com.mvpsamplelatest.Di.Annotation.ActivityContext;
import smartapps.com.mvpsamplelatest.Di.Annotation.perActivity;
import smartapps.com.mvpsamplelatest.UI.Splash.SplashPresenter;
import smartapps.com.mvpsamplelatest.UI.base.MvpPresenter;

/*
 * Created by akhil on 19/7/18.
 */

@Module
public class ActivityModule {

   private Activity mActivity;

   public ActivityModule(Activity activity)
   {
       this.mActivity = activity;
   }

    @Provides
    @perActivity
     Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext(){
         return mActivity;
    }

}
