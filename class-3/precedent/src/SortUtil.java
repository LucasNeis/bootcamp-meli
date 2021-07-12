import java.util.List;

public class SortUtil {
    public static <T> void sort (List<Precedent <T>> arr[]) {
        for (List<Precedent<T>> list : arr) {
            sort(list);
        }
    }
    
    public static <T> void sort(List<Precedent<T>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(i).preceeds((T) arr.get(j)) >0) {
                    Precedent temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
}
