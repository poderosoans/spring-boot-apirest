package com.entel.springboot.backend.apirest.auth;

public class JwtConfig {
	// Static: Es un atributo de la clase, no del objeto, se puede acceder de forma directa Final: No se puede cambiar su valor
	public static final String SECRET_KEY = "alguna.clave.secreta.12345678";

	public static final String PRIVATE_RSA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEA6hhiXUwW8ZcYlFVWPf5vP/I90JPspc4HGYc5G12cJdXmJH5K\r\n" + 
			"UOLGKwkXhbtqLxzUA+MsUfzWQ8eJwI0Zi+f/jY67m49XzzgW9eEGqyJnrkI7ceqI\r\n" + 
			"XrNrdvHQlHg3qf9Ukuhm/hzzrApKEN7O9hortPzCSfY5I/L1pg6hWSHkDS27I+vj\r\n" + 
			"EUipOuuX1X3/9EhV5Q7YlZglc8xcClQvK35FsFICuPVNvqsVVzJ5IOru9P9QRosQ\r\n" + 
			"W7HCtADLOkGnW3gevve8eOxSoyd8v0gc9iKN7c+n4EFD8cyskzRRleURkKaPfNLk\r\n" + 
			"qNY1VZzoqvLb1hy8qZlzjrAxmN54o1I2xNihIQIDAQABAoIBAQDVFq0zT/fyoh91\r\n" + 
			"ptiCRgDurIsoOf7ITuqXikepaWSh7Ds6LNtpFYRd2EDZMuhNSmiTwU6uswA3YoM6\r\n" + 
			"Czad6+jr6mlMCQddUSlVWCjBzueh8Bg8cckAq0G/XA8JlwTUcd+CepqF5cTJbfRN\r\n" + 
			"twOdceUnMo2I1eDdoGOLbPXiNL9qXeCupnuWsk76CnmmoC50fT0Ssw5qh4Qd9m8d\r\n" + 
			"8MuAhEBncY+zD/2GOdAYpSj0WxVn35npBdJFobn6rrFETUKCl9mb3+bwdpQtmvFW\r\n" + 
			"8SyLwteJvM5SQ8nMwM96lGp/f6XZjMm59sY/LILp6r3ousv0K15dNBTJaXkxYTbR\r\n" + 
			"N1K1U6AhAoGBAPemtHlazDWPjugKPbO/Jom7IH5jNoik0+xr2R9vmJVu3sAOmrBj\r\n" + 
			"0+RenlIqs1+t+Oth4t5HRxLGyYqv8x2kxbFGdKSN31FO3eq08mH8retzBp2thc0y\r\n" + 
			"ISAZa2EpW2LdlT2YS1gM3H/BaQbIt9HDl2FGfpikQZUEBtFN3zdiESunAoGBAPH8\r\n" + 
			"sBuxRugiCQIc6i0EBiewMh2C7cEJoTcyIpYhg/sdJ6J+0xxrHa2lyUEL0+REJ3JH\r\n" + 
			"fqRZm/PhpMhfMcY9BVEh4/7SPaGQgZoQxzX+F8HoCiErRgmKylvrF5FY0rbL17vx\r\n" + 
			"pDbK7WA04LxG/JKbmqpGf1S626IP3xFwGO7I0MX3AoGAcLi6ULpZVM/BFjEDILuS\r\n" + 
			"yQIZqi1ydwO/Sk9UhpB+/RV34idDlaH6omnG2lOBTb2cHVdysgXzfcJpney0VfvX\r\n" + 
			"1/bfxL6mtRWWwOwXny4p4495pW+EBYAZv8iSLalrZTbCZUTalntUKfpY2bOmp53F\r\n" + 
			"W4uAt+2bxD4O9FnjjgvfEOUCgYAfiGn6cdNnlGfQGqx5STj0GwWsys7ohLS5WJMh\r\n" + 
			"NSTZqCbuCdDAt0SayCu9iikGacsqHR7nk7W6xgCPC7iUuIbk16G6JvNZBledF+qd\r\n" + 
			"ooq9/dq0D8uEms1bxPrBOe3bXBy0pPxdF3xvOPTAFA/9msFAxwb4p5DPQXoz74OQ\r\n" + 
			"OiLaaQKBgQDIeNbTA2diP41P1eWiUviD6/cgkW4KJlEDcrqONdSbbGGP1vyDkQzQ\r\n" + 
			"K6WgWiuSUduFwYrkBIm/Kc9psZlVRjVKnfrEmp42ywroXngDEMNIPDW2VUQju0Zo\r\n" + 
			"MZLVg1XYRfbiU7EwoSuFn0Ia7f2RiJKRhY3VNcr+PEKkS2Cjrt4dGw==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String PUBLIC_RSA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6hhiXUwW8ZcYlFVWPf5v\r\n" + 
			"P/I90JPspc4HGYc5G12cJdXmJH5KUOLGKwkXhbtqLxzUA+MsUfzWQ8eJwI0Zi+f/\r\n" + 
			"jY67m49XzzgW9eEGqyJnrkI7ceqIXrNrdvHQlHg3qf9Ukuhm/hzzrApKEN7O9hor\r\n" + 
			"tPzCSfY5I/L1pg6hWSHkDS27I+vjEUipOuuX1X3/9EhV5Q7YlZglc8xcClQvK35F\r\n" + 
			"sFICuPVNvqsVVzJ5IOru9P9QRosQW7HCtADLOkGnW3gevve8eOxSoyd8v0gc9iKN\r\n" + 
			"7c+n4EFD8cyskzRRleURkKaPfNLkqNY1VZzoqvLb1hy8qZlzjrAxmN54o1I2xNih\r\n" + 
			"IQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
