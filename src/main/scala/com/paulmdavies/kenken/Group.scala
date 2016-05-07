package com.paulmdavies.kenken

object Group {
    def apply(operation : Operation, target : Int, squares : Seq[Square]) : Group = {
        new Group(operation, target, squares)
    }
}

class Group(operation : Operation, target : Int, squares : Seq[Square]) {

}