package com.sf.core

class WrappedResponse<out T>(var status: Status, val data: T?, var message: String? = null) {
    enum class Status {
        SUCCESS,
        ERROR
    }
}