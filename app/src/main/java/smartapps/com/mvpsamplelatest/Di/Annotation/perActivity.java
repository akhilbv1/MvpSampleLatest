package smartapps.com.mvpsamplelatest.Di.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/*
 * Created by akhil on 19/7/18.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface perActivity {
}
