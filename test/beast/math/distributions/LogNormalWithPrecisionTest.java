package beast.math.distributions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogNormalWithPrecisionTest {
    @Test
    public void testLogPdf(){
        double priorM = -0.3;
        double priorPrecision = 1.2;

        double x = 0.6;

        LogNormalDistributionModel expectedDist = new LogNormalDistributionModel();
        expectedDist.MParameterInput.setValue(priorM + "", expectedDist);
        expectedDist.SParameterInput.setValue(Math.sqrt(1.0 / priorPrecision) + "", expectedDist);
        expectedDist.hasMeanInRealSpaceInput.setValue(false, expectedDist);
        expectedDist.initAndValidate();

        LogNormalWithPrecision dist = new LogNormalWithPrecision();
        dist.MParameterInput.setValue(priorM + "", dist);
        dist.tauInput.setValue(priorPrecision + "", dist);

        assertEquals(expectedDist.logDensity(x), dist.logDensity(x), 1e-16);
    }
}
