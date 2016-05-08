package com.paulmdavies.kenken

import org.scalatest.{FeatureSpec, GivenWhenThen}

class GroupTest extends FeatureSpec with GivenWhenThen {
    val ANY_TARGET = 1

    feature("Group completeness") {
        scenario("A group with all squares complete should be complete") {
            Given("A complete square")
            val completeSquare = Square(1, 1, 1)

            And("A group containing that square")
            val group = Group(completeSquare, ANY_TARGET)

            Then("It is complete")
            assert(group.complete)
        }

        scenario("A group with one square which is incomplete should not be complete") {
            Given("A group with one incomplete square")
            val incompleteSquare: Square = Square(1, 1)

            And("A group containing that square")
            val group = Group(incompleteSquare, ANY_TARGET)

            Then("It is not complete")
            assert(!group.complete)
        }

        scenario("A group with two squares, one complete and the other incomplete, should not be complete") {
            Given("A complete square")
            val completeSquare = Square(1, 1, 1)

            And("An incomplete square")
            val incompleteSquare = Square(1, 2)

            And("A group containing those squares")
            val group = Group(Seq(completeSquare, incompleteSquare), ANY_TARGET)

            Then("It is not complete")
            assert(!group.complete)
        }
    }
}
