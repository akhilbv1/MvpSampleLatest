package smartapps.com.mvpsamplelatest.Di.Component;

import dagger.Component;
import smartapps.com.mvpsamplelatest.Di.Annotation.perActivity;
import smartapps.com.mvpsamplelatest.Di.Module.ActivityModule;
import smartapps.com.mvpsamplelatest.Di.Module.ApplicationModule;
import smartapps.com.mvpsamplelatest.UI.Login.LoginActivity;
import smartapps.com.mvpsamplelatest.UI.Register.RegisterActivity;
import smartapps.com.mvpsamplelatest.UI.Splash.SplashActivity;
import smartapps.com.mvpsamplelatest.UI.UserDetails.UserDetailsActivity;

/*
 * Created by akhil on 19/7/18.
 */

@perActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(SplashActivity splashActivity);

    void inject(UserDetailsActivity userDetailsActivity);
}
