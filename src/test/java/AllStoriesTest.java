import io.qameta.allure.jbehave5.AllureJbehave5;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.phone.*;
import utils.BaseTest;
import utils.CommonPhoneSteps;
import utils.ResponseServices;

import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.TXT;

public class AllStoriesTest extends BaseTest {
    public static ResponseServices responseServices = new ResponseServices();
    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(
                "src/test/resources",
                "**/*.story",
                ""
        );
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return  new InstanceStepsFactory(configuration(),
                new AddPhoneSteps(responseServices),
                new DeletePhoneSteps(responseServices),
                new GetListPhoneSteps(),
                new GetPhoneIdSteps(responseServices),
                new UpdatePhoneSteps(responseServices),
                new CommonPhoneSteps(responseServices));
    }
}
