package com.example.demo

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EchoAction {

    data class EchoActionOutput(
        val content: String,
    )

    data class EchoActionInput(
        val text: String,
        val empty: String?,
    )

    data class EchoActionRequestBody(
        val inputs: EchoActionInput,
    )

    @PostMapping("/fauxservice/actions/echo/execute")
    fun execute(@RequestBody body: EchoActionRequestBody): EchoActionOutput {
        return EchoActionOutput(body.inputs.text)
    }
}
