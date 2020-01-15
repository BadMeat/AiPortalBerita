package com.dolan.aiportalberita.db.room

import java.util.concurrent.Executors

class Executor {
    companion object {
        private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

        fun IOTHread(runnable: Runnable) {
            IO_EXECUTOR.execute(runnable)
        }
    }

}