package com.senla.educationsystem.web.token;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.senla.educationsystem.model.bean.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenManager {
	private static final String KEY = "alina0211";

	public static String generateToken(User user) throws Exception {
		Map<String, Object> tokenData = new HashMap<String, Object>();
		tokenData.put("clientType", "user");
		tokenData.put("userID", user.getId());
		tokenData.put("username", user.getLogin());
		tokenData.put("token_create_date", new Date().getTime());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 1);
		tokenData.put("token_expiration_date", calendar.getTime());

		JwtBuilder jwtBuilder = Jwts.builder();

		jwtBuilder.setExpiration(calendar.getTime());

		jwtBuilder.setClaims(tokenData);
		String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, KEY).compact();

		return token;
	}

	public static boolean validateToken(String token) throws Exception {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(token)
				.getBody();
		Date expirationDate = new Date((Long) claims.get("token_expiration_date"));
		Date now = new Date();
		if (expirationDate.before(now)) {
			return false;
		}
		return true;
	}
}
