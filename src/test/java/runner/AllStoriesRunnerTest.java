package runner;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.phone.*;
import utils.BaseTest;
import utils.CommonPhoneSteps;
import utils.ResponseServices;

public class AllStoriesRunnerTest extends BaseTest {
    public static ResponseServices responseServices = new ResponseServices();
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
