package com.paulmdavies.kenken

import org.scalatest.{FeatureSpec, GivenWhenThen}

class SquareTest extends FeatureSpec with GivenWhenThen {
    feature("Square completeness") {
        scenario("A square should not be complete when it does not contain a number") {
            Given("A square, which is not filled in")
            val square = Square(1, 1)

            Then("It is not complete")
            assert(!square.complete)
        }

        scenario("A square should be complete when it has had a number set") {
            Given("A square")
            val square = Square(1, 1)

            When("I fill it in")
            square.set(1)

            Then("It is complete")
            assert(square.complete)
        }

        scenario("A square should be complete when it has a number at construction-time") {
            Given("A square with a pre-set value")
            val square = Square(1, 1, 1)

            Then("It is complete")
            assert(square.complete)
        }
    }
}
