s/collection="oredCriteria"/collection="example.oredCriteria"/g;
s/S014809/${dbschema}/g;
s/S313601/${dbschema}/g;
s/S019999/${dbschema}/g;
s/DB2ADMIN/${dbschema}/g;
s/if test="_parameter != null"/if test="example != null"/g;
s/if test="orderByClause != null"/if test="example.orderByClause != null"/g;
s/order by ${orderByClause}/order by ${example.orderByClause}/g;
s/parameterType="[A-Z|a-z|0-9|\.|_]*"/parameterType="map"/g;

