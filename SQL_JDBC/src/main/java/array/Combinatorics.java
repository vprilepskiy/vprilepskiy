package array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VLADIMIR on 31.10.2017.
 */
public class Combinatorics {

    /**
     * Возвращает все возможные набры перестановок.
     *
     * @param array - array.
     * @return - arrays.
     */
    public List<int[]> allVariantsOfPermutations(int[] array) {

        final List<int[]> result = new LinkedList<>();

        // добавим в результирующий набор
        result.add(array);

        // пройти по всем ячейкам кроме последней, т.к. перестановок в последней ячейке не может быть
        for (int i = 0; i < array.length - 1; i++) {

            final List<int[]> tempList = new LinkedList<>();
            tempList.addAll(result);

            // по всем наборам
            for (int[] arr : tempList) {
                final List<int[]> arrays = this.transposition(arr, i);
                result.addAll(arrays);
            }
        }

        return result;
    }


    /**
     * Переместит n-ый элемент в начало, где n-номер возвращаемого массива.
     * <p>
     * Example for [1, 2, 3, 4], return:
     * [2, 1, 3, 4]
     * [3, 1, 2, 4]
     * [4, 1, 2, 3]
     *
     * @param array - array.
     * @return - arrays.
     */
    private List<int[]> transposition(int[] array) {
        final List<int[]> result = new LinkedList<>();

        // итерация по элементам массива
        for (int i = 1; i < array.length; i++) {

            // начало массива
            final int[] a = Arrays.copyOfRange(array, 0, i);
            // конец массива
            final int[] b = Arrays.copyOfRange(array, i + 1, array.length);
            // средний элмент + начало массива + конец массива
            final int[] ab = ArrayUtils.addAll(ArrayUtils.add(a, 0, array[i]), b);

            // записать вариант перестановки в результирующий рабор
            result.add(ab);
        }
        return result;
    }


    /**
     * Выполнит перестановку с определенного элемента.
     * <p>
     * Example for [1, 2, 3, 4], witch begin=1 return:
     * [1, 3, 2, 4]
     * [1, 4, 2, 3]
     * <p>
     * Example for [1, 2, 3, 4], witch begin=2 return:
     * [1, 2, 4, 3]
     *
     * @param array      - array.
     * @param beginIndex - индекс элемента с которого следует начать перестановку.
     * @return - arrays.
     */
    private List<int[]> transposition(int[] array, int beginIndex) {
        final List<int[]> result = new LinkedList<>();

        // убираем элементы из начала массива
        final int[] castBeginArr = Arrays.copyOfRange(array, beginIndex, array.length);
        // получаем массивы с переставлеными элементами
        final List<int[]> resultCastBeginArrays = this.transposition(castBeginArr);
        // добавляем в результат начальные элементы и полученные(переставленные)
        for (int[] resultCastBeginArr : resultCastBeginArrays) {
            result.add(ArrayUtils.addAll(Arrays.copyOf(array, beginIndex), resultCastBeginArr));
        }

        return result;
    }

}
