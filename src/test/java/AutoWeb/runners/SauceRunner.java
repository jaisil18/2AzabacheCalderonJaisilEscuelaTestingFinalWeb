package AutoWeb.runners;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/saucedemo")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "AutoWeb.stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporter,pretty,timeline:target/test-results/timeline")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@SauceDemo")
public class SauceRunner {
}
