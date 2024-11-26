package utils;

import io.qameta.allure.jbehave5.AllureJbehave5;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;

import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.reporters.Format.*;

public abstract class BaseTest extends JUnitStory {
    protected String metaFilter = System.getProperty("meta.filter", "");
    protected String includePath = System.getProperty("include.paths","**/*.story");
    protected String excludePath = System.getProperty("exclude.paths","");
    public BaseTest() {

        String[] metaFiltersArray = metaFilter.split(",");
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true);
        configuredEmbedder().useMetaFilters(List.of(metaFiltersArray));
    }
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(CONSOLE,TXT)
                        .withReporters(new AllureJbehave5()));
    }

    @Override
    public abstract InjectableStepsFactory stepsFactory();
    @Override
    public List<String> storyPaths() {



        // Sử dụng StoryFinder để tìm các file .story trong thư mục chỉ định
        return new StoryFinder().findPaths(
                "src/test/resources",   // Đường dẫn cơ bản từ classpath
                includePath,         // Pattern để tìm file
                excludePath                   // Loại trừ file (để trống nếu không cần)
        );
    }

}

//    @Override
//    public List<String> storyPaths() {
//        // Đường dẫn cơ sở cho thư mục chứa các file .story
//        String storyBasePath = "dataTest/phone";
//
//        // Sử dụng StoryFinder để tìm các file .story trong thư mục chỉ định
//        return new StoryFinder().findPaths(
//                "dataTest/phone",     // Đường dẫn cơ bản từ classpath
//                "**/*.story",         // Pattern để tìm file
//                ""                    // Loại trừ file (để trống nếu không cần)
//        );
//    }
//    @Override
//    public List<String> storyPaths() {
//        List<String> storyPaths = new ArrayList<>();
//        storyPaths.add("get_list_test.story");
//        return storyPaths;
//    }
