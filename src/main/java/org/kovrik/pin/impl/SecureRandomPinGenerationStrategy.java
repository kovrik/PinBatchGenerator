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

import org.kovrik.pin.PinGenerationStrategy;

import java.security.SecureRandom;

/**
 * An implementation of a {@link PinGenerationStrategy} interface
 * that uses cryptographically secure and strong {@link SecureRandom} random number generator
 * to generate PINs.
 */
public class SecureRandomPinGenerationStrategy implements PinGenerationStrategy {

    // 4-digit PIN cannot be greater than 9999
    private static final int PIN_UPPER_BOUND = 9999;

    private final SecureRandom secureRandom = new SecureRandom();

    /**
     * {@inheritDoc}
     */
    public String generatePin() {
        // generates a random number from 0 to 10,000 (exclusive)
        // and left-pads it with zeroes (up to 4 characters).
        return String.format("%04d", secureRandom.nextInt(PIN_UPPER_BOUND + 1));
    }
}
