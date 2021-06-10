package beast.math.distributions;

import beast.core.Description;
import beast.core.Input;
import beast.core.parameter.RealParameter;

@Description("Normal distribution component of the Normal Gamma distribution")
public class NormalGammaNormal extends Normal {
    final public Input<RealParameter> tauScaleInput = new Input<>("tauScale", "scale for the precision", Input.Validate.REQUIRED);

    @Override
    void refresh(){
        super.refresh();
        double sd = dist.getStandardDeviation();
        double sdScale =Math.sqrt(1.0/tauScaleInput.get().getValue());
        dist.setStandardDeviation(sd * sdScale);
    }
}
