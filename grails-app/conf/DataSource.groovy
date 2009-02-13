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

            //Uncomment for using the Network-mode Derby client.
            /*
            pooled = false
            driverClassName = "org.apache.derby.jdbc.ClientDriver"
            username = ""
            password = ""
			url = "jdbc:derby://localhost:1527/DepMgmt"
            dialect = "org.hibernate.dialect.DerbyDialect"
            */
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:mem:testDb"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:oracle:thin:@ta04:1521:ta04"
            username = "eai"
            password = "eai"
		}
	}
}