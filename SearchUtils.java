public class SearchUtils {
    
}
import java.util.*;

public class SearchUtils {

    // 1) Recherche linéaire O(n)
    // --------------------------
    // Parcourt tout le tableau jusqu'à trouver k.
    public static boolean existsLinear(int[] ints, int k) {
        for (int i : ints) {
            if (i == k) return true;
        }
        return false;
    }


    // 2) Recherche via HashSet O(1) en moyenne
    // ----------------------------------------
    // Transforme le tableau en HashSet puis vérifie la présence.
    public static boolean existsHashSet(int[] ints, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : ints) set.add(i);
        return set.contains(k);
    }


    // 3) Recherche dichotomique O(log n)
    // ----------------------------------
    // Nécessite que le tableau soit trié.
    public static boolean existsBinarySearch(int[] ints, int k) {
        return Arrays.binarySearch(ints, k) >= 0;
    }


    // 4) Version optimisée : pré-construire le HashSet une seule fois
    // ---------------------------------------------------------------
    // Utile si tu fais plusieurs recherches successives.
    public static Set<Integer> buildSet(int[] ints) {
        Set<Integer> set = new HashSet<>();
        for (int i : ints) set.add(i);
        return set;
    }

    public static boolean existsInPrebuiltSet(Set<Integer> set, int k) {
        return set.contains(k);
    }
}
