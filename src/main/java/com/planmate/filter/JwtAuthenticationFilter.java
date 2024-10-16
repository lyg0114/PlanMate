package com.planmate.filter;

import com.planmate.auth.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author : leeyounggyo
 * @package : com.planmate.filter
 * @since : 2024. 10. 14.
 */

@RequiredArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        if (requestURI.contains("/api")) {
            // header 검사
            String token = jwtTokenProvider.extractJwtToken(request.getHeader("Authorization"));

            if (jwtTokenProvider.validateToken(token)) {

                // api/plan 으로 시작하는 api 이면서 method 종류가 POST, PATCH, DELETE 인 request 일 경우
                if (requestURI.startsWith("/api/plan")
                        && (method.equalsIgnoreCase("POST")
                        || method.equalsIgnoreCase("PATCH")
                        || method.equalsIgnoreCase("DELETE"))
                ) {

                    String role = jwtTokenProvider.getRole(token);

                    // ADMIN 권한일 경우만 접근 가능
                    if (role.equals("ADMIN")) {
                        filterChain.doFilter(request, response);

                    } else {
                        // 사용자에게 권한 없다고 알림
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 상태 코드 설정
                        response.setContentType("application/json"); // 응답 타입을 JSON으로 설정
                        response.setCharacterEncoding("UTF-8");
                        String jsonResponse = "{\"error\": \"Invalid Auth - need ADMIN Role \"}";
                        response.getWriter().write(jsonResponse); // 응답 본문에 JSON 메시지 작성
                    }

                } else {
                    filterChain.doFilter(request, response);
                }

            } else {
                extracted(response);
            }

        }

        if (requestURI.contains("/auth")) {
            filterChain.doFilter(request, response);
        }

    }

    private void extracted(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 상태 코드 설정
        response.setContentType("application/json"); // 응답 타입을 JSON으로 설정
        response.setCharacterEncoding("UTF-8");
        String jsonResponse = "{\"error\": \"Invalid or expired token\"}";
        response.getWriter().write(jsonResponse); // 응답 본문에 JSON 메시지 작성
    }

}
