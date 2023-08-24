package gctest;


import javassist.ClassPool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static javassist.ClassPool.getDefault;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GCOOM {

    static ClassPool cp = getDefault();

    // vm option -ea -Xmx64m -verbose:gc
    @Test
    void gcHeapOverFlow() {
        System.setProperty("-Xmx64m ", "-Xmx64m ");
        assertThrows(OutOfMemoryError.class, () -> {
            List<Integer> li = IntStream.range(1, 100).boxed().collect(Collectors.toList());
            for (int i = 1; true; i++) {
                if (i % 50 == 0) {
                    Thread.sleep(200);
                }
                IntStream.range(0, 100).forEach(li::add);
            }
        });
    }


    // vm option -ea -Xmx256m -verbose:gc
    @Test
    void gcNotHeapOverFlow() {
        assertThrows(OutOfMemoryError.class, () -> {
            List<Integer> list;
            while (true) {
                list = new ArrayList<>();
                IntStream.range(1, 1000).forEach(list::add);
            }
        });
    }

    // vm option -ea -XX:MaxMetaspaceSize=128m -verbose:gc
    @Test
    void metaspaceOverflow() {
        assertThrows(OutOfMemoryError.class, () -> {
            for (int i = 0; ; i++) {
                Class c = cp.makeClass("io.github.yaboong.Generated" + i).toClass();
            }
        });
    }
}
