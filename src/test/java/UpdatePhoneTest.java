import utils.BaseTest;
import utils.CommonPhoneSteps;
import utils.ResponseServices;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.phone.AddPhoneSteps;
import steps.phone.UpdatePhoneSteps;

public class UpdatePhoneTest extends BaseTest {
    public static ResponseServices responseServices = new ResponseServices();

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new UpdatePhoneSteps(responseServices),new CommonPhoneSteps(responseServices),new AddPhoneSteps(responseServices));
    }
}
