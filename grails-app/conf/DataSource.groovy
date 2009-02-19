dataSource {
	pooled = true
	driverClassName = "org.hsqldb.jdbcDriver"
    url = "jdbc:hsqldb:mem:devDB" // For use with the HSQL in-mem db
	username = "sa"
	password = ""
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:hsqldb:./db/devDB"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
            url = "jdbc:hsqldb:file:./db/test"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:oracle:thin:@ta04:1521:ta04"
            driverClassName = "" // To Be Determined.  Find this actually.
            username = "eai"
            password = "eai"
		}
	}
}