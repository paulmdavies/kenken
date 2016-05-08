package com.paulmdavies.kenken

import org.scalatest.{FeatureSpec, GivenWhenThen}

class GroupTest extends FeatureSpec with GivenWhenThen {
    val ANY_TARGET = 1
    val ANY_OPERATION = NoOperation

    feature("Group completeness") {
        scenario("A group with all squares complete should be complete") {
            Given("A complete square")
            val completeSquare = Square(1, 1, 1)

            And("A group containing that square")
            val group = Group(completeSquare, ANY_TARGET, ANY_OPERATION)

            Then("It is complete")
            assert(group.complete)
        }

        scenario("A group with one square which is incomplete should not be complete") {
            Given("A group with one incomplete square")
            val incompleteSquare: Square = Square(1, 1)

            And("A group containing that square")
            val group = Group(incompleteSquare, ANY_TARGET, ANY_OPERATION)

            Then("It is not complete")
            assert(!group.complete)
        }

        scenario("A group with two squares, one complete and the other incomplete, should not be complete") {
            Given("A complete square")
            val completeSquare = Square(1, 1, 1)

            And("An incomplete square")
            val incompleteSquare = Square(1, 2)

            And("A group containing those squares")
            val group = Group(Seq(completeSquare, incompleteSquare), ANY_TARGET, ANY_OPERATION)

            Then("It is not complete")
            assert(!group.complete)
        }
    }

    feature("Group correctness") {
        scenario("A group should not be correct if it is not complete") {
            Given("An incomplete square")
            val square = Square(1, 1)

            And("A group containing that square")
            val group = Group(square, ANY_TARGET, ANY_OPERATION)

            Then("The group should not be correct")
            assert(!group.correct)
        }

        scenario("A no-op group should be correct if its square contains its target") {
            Given("A complete square with value 1")
            val square = Square(1, 1, 1)

            And("A no-op group containing that square with target 1")
            val group = Group(square, 1, NoOperation)

            Then("The group should be correct")
            assert(group.correct)
        }

        scenario("A no-op group should not be correct if its square contains its target") {
            Given("A complete square with value 1")
            val square = Square(1, 1, 1)

            And("A no-op group containing that square with target 4")
            val group = Group(square, 4, NoOperation)

            Then("The group should be correct")
            assert(!group.correct)
        }

        scenario("An addition group should be correct if the sum of the values in its squares equals its target")
        {
            Given("A complete square with value 1")
            val square11 = Square(1, 1, 1)

            And("A complete square with value 2")
            val square12 = Square(1, 2, 2)

            And("A addition group containing those squares with target 3")
            val group = Group(Seq(square11, square12), 3, AdditionOperation)

            Then("The group is correct")
            assert(group.correct)
        }

        scenario("An addition group should not be correct if the sum of the values in its squares does not equal its target")
        {
            Given("A complete square with value 1")
            val square11 = Square(1, 1, 1)

            And("A complete square with value 2")
            val square12 = Square(1, 2, 2)

            And("A addition group containing those squares with target 4")
            val group = Group(Seq(square11, square12), 4, AdditionOperation)

            Then("The group is correct")
            assert(!group.correct)
        }

        scenario("An subtraction group should be correct if the larger of its two square's values minus the lesser equals its target")
        {
            Given("A complete square with value 1")
            val square11 = Square(1, 1, 1)

            And("A complete square with value 2")
            val square12 = Square(1, 2, 2)

            And("A subtraction group containing those squares with target 1")
            val group = Group(Seq(square11, square12), 1, SubtractionOperation)

            Then("The group is correct")
            assert(group.correct)
        }

        scenario("An subtraction group should not be correct if the larger of its two square's values minus the lesser does not equal its target")
        {
            Given("A complete square with value 1")
            val square11 = Square(1, 1, 1)

            And("A complete square with value 2")
            val square12 = Square(1, 2, 2)

            And("A subtraction group containing those squares with target 4")
            val group = Group(Seq(square11, square12), 2, SubtractionOperation)

            Then("The group is correct")
            assert(!group.correct)
        }
    }
}
