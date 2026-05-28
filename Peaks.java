

class Solution {

    /**
     * @param values Les valeurs mesurées par le capteur de radioactivité
     * @return Le nombre total de pics inférieurs et de pics supérieurs
     */
    public static int countPeaks(List<Double> values) {
        int peaks = 0;
        for (int i = 1 ; i < values.size()-1 ; i++){
            
            double c =  values.get(i);
            double p = values.get(i-1);
            double n = values.get(i+1);
            if (p + 5 <= c && n + 5 <= c  || p-5 >= c && n-5 >= c) peaks++;
        }
        return peaks;
    }

    public static int countPeaksCorrected(List<Double> values) {
    int peaks = 0;

    for (int i = 1; i < values.size() - 1; i++) {
        double p = values.get(i - 1);
        double c = values.get(i);
        double n = values.get(i + 1);

        boolean upper = c > p + 5 && c > n + 5;
        boolean lower = c < p - 5 && c < n - 5;

        if (upper || lower) peaks++;
    }

    return peaks;
}






    /* Ignore and do not change the code above */
}



// [8, 10.7, 17.1, 11.2, 13.5, 9.9, 14.9, 9.4, 9.4, 3.1, 12.7] 3
// [81.3, 80.3, 75.3, 80.3, 85.2, 90.2, 95.2, 90.2, 89.1, 88.8] 2

// [8, 8, 2.1, 20.7, 8, 8, 8, 2.1, 20.7, 8] 4

// [0, 10, 0, 10, 0, 10, 0, 10, 0, 10] 8
//[0, 20, 40, 60, 80, 99.9, 80, 60, 40, 20, 0] 1
