JAXB Bindings for WiseML
======

Building
======
No installation is required. To build it, you need 
Java 6 or higher and [Maven](http://maven.apache.org/) 2.0 or higher. 

Before cloning this repository, be sure to enable automatic conversion 
of CRLF/LF on your machine using "git config --global core.autocrlf input". 
For more information, please  refer to http://help.github.com/dealing-with-lineendings/

Clone the repository using "git clone git://github.com/itm/wiseml-java.git"
To build, run "mvn install", this will build the project and place the 
generated jar file in target/ and in your local Maven repository.  

Use in your Maven project
======

Add the following dependency to your pom.xml:

```XML
<dependency>
	<groupId>de.uniluebeck.itm</groupId>
	<artifactId>wiseml-java</artifactId>
	<version>1.0</version>
</dependency>
```

Add the following repositories to your pom.xml:

```XML
<repository>
	<id>wisebed-maven-releases-repository</id>
	<url>http://wisebed.eu/maven/releases/</url>
	<releases>
		<enabled>true</enabled>
	</releases>
	<snapshots>
		<enabled>false</enabled>
	</snapshots>
</repository>
```

If you additionally want to get the newest SNAPSHOT versions of the JAXB Bindings for WiseML please also add the
WISEBED snapshot repository to your project:

```XML
<repository>
	<id>wisebed-maven-repository-snapshots</id>
	<url>http://wisebed.eu/maven/snapshots/</url>
	<releases>
		<enabled>false</enabled>
	</releases>
	<snapshots>
		<enabled>true</enabled>
	</snapshots>
</repository>
```

Contact
======
Any feedback will be greatly appreciated, at the
[JAXB Bindings for WiseML github project page](https://github.com/itm/wiseml-java) or by contacting
[Dennis Pfisterer](mailto:github@farberg.de) or [Daniel Bimschas](mailto:daniel@bimschas.com)
