package com.akshat.walmartdemo.presenter

import com.akshat.walmartdemo.model.Response

interface EventsListener {
    fun onGetCallFinished(data: Response)
}