package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// chain.doFilter위에 적으면 요청전 필터
		request.setCharacterEncoding("utf-8");
		System.out.println("EncodingFilter.doFilter() 실행");
		
		// 사용자가 요청한 어떤 컨트롤러 메서드
		chain.doFilter(request, response);
		
		// chain.doFilter아래 적으면 요청후 필터
	}

}
