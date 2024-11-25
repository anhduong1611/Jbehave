import utils.BaseTest;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.phone.GetListPhoneSteps;

public class GetListPhoneTest extends BaseTest {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new GetListPhoneSteps());
    }
}
