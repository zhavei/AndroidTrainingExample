package com.syafei.myreadwritefile

import android.content.Context

class FileHelper {

    internal object FileHelperInternal {
        fun writeToFile(fileModel: FileModel, context: Context) {
            context.openFileOutput(fileModel.fileName, Context.MODE_PRIVATE).use {
                it.write(fileModel.data?.toByteArray())
            }
        }

        fun readFromFile(context: Context, fileName: String): FileModel {
            val fileModel = FileModel()
            fileModel.fileName = fileName
            fileModel.data = context.openFileInput(fileName).bufferedReader().useLines { lines ->
                lines.fold("") { some, text ->
                    "$some\n$text"
                }
            }
            return fileModel
        }
    }


}