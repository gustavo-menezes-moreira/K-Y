define(function(){

	var Config = {

		url: "/white/api",

		methodParam: "_method",

		traditionalSerialization: true,

		globalErrors: [
			{
				label: "400 - Bad Request",
				description: "Malformed request: the request you attempted to make, was not identified from the server."
			},
			{
				label: "403 - Forbidden",
				description: "Forbidden. You don't have permission to access this content."
			}
		],
		
		groups: [

			// Login API
			{
				name: "Login",
				endpoints: [
					{
						label: "Login",
						url: "/login",
						method: "POST",
						description: "Spring Security session-based login Endpoint.",
						params: [
							{
								name: "j_username",
								description: "Username."
							},
							{
								name: "j_password",
								description: "Password."
							},
							{
								name: "_spring_security_remember_me",
								value: ["off", "on"],
								description: "When 'on', the session will remain for 2 weeks."
							}
						],
						errors: [
							{
								label: "401 - Unauthorized",
								description: "Authentication Failed: Bad credentials."
							}
						]
					},
					{
						label: "Logout",
						url: "/logout",
						method: "GET",
						description: "Log user out."
					},
					{
						label: "Keep Alive Session",
						url: "/keepAlive",
						method: "GET",
						description: "Used to check if the session is still active and returns the logged user data.",
					}
				]
			}

			// Next Group

		]

	};

	return Config;

});

