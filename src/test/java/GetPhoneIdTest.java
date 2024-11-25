import org.jbehave.core.configuration.Configuration;
import utils.BaseTest;
import utils.CommonPhoneSteps;
import utils.ResponseServices;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.phone.GetPhoneIdSteps;

import java.util.Arrays;

public class GetPhoneIdTest extends BaseTest {

    public static ResponseServices responseServices = new ResponseServices();

    @Override
    public Configuration configuration() {
        return super.configuration();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new GetPhoneIdSteps(responseServices),new CommonPhoneSteps(responseServices));
    }
}
