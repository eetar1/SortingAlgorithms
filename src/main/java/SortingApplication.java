import Algorithms.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class SortingApplication {
    private static ArrayList<Integer> unSortedList;
    private static int numbers;
    private static String[] sorts = {"MergeSort", "QuickSort", "RadixSort", "SelectionSort", "BubbleSort"};

    public static void main(String args[]) throws Exception {
        numbers = Integer.parseInt(args[0]);
        double[] times = new double[sorts.length];

        Algorithm[] algorithm = {new MergeSort(), new QuickSort(), new RadixSort(), new SelectionSort(), new BubbleSort()};
        setUp();

        for (int i = 0; i < algorithm.length; i++) {
            times[i] = TimeFunction(algorithm[i]);
        }

        graphChart(times);
    }

    private static void graphChart(double[] times) throws IOException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < sorts.length; i++) {
            dataset.addValue(times[i] / 1000000, (sorts[i]), "");
        }
        JFreeChart barChart = ChartFactory.createBarChart("Sorting Algorithm " + numbers + " Elements", "Algorithm", "Milli Seconds", dataset);
        File BarChart = new File("AlgorithmChart.jpeg");
        ChartUtils.saveChartAsJPEG(BarChart, barChart, 640, 480);

    }

    private static void setUp() {
        unSortedList = new ArrayList<>(numbers);
        for (int i = 0; i < numbers + 1; i++) {
            unSortedList.add(i);
        }
        Collections.shuffle(unSortedList);
    }

    private static <T> double TimeFunction(Algorithm algorithm) throws Exception {
        long start = System.nanoTime();
        ArrayList<Integer> sortedList = algorithm.sort(unSortedList);
        long end = System.nanoTime() - start;
        for(int i =0; i < sortedList.size()-1;i++){
            if(sortedList.get(i) > sortedList.get(i+1)){
                throw new Exception("List not sorted");
            }
        }
        Collections.shuffle(unSortedList);
        return end;
    }
}
