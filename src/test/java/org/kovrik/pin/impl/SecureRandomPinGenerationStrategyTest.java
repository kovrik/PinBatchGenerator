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
import org.kovrik.pin.PinGenerationStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class SecureRandomPinGenerationStrategyTest {

    private final PinGenerationStrategy pinGenerationStrategy = new SecureRandomPinGenerationStrategy();

    @Test
    @DisplayName("Generated PIN should not be null.")
    void generatePin1() {
        String pin = pinGenerationStrategy.generatePin();
        assertThat(pin).isNotNull();
    }

    @Test
    @DisplayName("Generated PIN should have size 4.")
    void generatePin2() {
        String pin = pinGenerationStrategy.generatePin();
        assertThat(pin).hasSize(4);
    }

    @Test
    @DisplayName("Generated PIN should only contain digits.")
    void generatePin3() {
        String pin = pinGenerationStrategy.generatePin();
        assertThat(pin.chars().allMatch(Character::isDigit)).isTrue();
    }
}