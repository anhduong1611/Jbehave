import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class Oktest extends OptionsStoryTest {
    @Test
    public void testStories() {
        configuredEmbedder().embedderControls().doVerboseFailures(true);
        configuredEmbedder().runStoriesAsPaths(storyPaths());
    }
}
