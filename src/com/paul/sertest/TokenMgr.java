package com.paul.sertest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.paul.sertest.config.Constant;
import com.paul.sertest.model.CheckResult;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 管理所有的Token
 * @author XY
 *
 */
public class TokenMgr {
	
	public static SecretKey generalKey() {
		byte[] encodedKey = Base64.decode(Constant.JWT_SECERT);
	    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	    return key;
	}

	public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey secretKey = generalKey();
		JwtBuilder builder = Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuedAt(now)
				.setIssuer("122.114.214.147")
				.signWith(signatureAlgorithm, secretKey);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date expDate = new Date(expMillis);
			builder.setExpiration(expDate);
		}
		return builder.compact();
	}
	
	public static CheckResult validateJWT(String jwtStr) {
		CheckResult checkResult = new CheckResult();
		Claims claims;
		try {
			claims = parseJWT(jwtStr);
		} catch (ExpiredJwtException e) {
			checkResult.setErrCode(401);
			e.printStackTrace();
		} catch (SignatureException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return checkResult;
	}
	
	public static Claims parseJWT(String jwt) throws Exception {
		SecretKey secretKey = generalKey();
		return Jwts.parser()
			.setSigningKey(secretKey)
			.parseClaimsJws(jwt)
			.getBody();
	}
	
	/**
	 * 生成subject信息
	 * @param user
	 * @return
	 */
//	public static String generalSubject(User user){
//		Gson gson = new Gson();
//		return gson.toJson(user);
//	}
}
