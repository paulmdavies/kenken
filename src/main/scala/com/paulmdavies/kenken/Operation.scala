package com.paulmdavies.kenken

sealed trait Operation {
    protected[kenken] def result(values: Seq[Int]): Int
}

object NoOperation extends Operation {
    protected[kenken] def result(values: Seq[Int]): Int = values.head
}

object AdditionOperation extends Operation {
    protected[kenken] def result(values: Seq[Int]): Int = values.sum
}