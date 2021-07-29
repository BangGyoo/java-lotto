package com.banggyoo.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    void 소팅테스트() {
        int[][] ints = new int[][]{{1,4},{3,1},{1,2}};

        System.out.println(Arrays.deepToString(ints));

        Arrays.sort(ints, (a,b) -> (a[0] != b[0] ? a[0]-b[0] : a[1] - b[1]));

        System.out.println(Arrays.deepToString(ints));

    }
}
