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
package org.kovrik.pin;

/**
 * PIN Generation Strategy interface.
 * Different PIN generation implementations may use different approaches and strategies.
 * For example, we can have strategies that generate 4-digit PINs or 6-digit PINs
 * (technically, ISO 9564-1 allows PINs to have up to 12 digits and even allows alpha-numeric PINS).
 * Also, different implementations may use different algorithms to generate PINs:
 * - generate the same PIN on each invocation (a stub)
 * - generate PINs using {@link java.util.Random}
 * - generate PINs using {@link java.security.SecureRandom}
 * etc.
 */
@FunctionalInterface
public interface PinGenerationStrategy {

    /**
     * Generates a PIN.
     * @return a generated PIN.
     */
    String generatePin();
}
