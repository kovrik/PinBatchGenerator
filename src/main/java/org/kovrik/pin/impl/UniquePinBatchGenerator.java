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

import org.kovrik.pin.BatchGenerator;
import org.kovrik.pin.PinGenerationStrategy;

import java.util.HashSet;
import java.util.Set;

/**
 * An implementation of {@link BatchGenerator} that accepts a {@link PinGenerationStrategy}
 * and uses given strategy to generate a batch of any given size of _unique_ PINs.
 * <p>
 * NOTE: this implementation relies on a {@link Set} to guarantee uniqueness.
 */
public class UniquePinBatchGenerator implements BatchGenerator<String> {

    private final PinGenerationStrategy pinGenerationStrategy;

    public UniquePinBatchGenerator(PinGenerationStrategy pinGenerationStrategy) {
        this.pinGenerationStrategy = pinGenerationStrategy;
    }

    /**
     * Generates a batch of unique PINs of given size.
     * @param batchSize - size of the batch.
     * @throws IllegalArgumentException if batchSize is negative.
     * @return Set of PINs.
     */
    @Override
    public Set<String> generateBatch(int batchSize) {
        if (batchSize < 0) {
            throw new IllegalArgumentException("Batch size cannot be negative");
        }
        if (batchSize == 0) {
            return Set.of();
        }
        Set<String> pins = new HashSet<>();
        while (pins.size() < batchSize) {
            pins.add(pinGenerationStrategy.generatePin());
        }
        return pins;
    }
}
