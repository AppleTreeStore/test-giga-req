package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.filter

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class RequestLoggingFilter: OncePerRequestFilter() {
    private val log = LoggerFactory.getLogger(RequestLoggingFilter::class.java)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        log.info("Request: ${request.method} ${request.requestURI}")
        filterChain.doFilter(request, response)
        log.info("Response: ${response.status}")
    }
}