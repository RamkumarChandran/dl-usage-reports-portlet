create table DLUsage_AllocatedStorage (
	id_ LONG not null primary key,
	totalBytes LONG,
	ModifiedUserId LONG,
	modifiedDate DATE null
);