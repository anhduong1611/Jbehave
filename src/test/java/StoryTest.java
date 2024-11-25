import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;
import steps.phone.*;
import utils.CommonPhoneSteps;
import utils.ResponseServices;

import java.text.SimpleDateFormat;

import static org.jbehave.core.reporters.Format.*;

public class StoryTest extends Embedder {
    public static ResponseServices responseServices = new ResponseServices();
    @Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
    }

    @Override
    public Configuration configuration() {
        Class<? extends StoryTest> embedderClass = this.getClass();
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embedderClass.getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML))
                .useParameterConverters(new ParameterConverters()
                        .addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")))) // use custom date pattern
                .useStepPatternParser(new RegexPrefixCapturingPatternParser(
                        "%")) // use '%' instead of '$' to identify parameters
                .useStepMonitor(new SilentStepMonitor());
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
