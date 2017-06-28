package com.paul.sertest.filter;

import io.jsonwebtoken.Claims;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paul.sertest.ResponseMgr;
import com.paul.sertest.TokenMgr;
import com.paul.sertest.config.Constant;
import com.paul.sertest.model.CheckResult;
import com.paul.sertest.model.SubjectModel;
import com.paul.sertest.utils.GsonUtil;

/**
 * 签名检验过滤器
 * @author XY
 *
 */
public class SignFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
		HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
		
		
		String tokenStr = httpServletRequest.getParameter("token");
		if (tokenStr == null || tokenStr.equals("")) {
			PrintWriter printWriter = httpServletResponse.getWriter();
			printWriter.print(ResponseMgr.err());
			printWriter.flush();
			printWriter.close();
			return;
		}
		
		// 验证JWT的签名，返回CheckResult对象
		CheckResult checkResult = TokenMgr.validateJWT(tokenStr);
		if (checkResult.isSuccess()) {
			Claims claims = checkResult.getClaims();
			SubjectModel model = GsonUtil.jsonStrToObject(claims.getSubject(), SubjectModel.class);
			httpServletRequest.setAttribute("tokensub", model);
			httpServletRequest.getRequestDispatcher("/success.jsp").forward(httpServletRequest, httpServletResponse);
		} else {
			switch (checkResult.getErrCode()) {
			// 签名过期，返回过期提示码
			case Constant.JWT_ERRCODE_EXPIRE:
				PrintWriter printWriter = httpServletResponse.getWriter();
				printWriter.print(ResponseMgr.loginExpire());
				printWriter.flush();
				printWriter.close();
				break;
			// 签名验证不通过
			case Constant.JWT_ERRCODE_FAIL:
				PrintWriter printWriter2 = httpServletResponse.getWriter();
				printWriter2.print(ResponseMgr.noAuth());
				printWriter2.flush();
				printWriter2.close();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
