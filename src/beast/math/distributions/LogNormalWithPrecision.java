package beast.math.distributions;

import beast.core.Input;
import beast.core.parameter.RealParameter;

public class LogNormalWithPrecision extends LogNormalDistributionModel {
    final public Input<RealParameter> tauInput = new Input<>("tau", "Precision parameter");

    @Override
    void refresh() {
        double sd = Math.sqrt(1.0/tauInput.get().getValue());
        super.SParameterInput.setValue(sd + "", this);
        super.refresh();
    }
}
