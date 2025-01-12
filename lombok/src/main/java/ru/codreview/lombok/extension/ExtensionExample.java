package lombok.extension;

import lombok.experimental.ExtensionMethod;

import java.util.Arrays;


@ExtensionMethod(Arrays.class)
public class ExtensionExample {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6};
        arr.sort();
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.toString());
        System.out.println(arr);
    }

    //Синтаксис Class::method недоступен для ExtensionMethod - только обычные lambda

}
