package beast.math.distributions;

import beast.core.Description;
import junit.framework.TestCase;
import org.apache.commons.math.special.Gamma;
import org.junit.Test;

public class NormalGammaNormalTest extends TestCase {
    @Test
    public void testLogPdf(){
        double priorLoc = -0.3;
        double priorPrecisionScale = 2.3;
        double priorPrecision = 1.2;

        double x = 0.6;

        Normal expectedDist = new Normal();
        expectedDist.meanInput.setValue(priorLoc + "", expectedDist);
        expectedDist.tauInput.setValue((priorPrecision * priorPrecisionScale) + "", expectedDist);
        expectedDist.initAndValidate();

        NormalGammaNormal dist = new NormalGammaNormal();
        dist.meanInput.setValue(priorLoc + "", dist);
        dist.tauInput.setValue(priorPrecision + "", dist);
        dist.tauScaleInput.setValue(priorPrecisionScale + "", dist);

        assertEquals(expectedDist.logDensity(x), dist.logDensity(x), 1e-16);



    }
}
