import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStoryMaps;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import steps.phone.*;
import utils.CommonPhoneSteps;
import utils.ResponseServices;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class OptionsStoryTest extends JUnitStoryMaps {
    public static ResponseServices responseServices = new ResponseServices();
    public OptionsStoryTest() {
        configuredEmbedder().useMetaFilters(metaFilters());
    }

    @Override
    public List<String> metaFilters() {
        return List.of("-skip","runFirst");
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(
                "src/test/resources",
                "**/*.story",
                ""
        );}
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass())));
    }

    @Test
    public void testStories() {
        // Đảm bảo câu chuyện được chạy với các bộ lọc đã chỉ định
        configuredEmbedder().embedderControls().doVerboseFailures(true);
        configuredEmbedder().runStoriesAsPaths(storyPaths());
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
