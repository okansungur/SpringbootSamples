create keyspace IF NOT EXISTS mycassandra  WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': '1' };
use mycassandra;
CREATE TABLE IF NOT EXISTS studentdetails(id UUID PRIMARY KEY, studentId bigint, description text);
insert into studentdetails (id,studentId,description) values(4505a950-6e0a-11ec-aecc-0304445a624c,999,'TestData from schema sql');