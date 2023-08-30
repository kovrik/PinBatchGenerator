/////////////////////////////////////////////////////////////////////////////////////
// MIT License
//
// Copyright (c) 2023
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
///////////////////////////////////////////////////////////////////////////////////////
package org.kovrik.pin.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kovrik.pin.BatchGenerator;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UniquePinBatchGeneratorTest {

    private final BatchGenerator<String> uniquePinBatchGenerator = new UniquePinBatchGenerator(new SecureRandomPinGenerationStrategy());

    @Test
    @DisplayName("Should throw an exception if batch size is a negative number.")
    void generateBatch1() {
        assertThrows(IllegalArgumentException.class, () -> uniquePinBatchGenerator.generateBatch(-1));
    }

    @Test
    @DisplayName("Should return an empty collection if batch size is 0.")
    void generateBatch2() {
        Collection<String> pins = uniquePinBatchGenerator.generateBatch(0);
        assertThat(pins).isEmpty();
    }

    @Test
    @DisplayName("Should return an collection of 1000 unique PINs.")
    void generateBatch3() {
        Collection<String> pins = uniquePinBatchGenerator.generateBatch(1000);
        assertThat(pins).hasSize(1000);
        assertThat(pins.stream().distinct()).hasSize(1000);
    }

    public static Stream<Arguments> batchSizeSource() {
        return IntStream.range(0, 10)
                        .mapToObj(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("batchSizeSource")
    void generateBatchParametrized(int batchSize) {
        Collection<String> pins = uniquePinBatchGenerator.generateBatch(batchSize);
        assertThat(pins).hasSize(batchSize);
        assertThat(pins.stream().distinct()).hasSize(batchSize);
    }
}