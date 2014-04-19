import com.google.caliper.Benchmark;

import java.util.Random;

/**
 * Created by usman on 18/04/2014.
 */
public class ArithematicBenchmark {

    private Random random;
    private long maxRange;

//    @BeforeExperiment
//    public void setUp(){
//        random = new Random(1000000000000000000L);
//
//    }
//
//    @Benchmark
//    public void floatingPointBenchmark(int reps){
//        fp.setDigits(30);
//        System.out.println(fp);
//        FloatingPoint fp = FloatingPoint.valueOf(random.nextDouble());
//        FloatingPoint that = FloatingPoint.valueOf(random.nextDouble());
//        fp.setDigits(30);
//        System.out.println(that);
//        for (int i = 0; i < reps; i++) {
//            fp = fp.divide(that);
//        }
//        System.out.println(fp.doubleValue());
//    }
//
//    @Benchmark
//    public void float64Benchmark(int reps){
//        Float64 fp = Float64.valueOf(1230101.01010101);
//        Float64 that = Float64.valueOf(123011209.010101);
//        for (int i = 0; i < reps; i++) {
//            fp = fp.divide(that);
//        }
//        System.out.println(fp.doubleValue());
//    }
//
//    @Benchmark
//    public void aptFloatBenchMark(int reps){
//        Apfloat apfloat = new Apfloat(1230101.01010101,10);
//        Apfloat divisor = new Apfloat(123011209.010101,10);
//        for (int i = 0; i < reps; i++) {
//            apfloat = apfloat.divide(divisor);
//        }
//        System.out.println(apfloat.doubleValue());
//    }

    @Benchmark
    public double doubleTest(int reps){
        double result = 0;
        for (int i = 0; i < reps; i++) {
            result = result + 1231123123123.123123123 * 1231123123123.9192939489;
        }

//        System.out.println(result);
        return result;
    }
}
