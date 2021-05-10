Complete AVRO documentation:
https://docs.oracle.com/database/nosql-12.1.3.0/GettingStartedGuide/avroschemas.html

Compiling the Schema
After creating an Avro schema, you need to compile the created schema using Avro tools. avro-tools-1.7.7.jar is the jar containing the tools.

Syntax to Compile an Avro Schema
java -jar <path/to/avro-tools-1.7.7.jar> compile schema <path/to/schema-file> <destination-folder>



