package smartapps.com.mvpsamplelatest.Di.Module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import smartapps.com.mvpsamplelatest.Di.Annotation.ActivityContext;

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
     Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext(){
         return mActivity;
    }


}
