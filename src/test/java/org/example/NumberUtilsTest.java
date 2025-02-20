
//NAME: BRITTANY SIEGLER
//COLLABORATED WITH: MATTHEW THOMPSON

package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.NumberUtils.add;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberUtilsTest {
    /**
     * Step 1: understand the requirement, input type and output type
     * Requirement: Add two list of integer, index by index, and returns another list
     * <p>
     * Step 2 (raw):  Perform partition and boundary analysis on input and output
     * Each input: left | right
     * Combination of input:
     * Output:
     * Step 3: Derive potential test cases
     */
    @Test
    @DisplayName("Both lists are null")
    @Tag("specification")
    void bothListsNull() {
        assertThat(add(null, null)).isEqualTo(null);
    }

    @Test
    @DisplayName("Left list is null")
    @Tag("specification")
    void leftListNull() {
        List<Integer> left = null;
        List<Integer> right = new ArrayList<>();
        right.add(1);
        assertThat(add(left, right)).isEqualTo(null);
    }

    @Test
    @DisplayName("Right list is null")
    @Tag("specification")
    void rightListNull() {
        List<Integer> right = null;
        List<Integer> left = new ArrayList<>();
        left.add(1);
        assertThat(add(left, right)).isEqualTo(null);
    }

    @Test
    @DisplayName("Both lists empty")
    @Tag("specification")
    void bothListsEmpty() {
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        assertThat(add(left, right)).isEqualTo((empty));
    }

    @Test
    @DisplayName("Left list is empty, right list valid")
    @Tag("specification")
    void leftListEmpty() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        right.add(1);
        assertThat(add(left,right)).isEqualTo(result);
    }
    @Test
    @DisplayName("Right list is empty, left list valid")
    @Tag("specification")
    void rightEmptyLeftValid() {
        List<Integer> left= new ArrayList<>();
        left.add(1);
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        assertThat(add(left,right)).isEqualTo(result);
    }
    @Test
    @DisplayName("Left list is empty, right list valid")
    @Tag("specification")
    void leftEmptyRightValid() {
        List<Integer> right= new ArrayList<>();
        right.add(1);
        List<Integer> left = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        assertThat(add(right,left)).isEqualTo(result);
    }
    @Test
    @DisplayName("Left list is invalid, right list empty")
    @Tag("specification")
    void leftInvalidRightEmpty() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(10);
        assertThrows(IllegalArgumentException.class, () -> add(left, right));
    }
    @Test
    @DisplayName("Right list is invalid, left list empty")
    @Tag("specification")
    void rightInvalidLeftEmpty() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(10);
        assertThrows(IllegalArgumentException.class, () -> add(left, right));
    }

    @Test
    @DisplayName("Both lists invalid")
    @Tag("specification")
    void bothInvalid() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(10);
        left.add(10);
        assertThrows(IllegalArgumentException.class, () -> add(left, right));
    }

    @Test
    @DisplayName("Both lists valid")
    @Tag("specification")
    void bothListsValid() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(3);
        left.add(4);
        List<Integer> result = new ArrayList<>();
        result.add(7);
        assertThat(add(left, right)).isEqualTo(result);
    }
    @Test
    @DisplayName("Both lists add up to >9")
    @Tag("specification")
    void listsGreaterThan9() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(7);
        left.add(4);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        assertThat(add(left, right)).isEqualTo(result);
    }
    @Test
    @DisplayName("right list size 2, left list size 1")
    @Tag("specification")
    void right2Left1() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(7);
        right.add(1);
        left.add(2);
        List<Integer> result = new ArrayList<>();
        result.add(7);
        result.add(3);
        assertThat(add(left, right)).isEqualTo(result);
    }

    @Test
    @Tag("coverage")
    @DisplayName("Left <0")
    void leftLessThan0() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(-5);
        right.add(-3);
        right.add(4);
        assertThrows(IllegalArgumentException.class, () -> add(left, right));
    }

    @Test
    @Tag("coverage")
    @DisplayName("Right <0")
    void rightLessThan0() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        right.add(-5);
        left.add(-3);
        left.add(6);
        assertThrows(IllegalArgumentException.class, () -> add(left, right));
    }

    @Test
    @Tag("coverage")
    @DisplayName("Leading zeros in number")

    void leadingZeros() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        right.add(0);
        right.add(2);
        left.add(0);
        left.add(2);
        result.add(4);
        assertThat(add(left, right)).isEqualTo(result);
    }

    @Test
    @Tag("mutation")
    @DisplayName("All zeros")

    void allZeros() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        right.add(0);
        left.add(0);
        result.add(0);
        assertThat(add(left, right)).isEqualTo(result);
    }

    @Test
    @DisplayName("Right 9")
    @Tag("mutation")
    void right9() {
        List<Integer> left= new ArrayList<>();
        left.add(1);
        List<Integer> right = new ArrayList<>();
        right.add(9);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(0);
        assertThat(add(left,right)).isEqualTo(result);
    }
    @Test
    @DisplayName("Left 9")
    @Tag("mutation")
    void left9() {
        List<Integer> left= new ArrayList<>();
        left.add(9);
        List<Integer> right = new ArrayList<>();
        right.add(1);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(0);
        assertThat(add(left,right)).isEqualTo(result);
    }

    @Test
    @DisplayName("left list size 2, right list size 1 with carry")
    @Tag("mutation")
    void left2Right1() {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(7);
        left.add(1);
        right.add(9);
        List<Integer> result = new ArrayList<>();
        result.add(8);
        result.add(0);
        assertThat(add(left, right)).isEqualTo(result);
    }
}


