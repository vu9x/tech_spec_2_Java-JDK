package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Main {
    public static void main(String[] args) {
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        descriptiveStatistics.addValue(2);
        descriptiveStatistics.addValue(3);
        descriptiveStatistics.addValue(4);
        descriptiveStatistics.addValue(5);

        System.out.println("Min: " + descriptiveStatistics.getMin());
        System.out.println("Max: " + descriptiveStatistics.getMax());
        System.out.println("Mean: " + descriptiveStatistics.getMean());
        System.out.println("Sum: " + descriptiveStatistics.getSum());

        System.out.println(CombinatoricsUtils.factorial(5));
        
    }

}