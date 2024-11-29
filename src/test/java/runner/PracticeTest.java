package runner;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.phone.PracticeSteps;
import utils.BaseTest;

import java.util.List;

public class PracticeTest extends BaseTest {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),new PracticeSteps());
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(
                "src/test/resources",
                "practice_test.story",
                ""
        );
    }
}
