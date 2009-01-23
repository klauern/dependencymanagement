dataSource {
	pooled = true
	driverClassName = "org.hsqldb.jdbcDriver"
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
            pooled = false
			dbCreate = "create" // one of 'create', 'create-drop','update'
            driverClassName = "org.apache.derby.jdbc.ClientDriver"
            username = ""
            password = ""
			url = "jdbc:derby://localhost:1527/DepMgmt"
            dialect = "org.hibernate.dialect.DerbyDialect"
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
			url = "jdbc:hsqldb:file:prodDb;shutdown=true"
		}
	}
}