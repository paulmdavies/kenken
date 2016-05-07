package com.paulmdavies.kenken

import org.scalatest.{FeatureSpec, GivenWhenThen}

class GroupTest extends FeatureSpec with GivenWhenThen {
    feature("Group") {
        scenario("A no-op group should only have one possibility") {
            Given("A square")
            val square = Square(1, 1)

            When("A no-op group with target 1 containing the square")
            val group = Group(NoOperation, 1, Seq(square))

            Then("The possibilities for the square should be [1]")
            assert(group.possibilities(square) == Set(1))
        }
    }
}
