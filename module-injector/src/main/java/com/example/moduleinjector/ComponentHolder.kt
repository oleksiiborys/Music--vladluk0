package com.example.moduleinjector

interface BaseApi

interface BaseImpl

interface ComponentHolder<C: BaseApi, D: BaseImpl> {

    fun get(): C

    fun init(dependencies: D)

    fun reset()
}